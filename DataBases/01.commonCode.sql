delete
from CIP_COMMON_CODE;

insert into CIP_COMMON_CODE 
(COMMON_CODE_ID,NAME,ORDER_NUMBER,ATTRIBUTION_1,ATTRIBUTION_2,DESCRIPTION,SYSTEM_CODE_YN,USE_YN,PARENT_COMMON_CODE_ID,REGISTER_SEQ,REGISTRY_DATE,MODIFIER_SEQ,MODIFY_DATE) 
VALUES
('Use_YN','Yes or No',1,NULL,NULL,'Using Yes or No','Yes','Yes',NULL,'UUID-1111-1111111',sysdate(),'UUID-1111-1111111',sysdate()), 
('Yes','Yes',1,NULL,NULL,'Using Yes','System_Code_Yes','Yes','Use_YN','UUID-1111-1111111',sysdate(),'UUID-1111-1111111',sysdate()), 
('No','No',2,NULL,NULL,'Using No','System_Code_Yes','Yes','Use_YN','UUID-1111-1111111',sysdate(),'UUID-1111-1111111',sysdate()), 
('System_Code_YN','Sytem Yes or No',1,NULL,NULL,'Sytem Using Yes or No','Yes','Yes',NULL,'UUID-1111-1111111',sysdate(),'UUID-1111-1111111',sysdate()), 
('System_Code_Yes','Yes',1,NULL,NULL,'Sytem Using Yes','Yes','Yes','System_Code_YN','UUID-1111-1111111',sysdate(),'UUID-1111-1111111',sysdate()), 
('System_Code_No','No',2,NULL,NULL,'Sytem Using No','Yes','Yes','System_Code_YN','UUID-1111-1111111',sysdate(),'UUID-1111-1111111',sysdate()), 
('CC0001', 'Male', 1, NULL, NULL, 'Male gender', 'Yes', 'Yes', NULL, 'RS0001', '2022-01-01', 'MS0001', '2022-01-01'),
('CC0002', 'Female', 2, NULL, NULL, 'Female gender', 'Yes', 'Yes', 'CC0001', 'RS0001', '2022-01-01', 'MS0001', '2022-01-01'),
('CC0003', 'Other', 3, NULL, NULL, 'Other gender', 'Yes', 'Yes', NULL, 'RS0001', '2022-01-01', 'MS0001', '2022-01-01'),
('CC0004', 'Red', 1, NULL, NULL, 'Color red', 'N', 'Yes', 'CC0005', 'RS0002', '2022-02-01', 'MS0002', '2022-02-01'),
('CC0005', 'Colors', 4, NULL, NULL, 'All colors', 'Yes', 'Yes', 'CC0001', 'RS0002', '2022-02-01', 'MS0002', '2022-02-01'),
('CC0006', 'Blue', 2, NULL, NULL, 'Color blue', 'N', 'Yes', 'CC0005', 'RS0002', '2022-02-01', 'MS0002', '2022-02-01'),
('CC0007', 'Green', 3, NULL, NULL, 'Color green', 'N', 'Yes', 'CC0005', 'RS0002', '2022-02-01', 'MS0002', '2022-02-01'),
('CC0008', 'Yellow', 4, NULL, NULL, 'Color yellow', 'N', 'Yes', 'CC0005', 'RS0002', '2022-02-01', 'MS0002', '2022-02-01');