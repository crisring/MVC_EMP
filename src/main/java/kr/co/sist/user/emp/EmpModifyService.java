package kr.co.sist.user.emp;

import org.apache.ibatis.exceptions.PersistenceException;

public class EmpModifyService {
	private static EmpModifyService efps;
	
	private EmpModifyService() {
	}
	
	public static EmpModifyService getInstance() {
		if(efps==null) {
			efps=new EmpModifyService();
		}//end return
		return efps;
	}//getInstance
	
	public boolean modifyEmp(MvcEmpVO meVO){
		boolean flag=false;
		
		EmpDAO eDAO=EmpDAO.getInstance();
		try {
			flag=eDAO.updateEmp(meVO)==1;
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//end catch
		
		return flag;
	}//addEmp
	
	
}
