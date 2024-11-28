<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="EmpFormAction에서 제공하는 JSP"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h2>사원정보추가</h2>
		<div>
			<form action="${defaultURL }emp_add_frm_process.do" method="post">
				<input type="hidden" name="cmd" value="EA002">
				<table class="table">

					<tr>
						<td>사원번호</td>
						<td><input type="text" value="${empno }" name="empno"
							readonly="readonly"></td>
					</tr>

					<tr>
						<td>사원명</td>
						<td><input type="text" value="이인혁" name="ename"></td>
					</tr>

					<tr>
						<td>직무</td>
						<td><input type="text" value="개발자" name="job"></td>
					</tr>

					<tr>
						<td>연봉</td>
						<td><input type="text" value="3000" name="sal"></td>
					</tr>

					<tr>
						<td>보너스</td>
						<td><input type="text" value="0" name="comm"></td>
					</tr>

					<tr>
						<td>부서번호</td>
						<td><select name="deptno">
								<c:forEach var="deptno" items="${deptnoList }">
									<option value="${deptno }">
										<c:out value="${deptno }" />번
									</option>
								</c:forEach>

						</select></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input
							type="submit" value="입력" class="btn btn-sm btn-success" /> <input
							type="reset" value="취소" class="btn btn-sm 	btn-danger" /></td>
					</tr>

				</table>
			</form>
		</div>


	</div>
</body>
</html>