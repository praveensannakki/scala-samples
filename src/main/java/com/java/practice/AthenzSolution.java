package com.java.practice;

//write a program to check if principal has access to resouce with following conditions
//1. principal can be string "Praveen", "Dev" similar to user or athenz principal
//2. Services - pricinpal can have access to services like, api, emr, s3
//2. role - pricipal can have role like adminuser or devuser
//3. resoures - role can have access to the roles resouces can be database, yahoodb or
// considering eveything as string and write a code to check if principal has permission resources using below code
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AthenzSolution {

    private static final Set<String> VALID_PRINCIPALS = new HashSet<>();
    private static final Set<String> VALID_ROLES = new HashSet<>();
    private static final Map<String, Set<String>> ROLE_SERVICES = new HashMap<>();
    private static final Map<String, Set<String>> PRINCIPAL_ROLES = new HashMap<>();
    private static final Map<String, Set<String>> SERVICE_RESOURCES = new HashMap<>();

    static {
        // Initialize valid principals
        VALID_PRINCIPALS.add("Praveen");
        VALID_PRINCIPALS.add("Dev");

        // Initialize valid roles
        VALID_ROLES.add("adminuser");
        VALID_ROLES.add("devuser");

        // Initialize role-service mapping
        Set<String> adminServices = new HashSet<>();
        adminServices.add("api");
        adminServices.add("emr");
        adminServices.add("s3");
        ROLE_SERVICES.put("adminuser", adminServices);

        Set<String> devServices = new HashSet<>();
        devServices.add("s3");
        ROLE_SERVICES.put("devuser", devServices);

        // Initialize principal-role mapping
        Set<String> praveenRoles = new HashSet<>();
        praveenRoles.add("adminuser");
        PRINCIPAL_ROLES.put("Praveen", praveenRoles);

        Set<String> devRoles = new HashSet<>();
        devRoles.add("devuser");
        PRINCIPAL_ROLES.put("Dev", devRoles);

        // Initialize service-resource mapping
        Set<String> apiResources = new HashSet<>();
        apiResources.add("database");
        SERVICE_RESOURCES.put("api", apiResources);

        Set<String> emrResources = new HashSet<>();
        emrResources.add("yahoodb");
        SERVICE_RESOURCES.put("emr", emrResources);

        Set<String> s3Resources = new HashSet<>();
        s3Resources.add("database");
        s3Resources.add("yahoodb");
        SERVICE_RESOURCES.put("s3", s3Resources);
    }

    public static void main(String[] args) {
        System.out.println(hasAccess("Praveen", "database"));
        System.out.println(hasAccess("Praveen", "yahoodb"));
        System.out.println(hasAccess("Dev", "yahoodb"));
        System.out.println(hasAccess("John", "database"));
    }

    private static boolean hasAccess(String principal, String resource) {
        if (!VALID_PRINCIPALS.contains(principal)) {
            return false;
        }

        Set<String> roles = PRINCIPAL_ROLES.get(principal);
        if (roles == null) {
            return false;
        }

        for (String role : roles) {
            if (!VALID_ROLES.contains(role)) {
                continue;
            }

            Set<String> services = ROLE_SERVICES.get(role);
            if (services == null) {
                continue;
            }

            for (String service : services) {
                Set<String> serviceResources = SERVICE_RESOURCES.get(service);
                if (serviceResources != null && serviceResources.contains(resource)) {
                    return true;
                }
            }
        }

        return false;
    }
}

