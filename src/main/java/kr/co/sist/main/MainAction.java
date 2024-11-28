package kr.co.sist.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.sist.action.Action;

public class MainAction implements Action {

	private String moveURL;
	private boolean forwardFlag;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		moveURL = "index";
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
