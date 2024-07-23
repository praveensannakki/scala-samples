package com.java.practice;

import java.util.*;

public class SimpleRBAC {
    // Maps to store users, roles, resources, and policies
    private Map<String, Set<String>> userRoles = new HashMap<>();
    private Map<String, Set<String>> rolePolicies = new HashMap<>();
    private Set<String> resources = new HashSet<>();

    // Method to assign a role to a user
    public void assignRole(String user, String role) {
        userRoles.computeIfAbsent(user, k -> new HashSet<>()).add(role);
    }

    // Method to add a policy
    public void addPolicy(String role, String resource, String action) {
        String policyKey = role + ":" + resource + ":" + action;
        rolePolicies.computeIfAbsent(role, k -> new HashSet<>()).add(policyKey);
        resources.add(resource);
    }

    // Method to check if a user is authorized
    public boolean isAuthorized(String user, String resource, String action) {
        Set<String> roles = userRoles.get(user);
        if (roles == null) {
            return false;
        }

        for (String role : roles) {
            String policyKey = role + ":" + resource + ":" + action;
            if (rolePolicies.get(role) != null && rolePolicies.get(role).contains(policyKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Create an instance of the RBAC system
        SimpleRBAC rbac = new SimpleRBAC();

        // Assign roles to users
        rbac.assignRole("Alice", "Admin");
        rbac.assignRole("Bob", "User");

        // Add policies
        rbac.addPolicy("Admin", "File1", "read");
        rbac.addPolicy("Admin", "File1", "write");
        rbac.addPolicy("Admin", "File2", "read");
        rbac.addPolicy("User", "File1", "read");

        // Check authorization
        System.out.println("Is Alice authorized to read File1? " + rbac.isAuthorized("Alice", "File1", "read"));
        System.out.println("Is Alice authorized to write File1? " + rbac.isAuthorized("Alice", "File1", "write"));
        System.out.println("Is Bob authorized to read File1? " + rbac.isAuthorized("Bob", "File1", "read"));
        System.out.println("Is Bob authorized to write File1? " + rbac.isAuthorized("Bob", "File1", "write"));
    }
}

