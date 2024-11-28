package kr.co.sist.user.emp;

import org.apache.ibatis.exceptions.PersistenceException;

public class EmpFormProcessService {

	private static EmpFormProcessService efps;

	private EmpFormProcessService() {
	}

	public static EmpFormProcessService getInstance() {

		if (efps == null) {
			efps = new EmpFormProcessService();
		}
		return efps;
	}// getInstance

	public boolean addEmp(MvcEmpVO meVO) {
		boolean flag = false;
		EmpDAO empDAO = EmpDAO.getInstance();

		try {
			flag = empDAO.insertEmp(meVO) == 1;

		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}

		return flag;
	}// addEmp

}
