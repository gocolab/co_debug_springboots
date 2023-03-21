package com.test.codingtest_springboots.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component
public class CommonUtils {
    public String getUniqueSequence() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    // "src/main/resources/static/files/" -> root directory + 상대 경로
    public String getRelativeToAbsolutePath(String relativePath) {
        String relativePathWithSeparator = relativePath.replace("/", File.separator);
        String absolutePath = new File(relativePathWithSeparator).getAbsolutePath() + File.separator;
        return absolutePath;
    }

    public List getFilesInformation(MultipartHttpServletRequest multipartHttpServletRequest,
            Map<String, Object> params) throws IllegalStateException, IOException {
        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        String absolutePath = this.getRelativeToAbsolutePath("src/main/resources/static/files/");

        Map attachfile = null;
        List attachfiles = new ArrayList();
        String physicalFileName = this.getUniqueSequence();
        String storePath = absolutePath + physicalFileName + File.separator;
        File newPath = new File(storePath);
        newPath.mkdir(); // create directory
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            String originalFilename = multipartFile.getOriginalFilename();

            if (originalFilename != null && multipartFile.getSize() > 0) {
                String storePathFileName = storePath + originalFilename;
                multipartFile.transferTo(new File(storePathFileName));

                // add SOURCE_UNIQUE_SEQ, ORGINALFILE_NAME, PHYSICALFILE_NAME in HashMap
                attachfile = new HashMap<>();
                attachfile.put("ATTACHFILE_SEQ", this.getUniqueSequence());
                attachfile.put("SOURCE_UNIQUE_SEQ", params.get("COMMON_CODE_ID"));
                attachfile.put("ORGINALFILE_NAME", originalFilename);
                attachfile.put("PHYSICALFILE_NAME", physicalFileName);
                attachfile.put("REGISTER_SEQ", params.get("REGISTER_SEQ"));
                attachfile.put("MODIFIER_SEQ", params.get("MODIFIER_SEQ"));

                attachfiles.add(attachfile);
            }
        }
        return attachfiles;
    }
}
