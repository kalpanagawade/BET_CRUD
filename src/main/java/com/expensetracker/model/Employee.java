 package com.expensetracker.model;

public class Employee {

    private long id;
    private long roleId;
    private long departmentId;
    private String name;
    private String email;
    private String phone;
    private String designation;

    public Employee() {
    }

    public Employee(long roleId, long departmentId,
                    String name, String email,
                    String phone, String designation) {

        this.roleId = roleId;
        this.departmentId = departmentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}