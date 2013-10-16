package org.apache.struts.example.crud.dao;

import org.apache.struts.example.crud.model.Department;
import org.apache.struts.example.crud.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryEmployeeDao implements EmployeeDao {

    private static Map<Integer, Department> departmentsMap;
    private static ArrayList<Employee> employees;

    static {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "John", "Doe", 36, new Department(100, "Accounting")));
        employees.add(new Employee(2, "Bob", "Smith", 25, new Department(300, "Sales")));
        DepartmentDao deptDao = new InMemoryDepartmentDao();
        departmentsMap = deptDao.getDepartmentsMap();
    }

    public List getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(Integer id) {
        Employee emp = null;
        for (Employee employee : employees) {
            emp = employee;
            if (emp.getEmployeeId().equals(id)) {
                break;
            }
        }
        return emp;
    }

    public void update(Employee emp) {
        Integer id = emp.getEmployeeId();
        for (int i = 0; i < employees.size(); i++) {
            Employee tempEmp = employees.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                emp.setDepartment(departmentsMap.get(emp.getDepartment().getDepartmentId()));
                employees.set(i, emp);
                break;
            }
        }
    }

    public void insert(Employee emp) {
        int lastId = 0;
        for (Employee temp : employees) {
            if (temp.getEmployeeId() > lastId) {
                lastId = temp.getEmployeeId();
            }
        }
        emp.setDepartment(departmentsMap.get(emp.getDepartment().getDepartmentId()));
        emp.setEmployeeId(lastId + 1);
        employees.add(emp);
    }

    public void delete(Integer id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee tempEmp = employees.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                employees.remove(i);
                break;
            }
        }
    }

}
