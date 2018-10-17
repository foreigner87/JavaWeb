package servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try(Connection conn = ConnectionFactory.getConnection(false)) {

			AlunoDAO alunoDAO = new AlunoDAO(conn);
			ArrayList<String> errors = new ArrayList<String>;
			
			// Parameters para pegar na parte web
			String username = request.getParameter("username");
			String age = request.getParameter("age");
			String anoEscolar = request.getParameter("anoEscolar");
			
			AlunoBean aluno = new AlunoBean();
			aluno.setNome(username);
			aluno.setIdade(age);
			aluno.setAnoEscolar(anoEscolar);
			
			AlunoDAO.insertAluno(aluno);
			conn.commit();
			
		} catch(Exception e){
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
	}


}
