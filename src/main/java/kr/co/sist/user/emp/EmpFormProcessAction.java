package kr.co.sist.user.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.action.Action;

public class EmpFormProcessAction implements Action {

	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MvcEmpVO meVo = new MvcEmpVO();
		meVo.setEmpno(Integer.parseInt(request.getParameter("empno")));
		meVo.setEname(request.getParameter("ename"));
		meVo.setJob(request.getParameter("job"));
		meVo.setSal(Integer.parseInt(request.getParameter("sal")));
		meVo.setComm(Integer.parseInt(request.getParameter("comm")));
		meVo.setDeptno(Integer.parseInt(request.getParameter("deptno")));

		EmpFormProcessService efps = EmpFormProcessService.getInstance();

		// 1. 세션 얻기
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("addFlag");
		Boolean flag = false;

		if (obj != null) {
			flag = ((Boolean) obj).booleanValue();
		}

		if (!flag) {
			session.setAttribute("empAddResult", efps.addEmp(meVo));
			session.setAttribute("addFlag", true);
		}

		moveURL = "emp/add_result";
		forwardFlag = true;
	}// execute

	@Override
	public String moveURL() {
		return moveURL;
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

}
