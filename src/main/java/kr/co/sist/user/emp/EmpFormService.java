package kr.co.sist.user.emp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class EmpFormService {

	private static EmpFormService efs;

	private EmpFormService() {
	}

	public static EmpFormService getInstance() {

		if (efs == null) {
			efs = new EmpFormService();
		}
		return efs;
	}// getInstance

	public List<Integer> searchAllDeptno() {
		List<Integer> list = null;

		EmpDAO eDAO = EmpDAO.getInstance();

		try {
			list = eDAO.selectAllDeptno();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}// searchAllDeptno

	public int selectNextEmpno() {
		int empno = 0;

		EmpDAO eDAO = EmpDAO.getInstance();

		try {
			empno = eDAO.selectNextEmpno();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return empno;
	}// searchAllDeptno

}
