package kr.co.sist.user.emp;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisHandler;

public class EmpDAO {
	private static EmpDAO eDAO;
	
	private EmpDAO() {
	}
	
	public static EmpDAO getInstance() {
		if(eDAO==null) {
			eDAO=new EmpDAO();
		}//end return
		return eDAO;
	}//getInstance
	
	public List<MvcEmpDomain> selectAllEmp() throws PersistenceException{
		List<MvcEmpDomain> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		
		SqlSession handler=mbh.getHandler();
		
		try {
			list=handler.selectList("kr.co.sist.emp.selectAllEmp");
		}finally {
			mbh.closeHandler(handler);
		}//end finally
		
		return list;
	}//selectAllEmp
	
	public int selectNextEmpno() throws PersistenceException{
		int empno=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		
		SqlSession handler=mbh.getHandler();
		
		try {
			empno=handler.selectOne("kr.co.sist.emp.selectNextEmpno");
		}finally {
			mbh.closeHandler(handler);
		}//end finally
		
		return empno;
	}//selectNextEmpno
	
	public List<Integer> selectAllDeptno() throws PersistenceException{
		List<Integer> list=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		
		SqlSession handler=mbh.getHandler();
		
		try {
			list=handler.selectList("kr.co.sist.emp.selectAllDeptno");
		}finally {
			mbh.closeHandler(handler);
		}//end finally
		
		return list;
	}//selectAllEmp
	
	public int insertEmp(MvcEmpVO meVO) throws PersistenceException{
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		
		SqlSession handler=mbh.getHandler(true);
		
		try {
			cnt=handler.insert("kr.co.sist.emp.insertEmp", meVO);
		}finally {
			mbh.closeHandler(handler);
		}//end finally
		
		return cnt;
	}//insertEmp
	
	public MvcEmpDomain selectOneEmp( int empno) throws PersistenceException{
		MvcEmpDomain med=null;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		
		SqlSession handler=mbh.getHandler();
		
		try {
			med=handler.selectOne("kr.co.sist.emp.selectOneEmp", empno);
		}finally {
			mbh.closeHandler(handler);
		}//end finally
		
		return med;
	}//selectOneEmp
 	
	public int updateEmp(MvcEmpVO meVO) throws PersistenceException{
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		
		SqlSession handler=mbh.getHandler(true);
		
		try {
			cnt=handler.update("kr.co.sist.emp.updateEmp", meVO);
		}finally {
			mbh.closeHandler(handler);
		}//end finally		
		
		return cnt;
	}//updateEmp
	
	public int deleteEmp(int empno) throws PersistenceException{
		int cnt=0;
		
		MyBatisHandler mbh=MyBatisHandler.getInstance();
		
		SqlSession handler=mbh.getHandler(true);
		
		try {
			cnt=handler.delete("kr.co.sist.emp.deleteEmp", empno);
		}finally {
			mbh.closeHandler(handler);
		}//end finally
		
		return cnt;
	}//deleteEmp
	
	
	
}//class
