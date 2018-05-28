package nl.hu.v1wac.firstapp.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/DynamicServlet.do")
public class DynamicServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException {
int getal1 =Integer.parseInt(req.getParameter("getal1"));
int getal2 =Integer.parseInt(req.getParameter("getal2"));
int resultaat;
 String operator = req.getParameter("operator");
 System.out.println("hoi"+operator);
 if(operator.equals("+")) {
	 resultaat= getal1+getal2;

}
 else if(operator.equals("-")) {
	 resultaat= getal1-getal2;

}
 else if(operator.equals("*")) {
	 resultaat= getal1*getal2;

}
 else if(operator.equals("/")) {
	 resultaat= getal1/getal2;

}
 else {
	 resultaat=0;
 }
 PrintWriter out = resp.getWriter();
 resp.setContentType("text/html");
 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println(" <title>Dynamic Example</title>");
 out.println(" <body>");
 out.println(" <h2>Dynamic webapplication example</h2>");
 out.println(" <h2>Hello"+resultaat+"test</h2>");
 out.println(" </body>");
 out.println("</html>");
 }
}
