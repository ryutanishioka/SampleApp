package sampleAppService;

import java.sql.SQLException;

import sampleAppDAO.CreateDAO;



public class CreateService {
	
	//DBに保存して、保存ができればControllerにhome.jspを返す
	public Boolean createNew(String userId, String tweet) {
		
		Boolean path = true;
		CreateDAO createDao = new CreateDAO();
		String result = null;
	
		//user
	    try {
			result = createDao.Create(userId, tweet);
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	    if (result == null) {
		    //セッションにnameを保持
	    	System.out.println("エラー発生");
	        path = false;
	    }
	    
		return path;
		
	}

}
