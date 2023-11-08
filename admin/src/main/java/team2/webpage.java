package team2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller	
public class webpage {
	
	
	
	
	PrintWriter pw = null;
	HttpSession session = null;
	
	@Inject
	private SqlSessionFactory sqlsessionfactory;
	
	@Resource
	private SqlSessionTemplate sqlsession;
	
	
	/*쇼핑몰 메인page*/
	@RequestMapping("shop/shopmain.do")
	public String shop_main(Model m) {
		
		SqlSession se = null;
		
		try {
			se = sqlsessionfactory.openSession();
			List<p_dto> p_lists = se.selectList("productDB.p_mainPlists");
			config_dto dto = se.selectOne("productDB.config_select"); 
			m.addAttribute("p_lists",p_lists);
			m.addAttribute("siteInfo",dto);
		}
		catch(Exception e) {
			System.out.println("main 상품 출력 쿼리 PART 에러 발생");
			e.printStackTrace();
		}
		
		return "shop/index";
	}
	
	
	
	
	
	/* 상품 삭제 PART */
	@RequestMapping("admin/p_delete.do")
	public void p_delete(
			HttpServletResponse res,
			@RequestParam(defaultValue = "1") int pidx
			) {
		res.setContentType("text/html; charset=utf-8;");
		
		//System.out.println(pidx);
		PrintWriter pw = null;
		
		SqlSession se = null;
		
		try {
			pw = res.getWriter();
			
			se = sqlsessionfactory.openSession();
			int result = se.delete("productDB.p_delete",pidx);
			
			if(result ==1) {
				pw.write("<script>"
						+ "alert('해당 상품이 삭제 되었습니다.');"
						+ "location.href='./plists.do';"
						+ "</script>");
			}
			else {
				pw.write("<script>"
						+ "alert('삭제에 실패하였습니다.');"
						+ "history.go(-1);;"
						+ "</script>");
			}
			
			se.close();
			pw.close();
		}
		catch(Exception e) {
			System.out.println("상품 삭제 query 에러");
			e.printStackTrace();
		}
	}
	
	
	
	/*관리자 상품 list page PART*/
	@RequestMapping("admin/plists.do")
	public String p_regok(
			Model m,
			@ModelAttribute SearchDTO sdto,
			//@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "1") int pidx
			){
		SqlSession se = null;
		
		try {
			se = sqlsessionfactory.openSession();
			List<p_dto> lists = null;
			int ct = 0;
			
			if(pidx < 2) {
				pidx =0;
			}
			else {
				pidx = (pidx-1)*5;
			}
			
			Map<String, Object> searchMap = new HashMap<String, Object>();
			
			if(sdto==null || sdto.getSearchVal() == null || sdto.getSearchType() == null) {
				lists =se.selectList("productDB.p_selectAllProducts",pidx);
			}
			else {
				if(sdto.getSearchType().equals("상품명")){
					searchMap.put("part", "pname");
				}
				else if(sdto.getSearchType().equals("상품코드")){
					searchMap.put("part", "pcode");					
				}
				searchMap.put("searchVal", sdto.getSearchVal());
				lists =se.selectList("productDB.p_selectBySearch",searchMap);
				
				m.addAttribute("sdto",sdto);
			}
			
			m.addAttribute("plists",lists);
			
			ct = se.selectOne("productDB.p_countSelect",searchMap);
			m.addAttribute("ct",ct);
			
			se.close();
		}
		catch(Exception e) {
			System.out.println("상품 출력 select 쿼리부분 에러");
			e.printStackTrace();
		}
		
		return "admin/admin_product";
	}
	
	
	@Resource(name = "product")
	private produdct_module pm;
	
	/* 상품코드 중복체크 PART */
	@RequestMapping("admin/pcodeck.do")
	public String pcode_ck(Model m, @RequestParam(required = false) String pcode){

		p_dto pdto =this.pm.pcode_check(pcode);
		if(pdto == null) {
			m.addAttribute("pcodeCK","no");
		}
		else {
			m.addAttribute("pcodeCK","yes");
		}
		
		
		return "admin/pcodeck";
	}
	
	
	
	/*상품 등록 버튼 PART*/
	@RequestMapping("admin/product_register.do")
	public String p_register(
			MultipartFile[] mfile,HttpServletRequest req,
			@ModelAttribute("product2") p_dto pdto,
			HttpServletResponse res
			) throws IOException {
		res.setContentType("text/html; charset=utf-8;");
		
		this.pw = res.getWriter();

		int result = this.pm.fileUpload(mfile,pdto);
		if(result >= 1) {	
			this.pw.write("<script>"
					+ "alert('상품이 정상적으로 등록되었습니다.');"
					+ "location.href='./plists.do'"
					+ "</script>");
		}
		else {
			this.pw.write("<script>"
					+ "alert('상품 등록에 실패하셨습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
		
		return null;
	}

	/* 관리자 로그인 로직 PART */
	HttpSession httpsession = null;
	@RequestMapping("admin/admin_main.do")
	public void maindo(
			HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam(required = false) String aid,
			@RequestParam(required = false) String apw
			) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		this.pw = res.getWriter();
		
		if(aid == null || apw == null) {
			this.pw.write("<script>"
					+ "alert('정상적인 접근이 아닙니다.');"
					+ "location.href='./index.jsp';"
					+ "</script>");
		}
		else if(aid.intern()=="master" && apw.intern()=="shop_master123") {
			this.httpsession = req.getSession(true);
			this.httpsession.setAttribute("name", "최고 관리자");
			
			this.pw.write("<script>"
					+ "alert('정상적으로 로그인되었습니다.');"
					+ "location.href='./admin_mainok.do';"
					+ "</script>");
		}
		else {
			this.pw.write("<script>"
					+ "alert('계정을 확인해주세요.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
	}
	
	/* 관리자 로그아웃 PART */
	@RequestMapping("admin/admin_logout.do")
	public String admin_logout(HttpServletRequest req) {
		this.httpsession = req.getSession(true);
		this.httpsession.invalidate();
		return "admin/index";
	}
	
	
	
	
	/* ************************************************ */
	
	@Resource(name = "member")
	private member_module member_module;
	
	/* 관리자 로그인 성공 후 회원리스트 PART */
	@RequestMapping("admin/admin_mainok.do")
	public String admin_mainok(
			HttpServletResponse res,
			Model m,
			@RequestParam(required = false) String idx,
			@RequestParam(required = false) String muse) throws Exception {
		res.setContentType("text/html; charset=utf-8;");

		List<memberDto> lists = this.member_module.getAdminLists(idx,muse,res);
		m.addAttribute("lists",lists);
		return "admin/admin_main";
	}
	
	/* 메인 로그인페이지 이동 PART */
	@RequestMapping("shop/loginok.do")
	public String loginOk(
			HttpServletRequest req,
			HttpServletResponse res,
			@RequestParam(required = false) String uid,
			@RequestParam(required = false) String upw) {
		res.setContentType("text/html; charset=utf-8;");
		
		try {
			String name = this.member_module.getUserCheck(uid, upw,res);
			this.session = req.getSession();
			this.session.setAttribute("userName", name);
		}
		catch (Exception e) {
			System.out.println("로그인 에러");
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping("shop/login.do")
	public void login() {}
	
	@RequestMapping("shop/logoutok.do")
	public String logoutPage(HttpServletRequest req) {
		this.session = req.getSession();
		this.session.invalidate();
		
		return "redirect:shopmain.do";
	}
	
	
	/* 회원가입 클릭시 약관동의 이동 PART */
	@RequestMapping("shop/agree.do")
	public String agree() {		
		return null;
	}
	
	
	/* 회원가입 PART */
	@RequestMapping("shop/join.do")
	public String join() {
		System.out.println("aaa");
		
		return null;
	}
	
	
	
	/* 아이디 중복체크 */
	@PostMapping("shop/idck.do")
	public String idck(String id,Model m) {
		System.out.println("id : "+id);
	 	memberDto mdto = this.member_module.getUserById(id);
		if(mdto == null) {
			m.addAttribute("msg","use");
		}
		else {
			m.addAttribute("msg","nouse");
		}
		
		return "shop/idck";
	}
	
	
	
	
	
	/*이메일 인증번호 발송*/
	@RequestMapping("shop/emailck.do")
	public String email_ck(String memail,Model m) throws Exception {
		
		Map<String, Object> result = this.member_module.emailck(memail);
		String code = (String) result.get("code");
		int sign = (int) result.get("result");
		
		
		if(sign == 1) {
			m.addAttribute("msg","success");
			m.addAttribute("code",code);
		}
		else {
			m.addAttribute("msg","fail");
			m.addAttribute("code",code);
		}
		
		return "shop/emailck";
	}
	
	
	/*회원가입 완료시*/
	@RequestMapping("shop/joinok.do")
	public String joinOK(@ModelAttribute memberDto mdto, HttpServletResponse res) throws Exception {
		res.setContentType("text/html; charset=utf-8;");
		
		this.member_module.insertUser(mdto,res);
		
		return null;
	}

	
	
	
	
	@SuppressWarnings("unused")
	@RequestMapping("/admin/admin_configok.do")	
	public void admin_config(@ModelAttribute config_dto config_dto, Model m, HttpServletResponse res) throws Exception {
		res.setContentType("text/html;charset=utf-8");
		List<config_dto> data = null;
		//Module
		config_module ci = new config_module(sqlsessionfactory);
		int result = ci.config_insert(config_dto);
		try {
			if(result == 1) {
			this.pw = res.getWriter();
			this.pw.write("<script>"
					+ "alert('정상적으로 반영 되었습니다.');"
					+ "location.href='./admin_config.do';"
					+ "</script>");
			}
		}
		catch(Exception e) {
			System.out.println("Database 오류발생!!");
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/admin/admin_config.do")	
	public String admin_config_view(Model m) {
		SqlSession se = sqlsessionfactory.openSession();
		config_dto dto = se.selectOne("productDB.config_select");  
	
		//System.out.println(dto.getSite_title());
		m.addAttribute("data",dto);
		se.close();	
		return "/admin/admin_config";
	}
}









