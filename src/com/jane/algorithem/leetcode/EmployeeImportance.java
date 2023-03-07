package com.jane.algorithem.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Set<Integer> set1 = new HashSet<>();
        LinkedList<Integer> set2 = new LinkedList<>();
        int res = 0;
        set2.add(id);
        while (!set2.isEmpty()) {
            Integer employeeId = set2.pollFirst();
            if (!set1.contains(employeeId)) {
                set1.add(employeeId);
                Employee employee = map.get(employeeId);
                res += employee.importance;
                if (employee != null) {
                    for (Integer subordinate : employee.subordinates) {
                        set2.add(subordinate);
                    }
                }
            }
        }
        return res;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
