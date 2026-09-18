package com.expensetracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "designation")
    private String designation;


    // Default Constructor
    public Employee() {
    }


    // Constructor without ID
    public Employee(Long roleId, Long departmentId, String name,
                    String email, String phone, String designation) {

        this.roleId = roleId;
        this.departmentId = departmentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }


    // Getter and Setter for ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Getter and Setter for Role ID
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    // Getter and Setter for Department ID
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }


    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Getter and Setter for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Getter and Setter for Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    // Getter and Setter for Designation
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    // toString()
    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}