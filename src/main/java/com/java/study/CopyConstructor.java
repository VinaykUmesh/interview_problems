package com.java.study;

class Permission {
    String name;

    public Permission(String name) {
        this.name = name;
    }

    public Permission(Permission other) {
        this.name = other.name;
    }


}

class Roles {
    int id;
    String roleName;
    Permission permission;

    public Roles(Roles other) {
        this.id = other.id;
        this.roleName = other.roleName;
        this.permission = new Permission(other.permission);
    }

    public Roles(int id, String roleName, Permission permission) {
        this.id = id;
        this.roleName = roleName;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", permission=" + permission.name +
                '}';
    }
}

public class CopyConstructor {

    public static void main(String[] args) {

        Permission permission = new Permission("read-only");
        Roles roles = new Roles(1, "Admin", permission);
        Roles roles1 = new Roles(roles);
        permission.name = "read/write";

        System.out.println(roles.toString());
        System.out.println(roles1.toString());
    }
}
