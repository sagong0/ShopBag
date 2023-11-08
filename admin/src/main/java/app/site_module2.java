package app;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("data1")
public class site_module2 {
	
	@Resource(name = "sqlsession")
	private SqlSessionTemplate session;
	private site_dto dto;
	
	public site_dto select2 () {
		
		this.dto = this.session.selectOne("productDB.site_info");
				
		return this.dto;
	}
}
