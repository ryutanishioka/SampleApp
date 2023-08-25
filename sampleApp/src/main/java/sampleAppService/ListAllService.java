package sampleAppService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sampleAppDAO.ListAllDAO;
import sampleAppDTO.ListAllDTO;

public class ListAllService {

	public List<ListAllDTO> listAll() {
		
		ListAllDAO listAllDAO = new ListAllDAO();
		List<ListAllDTO> result = new ArrayList<ListAllDTO>();
		
		// 一覧表示させる
		try {
			result = listAllDAO.getlist();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return result;
	}

}
