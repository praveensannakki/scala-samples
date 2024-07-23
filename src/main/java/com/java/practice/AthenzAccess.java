package com.java.practice;

import java.util.*;

// Principal class representing a user
class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}

// Role class representing a role
class Role {
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}

// Resource class representing a resource
class Resource {
    private String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                '}';
    }
}

// Policy class representing a policy
class Policy {
    private Role role;
    private Resource resource;
    private String action;

    public Policy(Role role, Resource resource, String action) {
        this.role = role;
        this.resource = resource;
        this.action = action;
    }

    public Role getRole() {
        return role;
    }

    public Resource getResource() {
        return resource;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "role=" + role +
                ", resource=" + resource +
                ", action='" + action + '\'' +
                '}';
    }
}

// RBAC System class
class RBACSystem {
    private Map<User, Set<Role>> userRoles = new HashMap<>();
    private List<Policy> policies = new ArrayList<>();

    public void assignRole(User user, Role role) {
        userRoles.computeIfAbsent(user, k -> new HashSet<>()).add(role);
    }

    public void addPolicy(Role role, Resource resource, String action) {
        policies.add(new Policy(role, resource, action));
    }

    public boolean isAuthorized(User user, Resource resource, String action) {
        Set<Role> roles = userRoles.get(user);
        if (roles == null) {
            return false;
        }

        for (Role role : roles) {
            for (Policy policy : policies) {
                if (policy.getRole().equals(role) &&
                        policy.getResource().equals(resource) &&
                        policy.getAction().equals(action)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "RBACSystem{" +
                "userRoles=" + userRoles +
                ", policies=" + policies +
                '}';
    }
}

public class AthenzAccess {
    public static void main(String[] args) {
        // Create users
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Create roles
        Role admin = new Role("Admin");
        Role user = new Role("User");

        // Create resources
        Resource file1 = new Resource("File1");
        Resource file2 = new Resource("File2");

        // Create RBAC system
        RBACSystem rbacSystem = new RBACSystem();

        // Assign roles to users
        rbacSystem.assignRole(alice, admin);
        rbacSystem.assignRole(bob, user);

        // Add policies
        rbacSystem.addPolicy(admin, file1, "read");
        rbacSystem.addPolicy(admin, file1, "write");
        rbacSystem.addPolicy(admin, file2, "read");
        rbacSystem.addPolicy(user, file1, "read");

        // Check authorization
        System.out.println("Is Alice authorized to read File1? " + rbacSystem.isAuthorized(alice, file1, "read"));
        System.out.println("Is Alice authorized to write File1? " + rbacSystem.isAuthorized(alice, file1, "write"));
        System.out.println("Is Bob authorized to read File1? " + rbacSystem.isAuthorized(bob, file1, "read"));
        System.out.println("Is Bob authorized to write File1? " + rbacSystem.isAuthorized(bob, file1, "write"));

        // Print the RBAC system state
        System.out.println(rbacSystem);
    }
}

