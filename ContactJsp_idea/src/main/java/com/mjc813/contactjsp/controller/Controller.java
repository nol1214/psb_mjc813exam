package com.mjc813.contactjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.mjc813.contactjsp.DAO.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * @WebServlet 애노테이션은 HttpServlet 에서 URI 의 패턴이 맞으면 해당 컨트롤러를 실행한다. 
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * method=GET 에 해당하는 클라이언트 요청을 실행한다. 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("doGet : getMethod=%s, getContextPath=%s, getRequestURI=%s\n", request.getMethod(), request.getContextPath(), request.getRequestURI());
		/// 로그가 없으므로 콘솔에 출력했다
		doPro(request, response);		
	}

	/*
	 * method=POST 에 해당하는 클라이언트 요청을 실행한다. 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("doPost : getMethod=%s, getContextPath=%s, getRequestURI=%s\n", request.getMethod(), request.getContextPath(), request.getRequestURI());
		/// 로그가 없으므로 콘솔에 출력했다
		doPro(request, response);
	}
	
	/*
	 * request : http 클라이언트 요청에 대한 정보가 해당 객체로 전달 된다.
	 * response : http 클라이언트의 응답에 대한 정보가 반환 된다. 
	 */
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String url = uri.substring(context.length());
		String site = null;	// 화면에 출력할 jsp 파일명

		System.out.printf("doPro : url=%s\n", url);
		/// 로그가 없으므로 콘솔에 출력했다
//		MemberMysqlDAO member = new MemberMysqlDAO();
		ContactMysqlDAO dao = new ContactMysqlDAO();
		switch(url) {
		case "/home" :
			site = "index.jsp";
			break;
		
		case "/list" :			
			site = dao.selectAll(request, response);
			break;

		case "/add" :
			site = "add.jsp";
			break;
			
		case "/insert" :		
			site = dao.insert(request, response);
			break;
			
		case "/modify" :		
			site = dao.modify(request, response);
			break;
			
		case "/update" :
			int result1 = dao.update(request, response);
			response.setContentType("text/html; charset=UTF-8");
			/// 클라이언트에 응답을 보낼때 html 문자열을 보내도록 설정한다.
			PrintWriter out = response.getWriter();
			if(result1 == 1) {
				out.println("<script>");
				out.println(" alert('연락처수정이 완료 되었습니다!'); location.href='/list';");
				out.println("</script>");
				out.flush();
				/// 수정 인 경우에는 /list 주소로 이동 시켰다.
			} else {
				out.println("<script>");
				out.println("alert('수정실패!');");
				out.println("</script>");
				out.flush();
				/// 실패 인 경우에는 주소를 이동하지 않는다.
			}
			return;
			//break;
			
		case "/delete" :
			int result2 = dao.delete(request, response);
			response.setContentType("text/html; charset=UTF-8");
			/// 클라이언트에 응답을 보낼때 html 문자열을 보내도록 설정한다.
			out = response.getWriter();
			if(result2 == 1) {
				out.println("<script>");
				out.println(" alert('연락처삭제가 완료 되었습니다!'); location.href='/list';");
				out.println("</script>");
				out.flush();
				/// 삭제 인 경우에는 /list 주소로 이동 시켰다.
			} else {
				out.println("<script>");
				out.println("alert('삭제실패!');");
				out.println("</script>");
				out.flush();
				/// 실패 인 경우에는 주소를 이동하지 않는다.
			}
			return;
			//break;
		default:
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(site);
		dispatcher.forward(request,  response);
		/// site 값에 있는 *.jsp 파일을 화면에 출력한다.
	}
}