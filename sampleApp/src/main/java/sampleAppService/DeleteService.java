package sampleAppService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sampleAppDAO.DeleteDAO;
import sampleAppDTO.ListAllDTO;

public class DeleteService {
	public List<ListAllDTO> delete(String tweet_id){
		DeleteDAO deleteDAO = new DeleteDAO();
		List<ListAllDTO> result = new ArrayList<ListAllDTO>();
		
		// 一覧表示させる
		try {
			result = deleteDAO.Delete(tweet_id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return result;
	}

}
