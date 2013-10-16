package org.apache.struts.example.crud.dao;

import org.apache.struts.example.crud.model.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDepartmentDao implements DepartmentDao {

    private static List<Department> departments;
    private static Map<Integer, Department> departmentsMap;

    static {
        departments = new ArrayList<Department>();
        departments.add(new Department(100, "Accounting"));
        departments.add(new Department(200, "R & D"));
        departments.add(new Department(300, "Sales"));
        departmentsMap = new HashMap<Integer, Department>();
        for (Department dept : departments) {
            departmentsMap.put(dept.getDepartmentId(), dept);
        }
    }

    public List<Department> getAllDepartments() {
        return departments;
    }

    public Map<Integer, Department> getDepartmentsMap() {
        return departmentsMap;
    }

}
