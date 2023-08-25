package sampleAppController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sampleAppDTO.ListAllDTO;
import sampleAppService.ListAllService;
import sampleAppService.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String path = "/WEB-INF/login.jsp";
		ListAllService listAllService = new ListAllService();
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			//一覧表示listAllServiceへ飛ばす
			List<ListAllDTO> result = listAllService.listAll();
			//リクエストにツイート情報を格納
			request.setAttribute("tweets", result);
			//パス指定
			path = "/WEB-INF/home.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		 // リクエストからnameとmailを取得する
	    //String name = request.getParameter("name");
	    //String mail = request.getParameter("mail");
		ListAllService listAllService = new ListAllService();
	    LoginService loginService = new LoginService();
	    String path = loginService.getLoginPath(request);
	    
	    HttpSession session = request.getSession(false);
		
		if (session != null) {
			//一覧表示listAllServiceへ飛ばす
			List<ListAllDTO> result = listAllService.listAll();
			//リクエストにツイート情報を格納
			request.setAttribute("tweets", result);
			//パス指定
			path = "/WEB-INF/home.jsp";
		}
	    // 設定されているパスに遷移する
	    request.getRequestDispatcher(path).forward(request, response);
	}

}
