package sampleAppService;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sampleAppDAO.LoginDAO;
import sampleAppDTO.LoginDTO;

public class LoginService {
	
	public String getLoginPath(HttpServletRequest request){
		
	    // ログインユーザーname
	    //String loginName = "";
	    //LoginDAOインスタンス生成
	    LoginDAO loginDAO = new LoginDAO();
	    //LoginDTOインスタンス生成
	    LoginDTO loginDTO = new LoginDTO();
	    // 遷移先のパスを保持する
	    String path = "";
	    
	    // リクエストからnameとmailを取得する
	    String name = request.getParameter("name");
	    String mail = request.getParameter("mail");
	    
	    // データベースに接続し、nameとmailでログイン認証を行う
	    //loginI・・・usersテーブルのidカラムの情報
	    try {
	        //loginName = loginDAO.LoginAuthenticate(name, mail);
	        
	    	loginDTO = loginDAO.LoginAuthenticate(name, mail);
	    	
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    // loginIdが空文字かどうかでログインの成否を判定する
	    if (loginDTO != null) {
		    //セッションにnameを保持
		    HttpSession session = request.getSession();
		    session.setAttribute("name", loginDTO.getname());
		    session.setAttribute("mail", loginDTO.getmail());
		    session.setAttribute("userId", loginDTO.getid());
		    //session.setAttribute("name", mail);
	        //session.setAttribute(SessionInfo.LOGIN_USER_ID, loginName);
	        path = "/WEB-INF/home.jsp";
	    } else {
	        path = "/WEB-INF/login.jsp";
	    }
		return path;
		
	}

}
