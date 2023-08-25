package sampleAppDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import sampleAppDTO.ListAllDTO;

public class UpdateDAO {
	public List<ListAllDTO> Update(String tweet_id, String tweet) throws SQLException, ClassNotFoundException {
		List<ListAllDTO> listAllDTOList = new ArrayList<ListAllDTO>();
		ListAllDAO listall = new ListAllDAO();
		//DB接続変数
		Connection con = null;
		//SQL文に直すための変数
		PreparedStatement pstmt = null;
		//SQL文を記述するための変数
		StringBuilder updateSQL = new StringBuilder();		
		
		//INSERTのSQL作成。tweetsテーブルに登録する
		updateSQL.append(" UPDATE tweets ");
		updateSQL.append(" SET ");
		updateSQL.append(" tweet = ? ");
		updateSQL.append(" WHERE tweet_id = ? ");


		// DBに接続しユーザー情報を取得する
		try { 
			con = DBConnection.getConnection();
			//発行するSQLをセット
			pstmt = con.prepareStatement(updateSQL.toString());
			//SQL文上書き
			pstmt.setString(1, tweet);
			//Seeviceでセッション使ってStringに変換して飛ばす
			pstmt.setString(2, tweet_id);

			pstmt.executeUpdate();
			
			//getlistメソッド呼び出して格納(全件取得メソッド)
			listAllDTOList = listall.getlist();
			
		} catch (SQLException e) {
			// 例外処理
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// 例外処理
				e.printStackTrace();
				con.close();
			}
		}

		return listAllDTOList;

	}

}
