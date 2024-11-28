package kr.co.sist.user.emp;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MvcEmpDomain {

	private String ename, job;
	private int empno, sal, comm, deptno;
	private Timestamp hiredate;

}
