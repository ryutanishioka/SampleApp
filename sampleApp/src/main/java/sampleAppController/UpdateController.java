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
import sampleAppService.UpdateService;


/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		String tweet_id = request.getParameter("param1");
		
		String path = "/WEB-INF/home.jsp";
	
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			//一覧表示listAllServiceへ飛ばす

			//リクエストにツイート情報を格納
			request.setAttribute("tweet", tweet_id);
			//パス指定
			path = "/WEB-INF/update.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String tweet_id = request.getParameter("param1");
		String tweet = request.getParameter("tweet");
		
		String path = "/WEB-INF/login.jsp";
		UpdateService updateService = new UpdateService();
	
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			//一覧表示listAllServiceへ飛ばす
			List<ListAllDTO> result = updateService.update(tweet_id, tweet);
			//リクエストにツイート情報を格納
			request.setAttribute("tweets", result);
			//パス指定
			path = "/WEB-INF/home.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
