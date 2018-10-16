package servlets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import connection.ConnectionFactory;
import dao.AlunoDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class alunoServlet
 */
@WebServlet("/alunoServlet")
public class alunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
	}
	
	public void destroy(){
		super.destroy();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		JSONObject obj = new JSONObject();
		JSONArray list = new JSONArray();
		
		try(Connection conn = ConnectionFactory.getConnection()) {
			AlunoDAO alunoDAO = new AlunoDAO(conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
