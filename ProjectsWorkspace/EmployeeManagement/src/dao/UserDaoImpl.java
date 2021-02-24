package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.app.config.DBConnection;
import com.app.constants.Queries;

public class UserDaoImpl implements UserDao{

	public String getPassword(String uname) {
		Connection con = null;
		ResultSet rs = null;
		String password = null;
		try {
			con = DBConnection.getConnect();
			PreparedStatement pstmt= con.prepareStatement(Queries.GET_USER_DETAILS);
			pstmt.setString(1, uname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				password = rs.getString("PASSWORD"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(con);
		}
		
		
		return password;
	}

}
