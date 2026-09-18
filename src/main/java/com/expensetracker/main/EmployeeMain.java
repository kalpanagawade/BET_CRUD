package com.expensetracker.main;

import com.expensetracker.dao.EmployeeDAO;
import com.expensetracker.model.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BUSINESS EXPENSES TRACKER =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Role ID: ");
                    Long roleId = sc.nextLong();

                    System.out.print("Enter Department ID: ");
                    Long departmentId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();

                    Employee employee = new Employee(
                            roleId,
                            departmentId,
                            name,
                            email,
                            phone,
                            designation
                    );

                    dao.addEmployee(employee);
                    break;

                case 2:
                    List<Employee> employees = dao.getAllEmployees();

                    System.out.println("\n===== EMPLOYEE LIST =====");

                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    Long findId = sc.nextLong();

                    Employee found = dao.getEmployeeById(findId);

                    if (found != null) {
                        System.out.println("Employee Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to update: ");
                    Long updateId = sc.nextLong();

                    System.out.print("Enter Role ID: ");
                    Long updateRoleId = sc.nextLong();

                    System.out.print("Enter Department ID: ");
                    Long updateDepartmentId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String updateEmail = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String updatePhone = sc.nextLine();

                    System.out.print("Enter Designation: ");
                    String updateDesignation = sc.nextLine();

                    Employee updatedEmployee = new Employee(
                            updateRoleId,
                            updateDepartmentId,
                            updateName,
                            updateEmail,
                            updatePhone,
                            updateDesignation
                    );

                    updatedEmployee.setId(updateId);

                    dao.updateEmployee(updatedEmployee);
                    break;

                case 5:
                    System.out.print("Enter Employee ID to delete: ");
                    Long deleteId = sc.nextLong();

                    dao.deleteEmployee(deleteId);
                    break;

                case 6:
                    System.out.println("Application closed.");
                    sc.close();
                    HibernateUtilShutdown();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void HibernateUtilShutdown() {
        com.expensetracker.util.HibernateUtil.shutdown();
    }
}