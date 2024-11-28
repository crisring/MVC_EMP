<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ site_kor }</title>
<link rel="shotcut icon" href="${ defaultURL }common/images/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="${ defaultURL }common/css/main_20240911.css">
<!-- bootstrap CDN 시작 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">

</style>
<script type="text/javascript">
$(function(){

});//ready
</script>
</head>
<body>
<div id="wrap">
	<c:choose>
	<c:when test="${ empRemoveResult }">
	<img alt="성공" src="${ defaultURL }emp/images/add_success.png">
	<br>
	<c:out value="${ param.ename }"/>사원정보가 삭제되었습니다<br>
	</c:when>
	<c:otherwise>
	<img alt="실패" src="${ defaultURL }emp/images/add_fail.png">
	<br>
	<c:out value="${ param.ename }"/>사원정보 삭제 실패<br>
	</c:otherwise>
	</c:choose>
	<br>
	<a href="${ defaultURL }emp_list.do?cmd=ESA001">사원정보조회</a>
	<a href="${ defaultURL }index.do">메인화면</a>
</div>
</body>
</html>