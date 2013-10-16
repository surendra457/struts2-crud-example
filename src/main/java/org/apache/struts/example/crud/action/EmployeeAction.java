package org.apache.struts.example.crud.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts.example.crud.model.Employee;
import org.apache.struts.example.crud.service.DefaultDepartmentService;
import org.apache.struts.example.crud.service.DefaultEmployeeService;
import org.apache.struts.example.crud.service.EmployeeService;
import org.apache.struts.example.crud.service.DepartmentService;

import java.util.List;

public class EmployeeAction extends ActionSupport implements Preparable {

    private EmployeeService empService = new DefaultEmployeeService();
    private DepartmentService deptService = new DefaultDepartmentService();
    
    private Employee employee;
    private List employees;
    private List departments;

    public void prepare() throws Exception {
        departments = deptService.getAllDepartments();
        if (employee != null && employee.getEmployeeId() != null) {
            employee = empService.getEmployee(employee.getEmployeeId());
        }
    }
    
    public String save() {
        if (employee.getEmployeeId() == null) {
            empService.insertEmployee(employee);
        } else {
            empService.updateEmployee(employee);
        }
        return SUCCESS;
    }

    public String delete() {
        empService.deleteEmployee(employee.getEmployeeId());
        return SUCCESS;
    }

    public String list() {
        employees = empService.getAllEmployees();
        return SUCCESS;
    }

    /**
     * @return Returns the employee.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee The employee to set.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return Returns the employees.
     */
    public List getEmployees() {
        return employees;
    }

    /**
     * @return Returns the departments.
     */
    public List getDepartments() {
        return departments;
    }

}
