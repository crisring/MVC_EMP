package kr.co.sist.user.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

public class EmpRemoveAction implements Action {

	private String moveURL;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpRemoveService ers=EmpRemoveService.getInstance();
		int empno=Integer.parseInt(request.getParameter("empno"));
		
		try {
			
			request.setAttribute("empRemoveResult", ers.removeEmp(empno));
			
			moveURL="emp/remove_result";
			forwardFlag=true;
		}catch(NumberFormatException nfe) {
			moveURL="emp/emp_err.html";
			forwardFlag=false;
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

}//class
