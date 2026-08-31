package com.business.model;

public class Role {

    private long roleId;
    private String roleName;
    private String description;

    public Role() {
    }

    public Role(long roleId, String roleName, String description) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
    }

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return roleId + " | " + roleName + " | " + description;
    }
}