package kr.co.sist.user.emp;

import org.apache.ibatis.exceptions.PersistenceException;

public class EmpRemoveService {
	private static EmpRemoveService ers;
	
	private EmpRemoveService() {
	}
	
	public static EmpRemoveService getInstance() {
		if(ers==null) {
			ers=new EmpRemoveService();
		}//end return
		return ers;
	}//getInstance
	
	public boolean removeEmp(int empno){
		boolean flag=false;
		
		EmpDAO eDAO=EmpDAO.getInstance();
		try {
			flag=eDAO.deleteEmp(empno)==1;
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return flag;
	}//removeEmp
	
	
}
