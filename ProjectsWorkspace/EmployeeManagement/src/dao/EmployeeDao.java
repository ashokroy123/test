package dao;

import java.util.List;

import com.app.modelBean.Department;
import com.app.modelBean.Employee;
import com.app.modelBean.EmployeeReg;

public interface EmployeeDao {
	public boolean saveEmployee(EmployeeReg emp);
	public EmployeeReg modifyEmployee(EmployeeReg emp);
	public EmployeeReg getEmployeeByEmpId(int empId);
	public List<Employee> allEmployees();
	public boolean removeEmployee(int empId);
	
}
