package kr.co.sist.user.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

public class EmpModifyAction implements Action {

	private String moveURL;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MvcEmpVO meVO=new MvcEmpVO();
		try {
			meVO.setEmpno(Integer.parseInt(request.getParameter("empno")));
			meVO.setEname(request.getParameter("ename"));
			meVO.setJob(request.getParameter("job"));
			meVO.setSal(Integer.parseInt(request.getParameter("sal")));
			meVO.setComm(Integer.parseInt(request.getParameter("comm")));
			meVO.setDeptno(Integer.parseInt(request.getParameter("deptno")));
			
			EmpModifyService eus=EmpModifyService.getInstance();
			
			request.setAttribute("empModifyResult", eus.modifyEmp(meVO));
			
			moveURL="emp/modify_result";
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
