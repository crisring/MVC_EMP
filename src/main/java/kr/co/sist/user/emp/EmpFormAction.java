package kr.co.sist.user.emp;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.sist.action.Action;
import kr.co.sist.user.controller.MainController;

public class EmpFormAction implements Action {

	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmpFormService efs = EmpFormService.getInstance();

		request.setAttribute("empno", efs.selectNextEmpno());
		request.setAttribute("deptnoList", efs.searchAllDeptno());

		// file upload -> 운영환경과 개발환경이 다르다.
		File uploadDir = new File(MainController.uploadDir);
		System.out.println(uploadDir);

		HttpSession session = request.getSession();
		session.setAttribute("addFlag", false);

		moveURL = "emp/emp_add_frm";
		forwardFlag = true;

	}

	@Override
	public String moveURL() {
		return moveURL;
	}

	@Override
	public boolean isForward() {
		return forwardFlag;
	}

}
