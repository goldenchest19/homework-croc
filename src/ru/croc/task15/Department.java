package ru.croc.task15;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String parent;
    private String departmentName;
    private int time;
    private List<Department> childs = new ArrayList<>();

    public Department(String departmentName, String parent, int time) {
        this.parent = parent;
        this.departmentName = departmentName;
        this.time = time;
    }

    public int departmentWorkingTime() {
        int workingTime = 0;
        for (Department department : getChilds()) {
            workingTime = Math.max(workingTime,
                    department.departmentWorkingTime());
        }
        return workingTime + time;
    }

    public String getParent() {
        return parent;
    }

    public void addChildren(Department department) {
        childs.add(department);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Department> getChilds() {
        return childs;
    }
}
