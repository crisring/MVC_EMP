<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="SearchAllEmpAction에서 처리한 결과를 보여주는 JSP"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${site_kor }</title>
<link rel="shortcut icon" href="${defaultURL }common/images/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${defaultURL }common/css/main_20240911.css">
<!-- bootstrap CDN 시작-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<!-- bootstrap CDN 끝-->

<style type="text/css">
</style>
<!-- jQuery CDN 시작-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

	}); // document.ready
</script>
</head>
<body>
	<div id="wrap">
		<div>
			<a href="${defaultURL }index.do">메인화면</a> <a
				href="${defaultURL }emp_add_frm.do?cmd=EA001">사원정보추가</a>
		</div>
		<div>
			<h2>사원 정보</h2>
			<table class="table table_hover">
				<thead>
					<tr>
						<th style="width: 10%">번호</th>
						<th style="width: 30%">사원명</th>
						<th style="width: 20%">부서번호</th>
						<th style="width: 20%">연봉</th>
						<th style="width: 20%">입사일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty empList }">
						<tr>
							<td colspan="4" style="text-align: center">사원정보가 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="emp" items="${empList }" varStatus="i">
						<c:set var="sal" value="${emp.sal+sal }" />
						<tr>
							<td><c:out value="${i.count }" /></td>
							<td><a
								href="${defaultURL }emp_detail.do?cmd=ES001&empno=${emp.empno}"><c:out
										value="${emp.ename }" /></a></td>
							<td><c:out value="${emp.deptno }" /></td>
							<td><fmt:formatNumber pattern="0,000" value="${emp.sal }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd EEE"
									value="${emp.hiredate }" /></td>
						</tr>
						<c:if test="${i.last }">
							<td>연봉합계</td>
							<td colspan="4"><c:out value="${sal }" /></td>
						</c:if>

					</c:forEach>

				</tbody>


			</table>
		</div>
	</div>
</body>
</html>