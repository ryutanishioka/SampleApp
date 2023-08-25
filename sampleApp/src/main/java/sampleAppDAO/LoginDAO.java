package sampleAppDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import sampleAppDTO.LoginDTO;



public class LoginDAO {
	/**
	 * nameとmailによるログイン認証を行う
	 * @param name
	 * @param mail
	 * @return 成功: name / 失敗: 空文字
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public LoginDTO LoginAuthenticate(String name, String mail) throws SQLException, ClassNotFoundException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		// 返却用変数
		//String resName = "";
	    //LoginDTOインスタンス生成
	    LoginDTO loginDTO = new LoginDTO();

		StringBuilder sql = new StringBuilder();
		
		ResultSet rs = null;
		
		//SQL作成
		sql.append(" SELECT ");
		sql.append("	* ");
		sql.append(" FROM ");
		sql.append("	users ");
		sql.append(" WHERE ");
		sql.append("	name = ? ");
		sql.append(" AND ");
		sql.append("	mail = ? ");

		// DBに接続しユーザー情報を取得する
		try{ //DB接続
			con = DBConnection.getConnection();
			
			//発行するSQLをセット
			pstmt = con.prepareStatement(sql.toString());
			//SQL文上書き
			pstmt.setString(1, name);
			pstmt.setString(2, mail);

			// SQLの実行
			rs = pstmt.executeQuery();

			// nameとmailが一致するユーザーが存在した時の処理
			if(rs.next()) {
				// 返却用変数にデータベースから取得したnameを設定する
				//resName = rs.getString("name");
				//一致した情報をDTOに格納する
				loginDTO.setid(rs.getString("id"));
				loginDTO.setname(rs.getString("name"));
				loginDTO.setmail(rs.getString("mail"));
			}else {
				System.out.println("一致しないよー");
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
		return loginDTO;
	}
}
