package ru.croc.task15;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WorkDepartment {
    private Department parentRoot;
    private HashMap<String, Department> tree = new HashMap<>();

    public void readWordDepartment(String path) throws FileNotFoundException {
        File myObj = new File(path);

        try (Scanner scanner = new Scanner(myObj)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                readData(line);
            }
        }
    }

    public int departmentTreeWorkingTime() {
        return parentRoot.departmentWorkingTime();
    }

    private void readData(String line) {
        String[] departmentArray = line.split(",");
        Department department =
                new Department(departmentArray[0],
                        departmentArray[1],
                        Integer.parseInt(departmentArray[2])
                );
        tree.put(department.getDepartmentName(), department);

        if (department.getParent().equals("-")) {
            parentRoot = department;
        } else {
            tree.get(department.getParent()).addChildren(department);
        }
    }
}
