package kr.co.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 웹 파라메터 받기, 응답할페이지명반환, 페이지이동방식, 업무로직을 실행하는 클래스를 사용
 */

public interface Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	/**
	 * 응답할 페이지명 반환
	 * 
	 * @return
	 */
	public String moveURL();

	/**
	 * 이동방식의 반환
	 * 
	 * @return true - forward, false- redirect
	 */
	public boolean isForward();

}
