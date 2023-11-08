package app;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class site_module1 {
	
	SqlSession se = null;
	
	private site_dto dto;
	
	public site_module1(SqlSessionFactory sqlsessionfactory) {
		this.se = sqlsessionfactory.openSession();
	}
	
	public site_dto check() {
		
		try {
			this.dto = this.se.selectOne("productDB.site_info");
			this.se.close();
		}
		catch(Exception e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
		
		
		return this.dto;
	}
}
