package kr.co.sist.user.emp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

public class SearchAllEmpService {

	private static SearchAllEmpService saes;

	private SearchAllEmpService() {
	}

	public static SearchAllEmpService getInstance() {

		if (saes == null) {
			saes = new SearchAllEmpService();
		}
		return saes;
	}// getInstance

	public List<MvcEmpDomain> searchAllEmp() {
		List<MvcEmpDomain> list = null;

		EmpDAO eDAO = EmpDAO.getInstance();

		try {
			list = eDAO.selectAllEmp();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
		}
		return list;
	}

}
