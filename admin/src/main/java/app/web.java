package app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class web {
	/*
	@Inject SqlSessionFactory sqlsessionfactory;
	
	@RequestMapping("test.do")
	public String test(Model m) {
		
		site_module1 sm1 = new site_module1(sqlsessionfactory);
		site_dto dto = sm1.check();
		
		m.addAttribute("dto",dto);
		
		return "app/test";
	}
	*/
	
	@Resource(name = "data1")
	
	private site_module2 sm2;
	private site_dto dto;
	
	@RequestMapping("test.do")
	public String test(Model m) {
		
		this.dto = this.sm2.select2();
		
		m.addAttribute("dto", this.dto);
		return "app/test";
	}
	
	
	
	@Resource(name = "address")
	private address_module am;
	
	@RequestMapping("addressok.do")
	public String addressok(@ModelAttribute address_dto dto) {
		
		this.am.address_insert(dto);
		
		return null;
	}
	
	
}
