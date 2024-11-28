package kr.co.sist.user.emp;

import org.apache.ibatis.exceptions.PersistenceException;

public class SearchOneEmpService {
	private static SearchOneEmpService soes;
	
	private SearchOneEmpService() {
	}
	
	public static SearchOneEmpService getInstance() {
		if(soes==null) {
			soes=new SearchOneEmpService();
		}//end return
		return soes;
	}//getInstance
	
	public MvcEmpDomain SearchOneEmp(int empno) {
		MvcEmpDomain med=null;
		
		EmpDAO eDAO=EmpDAO.getInstance();
		try {
			med=eDAO.selectOneEmp(empno);
			med.setEmpno(empno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return med;
	}//SearchOneEmp
	
	
}
