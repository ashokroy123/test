/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.47
 * Generated at: 2018-03-07 09:51:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import com.app.modelBean.Employee;

public final class AllEmployeeDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("dao.EmployeeDaoImpl");
    _jspx_imports_classes.add("dao.EmployeeDao");
    _jspx_imports_classes.add("com.app.modelBean.Employee");
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
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>All Employee Details</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("td {\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tborder: 10px; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<style>\r\n");
      out.write("table, th, td {\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #d7e7f3;\">\r\n");

String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
System.out.println(basePath);
EmployeeDao dao = new EmployeeDaoImpl();
List<Employee> list = dao.allEmployees();
System.out.println(list);

      out.write("\r\n");
      out.write("<center><h2>All Employee Details:</h2></center>\r\n");
      out.write("<div style=\"padding-left: 130px;\">\r\n");
      out.write("<a href=\"");
      out.print(basePath);
      out.write("/jsps/EmployeeHomePage.jsp\"><b>Home</b></a>\r\n");
      out.write("<table style=\"padding: 10px; border: 10px;\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>Employee Id</th>\r\n");
      out.write("\t\t<th>Name</th>\r\n");
      out.write("\t\t<th>Date of Join</th>\r\n");
      out.write("\t\t<th>Department</th>\r\n");
      out.write("\t\t<th>Mobile No</th>\r\n");
      out.write("\t\t<th>Email Id</th>\r\n");
      out.write("\t\t<th>Highest Qualification</th>\r\n");
      out.write("\t\t<th>Delete</th>\r\n");
      out.write("\t</tr>\r\n");
for(int i=0;i< list.size(); i++) {
      out.write(" <!-- Start for loop -->\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><a href=");
      out.print(basePath);
      out.write("/EmpDetailsServlet?empid=");
      out.print(list.get(i).getEmpId());
      out.write("><u>");
      out.print(list.get(i).getEmpId());
      out.write("</u></a></td>\r\n");
      out.write("\t\t<td>");
      out.print(list.get(i).getName());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(list.get(i).getDateOfJoin());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(list.get(i).getDepartmentName());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(list.get(i).getMobileNumber());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(list.get(i).getEmailId());
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(list.get(i).getHighestQualification());
      out.write("</td>\r\n");
      out.write("\t\t<td><a href=");
      out.print(basePath);
      out.write("/DeleteServlet?empid=");
      out.print(list.get(i).getEmpId());
      out.write("><button type=\"button\">Delete</button></a></td>\r\n");
      out.write("\t</tr>\r\n");
} 
      out.write(" <!-- End for loop -->\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
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
