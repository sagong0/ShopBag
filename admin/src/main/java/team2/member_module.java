package team2;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("member")
public class member_module {
	
	@Resource(name="sqlsession")
	private SqlSessionTemplate sessionTemplate;
	
	PrintWriter pw = null;
	
	/* admin List 가져오기 */
	public List<memberDto> getAdminLists(String midx,String muse,HttpServletResponse res) throws Exception{
		
		
		List<memberDto> lists = null;
		
		if(muse == null) {
			lists = this.sessionTemplate.selectList("productDB.getAdminLists");
		}
		else if(muse.intern() == "정지"){
			this.sessionTemplate.update("productDB.updateMuseN",midx);
			lists = this.sessionTemplate.selectList("productDB.getAdminLists");
		}
		else if(muse.intern() == "해제"){
			this.pw = res.getWriter();
			this.pw.write("<script>"
					+ "if(confirm('해당 사용자의 계정을 정상으로 변경하시겠습니까?')){"
					+ "location.href='./admin_mainok.do'"
					+ "}</script>");
			this.sessionTemplate.update("productDB.updateMuseY",midx);
			lists = this.sessionTemplate.selectList("productDB.getAdminLists");
			this.pw.close();
		}
		return lists;
	}

	
	
	/* 아아디 중복체크 PART */
	public memberDto getUserById(String mid) {
		
		memberDto mdto = this.sessionTemplate.selectOne("productDB.getListById",mid);
		return mdto;
	}
	
	
	/* 이메일 중복 체크 */
	public Map<String, Object> emailck(String memail) throws Exception {
	
		int result = 0;
		Map<String, Object> mapList = new HashMap<String, Object>(); 
		
		/*인증번호 8자리 랜덤생성*/
		String pcontent = "";
		int w = 0;
		while(w <=7) {
			int a = (int) Math.floor(Math.random()*10);
			pcontent +=a;
			w++;
		}
		
		String host = "smtp.naver.com";
		String user = "1w2q3e@naver.com";
		String password = "rmaksgofk123@";
		String to_mail = memail;
		String ptitle = "이메일 인증";
		String pname = "portfolio admin";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory", 587);
		props.put("mail.smtp.ssl.protocals", "TLSv1.2");
		
		Session session = Session.getDefaultInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		try {
			// MimeMessage : okcall 발생함. 아이디와 패스워드, 모두 맞을 경우
			MimeMessage msg = new MimeMessage(session);	
			msg.setFrom(new InternetAddress(user,pname));	// 보낸이
			// 받는 메일 주소
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_mail));
			msg.setSubject(ptitle);	// 제목
			msg.setText(pcontent);	// 내용
			Transport.send(msg);	// 발송.
			result = 1;
			mapList.put("code", pcontent);
			mapList.put("result", result);
		}
		catch(Exception e) {
			System.out.println("메일 서버 통신 오류 !!");
			result = 0;
			mapList.put("result", result);
		}
		return mapList;
	}


	/*회원 정보 저장*/
	public void insertUser(memberDto mdto,HttpServletResponse res) throws Exception {
		this.pw = res.getWriter();
		
		if(mdto.getMcmail() == null) {
			mdto.setMcmail("N");
		}
		if(mdto.getMcsms() == null) {
			mdto.setMcsms("N");
		}
		int result = this.sessionTemplate.insert("productDB.saveUserInfo",mdto);
		
		if(result == 1) {
			this.pw.write("<script>"
					+ "alert('정상적으로 회원가입이 완료되었습니다.');"
					+ "location.href='shopmain.do';"
					+ "</script>");
		}
		else {
			this.pw.write("<script>"
					+ "alert('회원가입에 실패하였습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
		
	}

	/* 로그인 PART (아이디 비번 체크) */
	public String getUserCheck(String mid,String mpass,HttpServletResponse res) throws Exception {
		memberDto mdto = this.sessionTemplate.selectOne("productDB.getListById",mid);
		String name = "";
		

		this.pw = res.getWriter();
		
		if(mdto == null) {
			// 해당 정보의 사용자가 없는거
			this.pw.write("<script>"
					+ "alert('잘못된 로그인 방식입니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		// 아디는 일단 맞을경우
		else {
			if(mdto.getMpass().intern() == mpass.intern()) {
				// 비번까지맞음 로그인 성공
				this.pw.write("<script>"
						+ "alert('로그인 되셨습니다.');"
						+ "location.href='./shopmain.do';"
						+ "</script>");
				name = mdto.getMname();
			}
			else {
				this.pw.write("<script>"
						+ "alert('해당 사용자 정보를 확인 할 수 없습니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
		}
		this.pw.close();
		return name;
	}
}
