package sampleAppController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sampleAppService.CreateService;

/**
 * Servlet implementation class CreateController
 */
@WebServlet("/create")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     * doGetとdoPostのメソッド振り分けるコードを書く
     */
    public CreateController() {
        super();
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * ツイート投稿画面に遷移させる
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * DBに登録して一覧画面に遷移させる
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		CreateService create = new CreateService();
		
		//userIdセッション情報取得
		HttpSession session = request.getSession();
	    String userId = String.valueOf(session.getAttribute("userId"));
	    
	    //tweetパラメーター取得
		String tweet = request.getParameter("tweet");
		
		//後で戻り値を真偽値にしとく
		if (create.createNew(userId, tweet)) {
			LoginController home = new LoginController();
			home.doGet(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
		}

		//request.getRequestDispatcher(path).forward(request, response);

	}

}
