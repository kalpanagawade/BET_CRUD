package com.expensetracker.dao;

import com.expensetracker.model.Employee;
import com.expensetracker.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // =========================================================
    // CREATE - ADD EMPLOYEE
    // =========================================================

    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employees " +
                "(role_id, department_id, name, email, phone, designation) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setLong(1, employee.getRoleId());
            ps.setLong(2, employee.getDepartmentId());
            ps.setString(3, employee.getName());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getDesignation());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee added successfully!");
            }

        } catch (SQLException e) {

            System.out.println("Error while adding employee:");
            e.printStackTrace();
        }
    }


    // =========================================================
    // READ - VIEW ALL EMPLOYEES
    // =========================================================

    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT id, role_id, department_id, " +
                "name, email, phone, designation " +
                "FROM employees";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee employee = new Employee();

                employee.setId(rs.getLong("id"));
                employee.setRoleId(rs.getLong("role_id"));
                employee.setDepartmentId(rs.getLong("department_id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employee.setDesignation(rs.getString("designation"));

                employees.add(employee);
            }

        } catch (SQLException e) {

            System.out.println("Error while viewing employees:");
            e.printStackTrace();
        }

        return employees;
    }


    // =========================================================
    // READ - FIND EMPLOYEE BY ID
    // =========================================================

    public Employee getEmployeeById(long id) {

        String sql = "SELECT id, role_id, department_id, " +
                "name, email, phone, designation " +
                "FROM employees WHERE id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Employee employee = new Employee();

                    employee.setId(rs.getLong("id"));
                    employee.setRoleId(rs.getLong("role_id"));
                    employee.setDepartmentId(rs.getLong("department_id"));
                    employee.setName(rs.getString("name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setPhone(rs.getString("phone"));
                    employee.setDesignation(rs.getString("designation"));

                    return employee;
                }
            }

        } catch (SQLException e) {

            System.out.println("Error while finding employee:");
            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // UPDATE - UPDATE EMPLOYEE
    // =========================================================

    public void updateEmployee(Employee employee) {

        String sql = "UPDATE employees SET " +
                "name = ?, email = ?, phone = ?, designation = ? " +
                "WHERE id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getDesignation());
            ps.setLong(5, employee.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Employee updated successfully!");

            } else {

                System.out.println("Employee ID not found!");
            }

        } catch (SQLException e) {

            System.out.println("Error while updating employee:");
            e.printStackTrace();
        }
    }


    // =========================================================
    // DELETE - DELETE EMPLOYEE
    // =========================================================

    public void deleteEmployee(long id) {

        String sql = "DELETE FROM employees WHERE id = ?";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setLong(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Employee deleted successfully!");

            } else {

                System.out.println("Employee ID not found!");
            }

        } catch (SQLException e) {

            System.out.println("Error while deleting employee:");
            e.printStackTrace();
        }
    }
}