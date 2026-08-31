package com.expensetracker.main;

import com.expensetracker.dao.EmployeeDAO;
import com.expensetracker.model.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {

            System.out.println();
            System.out.println("================================");
            System.out.println("       EMPLOYEE MANAGEMENT");
            System.out.println("================================");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();


            // =================================================
            // 1. ADD EMPLOYEE
            // =================================================

            if (choice == 1) {

                System.out.println();
                System.out.println("===== ADD EMPLOYEE =====");

                System.out.print("Enter Role ID: ");
                long roleId = scanner.nextLong();

                System.out.print("Enter Department ID: ");
                long departmentId = scanner.nextLong();

                scanner.nextLine();

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Email: ");
                String email = scanner.nextLine();

                System.out.print("Enter Phone: ");
                String phone = scanner.nextLine();

                System.out.print("Enter Designation: ");
                String designation = scanner.nextLine();


                Employee employee = new Employee(
                        roleId,
                        departmentId,
                        name,
                        email,
                        phone,
                        designation
                );

                employeeDAO.addEmployee(employee);
            }


            // =================================================
            // 2. VIEW EMPLOYEES
            // =================================================

            else if (choice == 2) {

                System.out.println();
                System.out.println("===== EMPLOYEE LIST =====");

                List<Employee> employees =
                        employeeDAO.getAllEmployees();

                if (employees.isEmpty()) {

                    System.out.println("No employees found.");

                } else {

                    for (Employee employee : employees) {

                        System.out.println();
                        System.out.println("----------------------------");

                        System.out.println(
                                "Employee ID   : "
                                        + employee.getId()
                        );

                        System.out.println(
                                "Role ID       : "
                                        + employee.getRoleId()
                        );

                        System.out.println(
                                "Department ID : "
                                        + employee.getDepartmentId()
                        );

                        System.out.println(
                                "Name          : "
                                        + employee.getName()
                        );

                        System.out.println(
                                "Email         : "
                                        + employee.getEmail()
                        );

                        System.out.println(
                                "Phone         : "
                                        + employee.getPhone()
                        );

                        System.out.println(
                                "Designation   : "
                                        + employee.getDesignation()
                        );

                        System.out.println(
                                "----------------------------"
                        );
                    }
                }
            }


            // =================================================
            // 3. UPDATE EMPLOYEE
            // =================================================

            else if (choice == 3) {

                System.out.println();
                System.out.println("===== UPDATE EMPLOYEE =====");

                System.out.print("Enter Employee ID to update: ");

                long id = scanner.nextLong();
                scanner.nextLine();


                // First check whether ID exists
                Employee existingEmployee =
                        employeeDAO.getEmployeeById(id);


                if (existingEmployee == null) {

                    System.out.println("Employee ID not found!");

                } else {

                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter New Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter New Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter New Designation: ");
                    String designation = scanner.nextLine();


                    Employee employee = new Employee();

                    employee.setId(id);
                    employee.setName(name);
                    employee.setEmail(email);
                    employee.setPhone(phone);
                    employee.setDesignation(designation);


                    employeeDAO.updateEmployee(employee);
                }
            }


            // =================================================
            // 4. DELETE EMPLOYEE
            // =================================================

            else if (choice == 4) {

                System.out.println();
                System.out.println("===== DELETE EMPLOYEE =====");

                System.out.print("Enter Employee ID to delete: ");

                long id = scanner.nextLong();
                scanner.nextLine();


                employeeDAO.deleteEmployee(id);
            }


            // =================================================
            // 5. EXIT
            // =================================================

            else if (choice == 5) {

                System.out.println();
                System.out.println("Thank you!");

                scanner.close();

                break;
            }


            // =================================================
            // INVALID CHOICE
            // =================================================

            else {

                System.out.println(
                        "Invalid choice! Please enter 1 to 5."
                );
            }
        }
    }
}