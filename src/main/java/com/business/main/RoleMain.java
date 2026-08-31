package com.business.main;

import com.business.dao.RoleDAO;
import com.business.model.Role;

import java.util.List;
import java.util.Scanner;

public class RoleMain {

    public static void main(String[] args) {

        RoleDAO roleDAO = new RoleDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== BUSINESS EXPENSES TRACKER =====");
            System.out.println("1. Add Role");
            System.out.println("2. View Roles");
            System.out.println("3. Update Role");
            System.out.println("4. Delete Role");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter role name: ");
                    String roleName = scanner.nextLine();

                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    Role role = new Role(roleName, description);

                    roleDAO.addRole(role);
                    break;

                case 2:
                    List<Role> roles = roleDAO.getAllRoles();

                    System.out.println("\n----- ROLES -----");

                    for (Role r : roles) {
                        System.out.println(r);
                    }
                    break;

                case 3:
                    System.out.print("Enter Role ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter new role name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();

                    Role updateRole =
                            new Role(id, newName, newDescription);

                    roleDAO.updateRole(updateRole);
                    break;

                case 4:
                    System.out.print("Enter Role ID to delete: ");
                    long deleteId = scanner.nextLong();

                    roleDAO.deleteRole(deleteId);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}