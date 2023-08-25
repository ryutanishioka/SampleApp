package sampleAppDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import sampleAppDTO.ListAllDTO;

public class DeleteDAO {

	public List<ListAllDTO> Delete(String tweet_id) throws SQLException, ClassNotFoundException {
		
		List<ListAllDTO> listAllDTOList = new ArrayList<ListAllDTO>();
		ListAllDAO listall = new ListAllDAO();
		//DB接続変数
		Connection con = null;
		//SQL文に直すための変数
		PreparedStatement pstmt = null;
		//SQL文を記述するための変数
		StringBuilder deleteSQL = new StringBuilder();

		//INSERTのSQL作成。tweetsテーブルに登録する
		deleteSQL.append(" DELETE ");
		deleteSQL.append(" FROM tweets");
		deleteSQL.append(" WHERE tweet_id = ?");
		
		try{ //DB接続
			con = DBConnection.getConnection();
			
			//発行するSQLをセット
			pstmt = con.prepareStatement(deleteSQL.toString());
			//SQL文上書き
			pstmt.setString(1, tweet_id);
			// SQLの実行
			pstmt.executeUpdate();

			//getlistメソッド呼び出して格納
			listAllDTOList = listall.getlist();
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
