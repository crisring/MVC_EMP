<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="SearchOneEmpAction의 결과를 보여주는 JSP"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ site_kor }</title>
<link rel="shotcut icon" href="${ defaultURL }common/images/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${ defaultURL }common/css/main_20240911.css">
<!-- bootstrap CDN 시작 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- jQuery CDN 시작 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$("#btnUpdate").click(function() {
			document.empDetailFrm.action = "emp_modify.do";
			$("#cmd").val("EU001");
			$("#empDetailFrm").submit();
		});

		$("#btnDelete").click(function() {
			document.empDetailFrm.action = "emp_remove.do";
			$("#cmd").val("ED001");
			$("#empDetailFrm").submit();
		});
	});//ready
</script>
</head>
<body>
	<div id="wrap">
		<h2>사원 정보 조회</h2>
		<div>
			<form id="empDetailFrm" name="empDetailFrm" method="post">
				<input type="hidden" name="cmd" id="cmd" />
				<table>
					<tr>
						<td>사원번호</td>
						<td><input type="text" value="${ empData.empno }"
							name="empno" readonly="readonly" /></td>
					</tr>
					<tr>
						<td>사원명</td>
						<td><input type="text" value="${ empData.ename }"
							name="ename" /></td>
					</tr>
					<tr>
						<td>직무</td>
						<td><input type="text" value="${ empData.job }" name="job" /></td>
					</tr>
					<tr>
						<td>연봉</td>
						<td><input type="text" value="${ empData.sal }" name="sal" /></td>
					</tr>
					<tr>
						<td>보너스</td>
						<td><input type="text" value="${ empData.comm }" name="comm" /></td>
					</tr>
					<tr>
						<td>부서번호</td>
						<td><select name="deptno">
								<c:forEach var="deptno" items="${ deptnoList }" varStatus="i">
									<option value="${ deptno }"
										${deptno eq empData.deptno ? "selected" : ""}><c:out
											value="${ deptno }" />번
									</option>

								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><input
							type="button" value="수정" id="btnUpdate"
							class="btn btn-sm btn-success"> <input type="button"
							value="삭제" id="btnDelete" class="btn btn-sm btn-danger"><br>
							<a href="${ defaultURL }index.do">메인화면</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>