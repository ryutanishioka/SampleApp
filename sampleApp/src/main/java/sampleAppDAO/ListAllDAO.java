package sampleAppDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import sampleAppDTO.ListAllDTO;

public class ListAllDAO {

	public List<ListAllDTO> getlist() throws SQLException, ClassNotFoundException{
		//結果オブジェクト作成
		List<ListAllDTO> listAllDTOList = new ArrayList<ListAllDTO>();

		//Select文で全件取得
		Connection con = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		
		//内部結合さるSQL文
		sql.append(" SELECT ");
		sql.append("	* ");
		sql.append(" FROM ");
		sql.append(" tweets ");
		sql.append(" INNER JOIN users ");
		sql.append("	ON ");
		sql.append(" tweets.user_id = users.id ");
		sql.append("	ORDER BY tweet_id ");

		try{ //DB接続
			con = DBConnection.getConnection();
			//発行するSQLをセット
			pstmt = con.prepareStatement(sql.toString());
			// SQLの実行
			rs = pstmt.executeQuery();

			//1件ずつlistAllDTOに格納
			//rs.next()で一軒ずつDTOに入れて、ListのDTOに入れる
			while(rs.next()) {
				ListAllDTO listAllDTO = new ListAllDTO();
				//一致した情報をDTOに格納する
				listAllDTO.setname(rs.getString("name"));
				listAllDTO.settweet(rs.getString("tweet"));
				listAllDTO.setuser_id(rs.getString("user_id"));
				listAllDTO.settweet_id(rs.getString("tweet_id"));
				listAllDTOList.add(listAllDTO);
			}
		}catch (SQLException e){
			  // 例外処理
			e.printStackTrace();
		}finally{
		  try{
		    if (con != null){
		      con.close();
		    }
		  }catch (SQLException e){
		    // 例外処理
			  e.printStackTrace();
			  con.close();
		  }
		}

		return listAllDTOList;
	}

}
