<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <div>jstl Formats</div>
    <div>
    234124.12 --> 234,124.12
    2023.01.16 10:18.50 --> 2023 1 16, 
    </div>
    <hr />
    <div>jstl Formats - Number</div>
    <c:set var="num_first" value="1234567.89" />
    <div>세자리 구분 : <fmt:formatNumber value="${num_first}" type="number" /> </div>
    <c:set var="num_second" value="0.1234" />
    <div>백분율 : <fmt:formatNumber value="${num_second}" type="percent" /> </div>

    <hr />
    <div>jstl Formats - Date</div>
    <div> Data date_first = new java.util.Date() ;</div>
    <c:set var="date_first" value="<%= new java.util.Date() %>" />
    <div>값 출력 : ${date_first}</div>
    <div>time 출력 : <fmt:formatDate value="${date_first}" type="time" /> </div>
    <div>date 출력 : <fmt:formatDate value="${date_first}" type="date" /> </div>
    <div>date and time : <fmt:formatDate value="${date_first}" type="both" /></div>

    <hr />
    <div>jstl Formats - Location </div>
    <div> Locale Code : http://www.lingoes.net/en/translator/langcode.htm </div>
    <c:set var="num_third" value="1234567.89" />
    <c:set var="date_third" value="<%= new java.util.Date() %>" />
    <div> 대한민국 나라 : <fmt:setLocale value="ko-KR" scope="session"/> <%=response.getLocale() %> </div>
    <div> 통화 : <fmt:formatNumber value="${num_third}" type="currency" /> </div>
    <div> 날짜 : <fmt:formatDate value="${date_third}" type="both" /> </div>

    <div> 미국 나라 : <fmt:setLocale value="en-US" scope="session" /> <%=response.getLocale() %> </div>
    <div> 통화 : <fmt:formatNumber value="${num_third}" type="currency" /> </div>
    <div> 날짜 : <fmt:formatDate value="${date_third}" type="both" /> </div>

    <div> 나라 : <fmt:setLocale value="ja-JP" scope="session" /> <%=response.getLocale() %> </div>
    <div> 통화 : <fmt:formatNumber value="${num_third}" type="currency" /> </div>
    <div> 날짜 : <fmt:formatDate value="${date_third}" type="both" /> </div>

    <div> </div>
    <div> </div>



</body>

</html>