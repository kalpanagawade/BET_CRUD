package com.business.dao;

import com.business.connection.DBConnection;
import com.business.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {

    // CREATE
    public void addRole(Role role) {

        String sql = "INSERT INTO roles (role_name, description) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, role.getRoleName());
            ps.setString(2, role.getDescription());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Role added successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // READ
    public List<Role> getAllRoles() {

        List<Role> roles = new ArrayList<>();

        String sql = "SELECT * FROM roles";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Role role = new Role();

                role.setRoleId(rs.getLong("role_id"));
                role.setRoleName(rs.getString("role_name"));
                role.setDescription(rs.getString("description"));

                roles.add(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return roles;
    }


    // UPDATE
    public void updateRole(Role role) {

        String sql = """
                UPDATE roles
                SET role_name = ?, description = ?
                WHERE role_id = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, role.getRoleName());
            ps.setString(2, role.getDescription());
            ps.setLong(3, role.getRoleId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Role updated successfully!");
            } else {
                System.out.println("Role not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // DELETE
    public void deleteRole(long roleId) {

        String sql = "DELETE FROM roles WHERE role_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, roleId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Role deleted successfully!");
            } else {
                System.out.println("Role not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}