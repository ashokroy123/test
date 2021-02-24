package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.config.DBConnection;
import com.app.constants.Queries;
import com.app.modelBean.Department;
import com.app.modelBean.Employee;

public class DepartmentDaoImpl implements DepartmentDao{
	public List<Department> getDepartmentDetails()
	{
		List<Department> deptList=new ArrayList<Department>();
		Connection con=null;
		ResultSet rs = null;
		try
		{
			con = DBConnection.getConnect();
			PreparedStatement pstmt= con.prepareStatement(Queries.GET_DEPARTMENT_DETAILS);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Department dept=new Department();
				dept.setDeptId(rs.getInt("DEPT_ID"));
				dept.setDeptName(rs.getString("DEPT_NAME"));
				deptList.add(dept);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBConnection.closeConnection(con);
		}
		return deptList;
	}
}
