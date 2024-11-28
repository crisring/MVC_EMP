package kr.co.sist.user.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

public class SearchAllEmpAction implements Action {

	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SearchAllEmpService saes = SearchAllEmpService.getInstance();

		List<MvcEmpDomain> list = saes.searchAllEmp();

		// view로 전달할 데이터를 scope 객체 설정(request, session, application)
		request.setAttribute("empList", list);

		moveURL = "emp/emp_list";
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
