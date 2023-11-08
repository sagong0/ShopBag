package app;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("address")
public class address_module {
	
	@Resource(name = "sqlsession")
	private SqlSessionTemplate session;
	
	int result = 0;
	
	public String address_insert(address_dto dto) {
		this.result = this.session.insert("productDB.add_insert", dto);
		
		if(this.result == 1) {
			System.out.println("정상적으로 우편번호 등록 완료되었습니다.");
		}
		else {
			System.out.println("우편번호 등록에 실패하였습니다.");
		}
		
		return null;
	}
}
