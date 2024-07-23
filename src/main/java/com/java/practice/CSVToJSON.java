package com.java.practice;


import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVToJSON {
    public static void main(String[] args) {
        createEmployeeJSON("src/main/resources/employee.csv");
        //readFile("src/main/resources/employee.csv");
    }

    private static void readFile(String path) {
        try (InputStream inputStream = new FileInputStream(path)) {
            //System.out.println(IOUtils.toString(inputStream));
            System.out.println("***************** Next using BufferReader *****************");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while (StringUtils.isNotBlank(line = br.readLine())) {
                System.out.println(line);
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createEmployeeJSON(String filePath) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            br.readLine();
            String line;
            while (StringUtils.isNotBlank(line = br.readLine())) {
                //System.out.println(line);
                Employee emp = convertToPojo(line);
                String json = emp != null ? createEmployeeJSON(emp) : null;
                System.out.println("csv=" + line + " json=" +json);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createEmployeeJSON(Employee emp) {
        Gson gson = new Gson();
        return gson.toJson(emp);
    }

    private static Employee convertToPojo(String line) {
        String[] fields = line.split(",");
        try {
            return new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], Double.parseDouble(fields[7]), fields[8], Integer.parseInt(fields[9]), Integer.parseInt(fields[10]));
        } catch (Exception e) {
            System.out.println("Exception occurred to parse the values " + e.getLocalizedMessage());
        }
        return null;
    }

    //EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID
    public static class Employee {
        int empId;
        String fName;
        String lName;
        String email;
        String phone;
        String hireDate;
        String jobId;
        double salary;
        String commissionPct;
        int managerId;
        int deptId;

        public Employee(int empId, String fName, String lName, String email, String phone, String hireDate, String jobId, double salary, String commissionPct, int managerId, int deptId) {
            try {
                this.empId = empId;
                this.fName = fName;
                this.lName = lName;
                this.email = email;
                this.phone = phone;
                this.hireDate = hireDate;
                this.jobId = jobId;
                this.salary = salary;
                this.commissionPct = commissionPct;
                this.managerId = managerId;
                this.deptId = deptId;
            } catch (Exception e) {
                System.out.println("Unable to instance employee due to " + e.getLocalizedMessage() + " so, rejecting the record..");
            }
        }
    }
}

