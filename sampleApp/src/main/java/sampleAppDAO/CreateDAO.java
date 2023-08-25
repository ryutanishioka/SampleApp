package sampleAppDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnection;

public class CreateDAO {

	public String Create(String userId, String tweet) throws SQLException, ClassNotFoundException {
		//DB接続変数
		Connection con = null;
		//SQL文に直すための変数
		PreparedStatement pstmt = null;
		//SQL文を記述するための変数
		StringBuilder insetSQL = new StringBuilder();
		
		//SQL実行ための変数
		int rs = -1;
		
		String result = null;
		
		
		//INSERTのSQL作成。tweetsテーブルに登録する
	    insetSQL.append(" INSERT INTO ");
	    insetSQL.append(" TWEETS ");
	    insetSQL.append(" (tweet, user_id) ");
	    insetSQL.append(" VALUES ");
	    insetSQL.append(" (?,?) ");

		// DBに接続しユーザー情報を取得する
		try { 
			con = DBConnection.getConnection();
			//発行するSQLをセット
			pstmt = con.prepareStatement(insetSQL.toString());
			//SQL文上書き
			pstmt.setString(1, tweet);
			//Seeviceでセッション使ってStringに変換して飛ばす
			pstmt.setString(2, userId);

			// SQLの実行(select文以外はUpdateメソッド！)
			//結果は影響を受けた行数int型で返す
			rs = pstmt.executeUpdate();
			
			if(rs > 0) {
				result = "成功";
			}

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

		return result;

	}

}
