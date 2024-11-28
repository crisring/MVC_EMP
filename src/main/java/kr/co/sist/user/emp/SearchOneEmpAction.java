package kr.co.sist.user.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

public class SearchOneEmpAction implements Action {

	private String moveURL;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SearchOneEmpService soes=SearchOneEmpService.getInstance();
		EmpFormService efs=EmpFormService.getInstance();
		
		String empno=request.getParameter("empno");
		
		try {
			MvcEmpDomain med=soes.SearchOneEmp(Integer.parseInt(empno));
			
			request.setAttribute("empData", med);
			request.setAttribute("deptnoList", efs.searchAllDeptno());
			
			moveURL="emp/emp_detail";
			forwardFlag=true;
		}catch(NumberFormatException e) {
			moveURL="emp/emp_err.html";
			forwardFlag=false; // redirect로 이동
		}//end catch
		
		
	}//execute

	@Override
	public String moveURL() {
		return moveURL;
	}//moveURL

	@Override
	public boolean isForward() {
		return forwardFlag;
	}//isForward

}
