package sampleAppService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sampleAppDAO.UpdateDAO;
import sampleAppDTO.ListAllDTO;

public class UpdateService {
	public List<ListAllDTO> update(String tweet_id, String tweet){
		UpdateDAO updateDAO = new UpdateDAO();
		List<ListAllDTO> result = new ArrayList<ListAllDTO>();
		
		// 一覧表示させる
		try {
			result = updateDAO.Update(tweet_id, tweet);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return result;
	}

}
