/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.85
 * Generated at: 2023-11-06 01:32:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import team2.SearchDTO;
import team2.p_dto;
import java.util.List;

public final class admin_005fproduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/admin/./menu.jsp", Long.valueOf(1698137132989L));
    _jspx_dependants.put("/admin/./footer.jsp", Long.valueOf(1696323832366L));
    _jspx_dependants.put("/admin/./top.jsp", Long.valueOf(1696324062141L));
    _jspx_dependants.put("/admin/./product.jsp", Long.valueOf(1699234345965L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("team2.p_dto");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("team2.SearchDTO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

 Date apday = new Date();
 SimpleDateFormat apsf = new SimpleDateFormat("yyyyMMddHHmmss");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>관리자 등록 페이지</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/basic.css?v=");
      out.print(apsf.format(apday));
      out.write("\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/login.css?v=");
      out.print(apsf.format(apday));
      out.write("\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/main.css?v=");
      out.print(apsf.format(apday));
      out.write("\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/subpage.css?v=");
      out.print(apsf.format(apday));
      out.write("\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/product.css?v=");
      out.print(apsf.format(apday));
      out.write("\">\r\n");
      out.write("    <link rel=\"icon\" href=\"./img/logo.png\" sizes=\"128x128\">\r\n");
      out.write("    <link rel=\"icon\" href=\"./img/logo.png\" sizes=\"64x64\">\r\n");
      out.write("    <link rel=\"icon\" href=\"./img/logo.png\" sizes=\"32x32\">\r\n");
      out.write("    <link rel=\"icon\" href=\"./img/logo.png\" sizes=\"16x16\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header class=\"headercss\">\r\n");
      out.write("   ");
      out.write('\r');
      out.write('\n');

String name =(String) session.getAttribute("name");

      out.write("    \r\n");
      out.write("\r\n");
      out.write(" <div class=\"header_div\">\r\n");
      out.write("        <p><img src=\"./img/logo.png\" class=\"logo_sm\"> ADMINISTRATOR</p>\r\n");
      out.write("        <p>");
      out.print(name );
      out.write(" <a href=\"#\">[개인정보 수정]</a> <a onclick=\"logout();\" href=\"./admin_logout.do\">[로그아웃]</a></p>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("	window.onload = function(){\r\n");
      out.write("		var admin = \"");
      out.print(name);
      out.write("\";\r\n");
      out.write("		\r\n");
      out.write("		console.log(admin);\r\n");
      out.write("		if(admin == \"\" || admin==\"null\"){\r\n");
      out.write("			alert(\"정상적인 접근이아닙니다.\");\r\n");
      out.write("			location.href=\"./index.jsp\";\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("<nav class=\"navcss\">\r\n");
      out.write(" ");
      out.write("\r\n");
      out.write("   <div class=\"nav_div\">\r\n");
      out.write("        <ol>\r\n");
      out.write("            <li title=\"쇼핑몰 회원관리\"><a href=\"./admin_mainok.do\">쇼핑몰 회원관리</a></li>\r\n");
      out.write("            <li title=\"쇼핑몰 상품관리\"><a href=\"./plists.do\">쇼핑몰 상품관리</a></li>\r\n");
      out.write("            <li title=\"쇼핑몰 기본설정\"><a href=\"./admin_config.do\">쇼핑몰 기본설정</a></li>\r\n");
      out.write("        </ol>\r\n");
      out.write("    </div>");
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("<main class=\"maincss\">\r\n");
      out.write("<section>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

Date pdday = new Date();
SimpleDateFormat pdsf = new SimpleDateFormat("yyyyMMddHHmmss");


List<p_dto> plists = (List<p_dto>)request.getAttribute("plists");
int total = (int) request.getAttribute("ct");

SearchDTO sdto =(SearchDTO) request.getAttribute("sdto");

      out.write("    \r\n");
      out.write("<p>상품관리 페이지</p>\r\n");
      out.write("    <div class=\"subpage_view\">\r\n");
      out.write("        <span>등록된 상품 ");
      out.print(total);
      out.write("건</span>\r\n");
      out.write("        <form id=\"sf\" method=\"post\" action=\"./plists.do\">\r\n");
      out.write("	        <span>\r\n");
      out.write("	            <select class=\"p_select1\" name=\"searchType\">\r\n");
      out.write("	            ");

				String pnameSelect = "";
				String pcodeSelect = "";
				
				if (sdto != null) {
				    if ("상품명".equals(sdto.getSearchType())) {
				        pnameSelect = "selected";
				    } 
				    else if ("상품코드".equals(sdto.getSearchType())) {
				        pcodeSelect = "selected";
				    }
				}
				
      out.write("\r\n");
      out.write("	                <option ");
      out.print(pnameSelect );
      out.write(">상품명</option>\r\n");
      out.write("	                <option ");
      out.print(pcodeSelect );
      out.write(">상품코드</option>\r\n");
      out.write("	            </select>\r\n");
      out.write("	            <input type=\"text\" name=\"searchVal\" class=\"p_input1\" placeholder=\"검색어를 입력해 주세요\">\r\n");
      out.write("	            <input type=\"submit\" value=\"검색\" title=\"상품검색\" class=\"p_submit\">\r\n");
      out.write("	        </span>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"subpage_view2\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><input type=\"checkbox\"></li>\r\n");
      out.write("            <li>코드</li>\r\n");
      out.write("            <li>이미지</li>\r\n");
      out.write("            <li>상품명</li>\r\n");
      out.write("            <li>카테고리 분류</li>\r\n");
      out.write("            <li>판매가격</li>\r\n");
      out.write("            <li>할인가격</li>\r\n");
      out.write("            <li>할인율</li>\r\n");
      out.write("            <li>재고현황</li>\r\n");
      out.write("            <li>판매유/무</li>\r\n");
      out.write("            <li>품절</li>\r\n");
      out.write("            <li>관리</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        ");

        if(plists.size() != 0){
        int w =0;
        while(w < plists.size()){
        
      out.write("\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li><input type=\"checkbox\" id=\"cbox\" value=\"");
      out.print(plists.get(w).getPidx());
      out.write("\" onclick=\"p_check(this.checked,this.value)\"></li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPcode());
      out.write("</li>\r\n");
      out.write("            <li style=\"overflow: hidden;\"><img src=\"");
      out.print(plists.get(w).getPimg());
      out.write("\" style=\"width: 30px; height:30px;\"/></li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPname());
      out.write("</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPB_cate());
      out.write("</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPprice());
      out.write("</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPsaleprice());
      out.write("</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPsale());
      out.write("%</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPstock());
      out.write("</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPdone());
      out.write("</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPsold());
      out.write("</li>\r\n");
      out.write("            <li>");
      out.print(plists.get(w).getPuse());
      out.write("</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        ");

        w++;
        }
        }else{
        
      out.write("\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li style=\"width: 100%;\">등록된 상품이 없습니다.</li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"subpage_view3\">\r\n");
      out.write("        <ul class=\"pageing\">\r\n");
      out.write("            <li><img src=\"./ico/double_left.svg\"></li>\r\n");
      out.write("            <li><img src=\"./ico/left.svg\"></li>\r\n");
      out.write("            ");

			int pg =(int) Math.ceil(total /5f);
			int ww = 1;
			while(ww <= pg){
			
      out.write("\r\n");
      out.write("            <li><a href=\"./plists.do?pidx=");
      out.print(ww);
      out.write('"');
      out.write('>');
      out.print(ww );
      out.write("</a></li>				\r\n");
      out.write("			");

			ww++;
			}
			
      out.write("\r\n");
      out.write("            <li><img src=\"./ico/right.svg\"></li>\r\n");
      out.write("            <li><img src=\"./ico/double_right.svg\"></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"subpage_view4\">\r\n");
      out.write("    	<input type=\"hidden\" id=\"hid_pidx\" value=\"\">\r\n");
      out.write("        <input type=\"button\" value=\"선택상품 삭제\" onclick=\"p_del();\" title=\"선택상품 삭제\" class=\"p_button\">\r\n");
      out.write("        <span style=\"float: right;\">\r\n");
      out.write("        <input type=\"button\" value=\"신규상품 등록\" title=\"신규상품 등록\" onclick=\"p_register();\" class=\"p_button p_button_color1\">\r\n");
      out.write("        </span>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("<script src=\"./js/product.js?v=");
      out.print(pdsf.format(pdday));
      out.write("\"></script>\r\n");
      out.write("    \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("<section></section>\r\n");
      out.write("<section></section>\r\n");
      out.write("</main>\r\n");
      out.write("<footer class=\"main_copyright\">\r\n");
      out.write("   ");
      out.write("\r\n");
      out.write(" <div>\r\n");
      out.write("        Copyright ⓒ 2023 shopbag All rights reserved.\r\n");
      out.write("    </div>");
      out.write("\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
