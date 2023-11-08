package team2;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class config_module {
	SqlSession se = null;
	
	public config_module(SqlSessionFactory sqlsessionfactory) {
		this.se = sqlsessionfactory.openSession();
	}
	
	public int config_insert(config_dto config_dto) {
		int result = 0;
		try {
			result = this.se.insert("productDB.config_insert",config_dto);	
		}
		catch(Exception e) {
			System.out.println("SQL 문법 오류 발생!!");
			e.printStackTrace();
		}
		finally {
			this.se.close();
		}
		return result;
	}	
}