package searchs.search_in_depth_width.find_empoyee_in_tree;

import java.util.*;

public class FindEmployee {
      static class Employee {
            String name;
            List<Employee> employees;

            public Employee(String name) {
                  this.name = name;
                  this.employees = null;
            }

            public Employee(String name, Employee... employees) {
                  this.name = name;
                  this.employees = Arrays.asList(employees);
            }


            @Override
            public String toString() {
                  StringBuilder allEmployeeNames = new StringBuilder();
                  employees.forEach(
                        (employee -> {
                              allEmployeeNames.append(employee.name + " ");
                        })
                  );
                  return "Employee{" +
                        "name='" + name + '\'' +
                        ", employees=" + allEmployeeNames +
                        '}';
            }
      }

      public static void main(String[] args) {
            FindEmployee findEmployee = new FindEmployee();
            findEmployee.testOne();
            findEmployee.testTwo();
      }

      private void testOne() {
            Employee employee1 = new Employee("employee1");
            Employee employee2 = new Employee("employee2");
            Employee employee3 = new Employee("employee3");

            Employee viceDirector1 = new Employee("viceDirector1", employee1, employee2, employee3);

            Employee employee4 = new Employee("employee4");
            Employee employee5 = new Employee("employee5");
            Employee employee6 = new Employee("employee6");

            Employee viceDirector2 = new Employee("viceDirector2", employee4, employee5, employee6);

            Employee director = new Employee("director", viceDirector1, viceDirector2);
            String path = getPathToEmployeeInDepth(director, "employee4");
            System.out.println(path);
            System.out.println();

      }

      /*
                        director
                  /                 \
        viceDirector1            viceDirector1
      /       |     \           /      |       \
employee1 employee2 employee3  /       |        \
                        employee4  employee5 employee6
       */
      private void testTwo() {
            Employee employee1 = new Employee("employee1");
            Employee employee2 = new Employee("employee2");
            Employee employee3 = new Employee("employee3");

            Employee viceDirector1 = new Employee("viceDirector1", employee1, employee2, employee3);

            Employee employee4 = new Employee("employee4");
            Employee employee5 = new Employee("employee5");
            Employee employee6 = new Employee("employee6");

            Employee viceDirector2 = new Employee("viceDirector2", employee4, employee5, employee6);

            Employee director = new Employee("director", viceDirector1, viceDirector2);

            String path = getPathToEmployeeInWidth(director, "employee4");
            System.out.println(path);
            System.out.println();
      }

      private String getPathToEmployeeInWidth(Employee root, String targetName) {
            if (root == null) return null;

            LinkedList<String> searchPath = new LinkedList<>();
            Queue<Employee> queue = new LinkedList<>();

            queue.add(root); // arr root of tree in queue

            while (!queue.isEmpty()) {
                  Employee employee = queue.poll();

                  if (employee == null) continue;

                  searchPath.add(employee.name);

                  if (employee.name == targetName) {
                        return searchPath.toString();
                  }

                  if (employee.employees != null) {
                        for (Employee e : employee.employees) {
                              queue.add(e);
                        }
                  }
            }

            return searchPath.toString();
      }

      private String getPathToEmployeeInDepth(Employee root, String targetName) {
            if (root == null) return null;

            LinkedList<String> searchPath = new LinkedList<>();
            Stack<Employee> queue = new Stack<>();

            queue.add(root); // arr root of tree in queue

            while (!queue.isEmpty()) {
                  Employee employee = queue.pop();

                  if (employee == null) continue;

                  searchPath.add(employee.name);

                  if (employee.name == targetName) {
                        return searchPath.toString();
                  }

                  if (employee.employees != null) {
                        for (Employee e : employee.employees) {
                              queue.add(e);
                        }
                  }
            }

            return searchPath.toString();
      }
}
