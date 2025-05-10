/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.motorph.services.data_loader;

/**
 *
 * @author jude
 */

import com.group.motorph.models.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.group.motorph.utilities.ParseNumber;

public class LoadEmployeeData {
    
    /**
     * Loads employee data for the specified employee ID from the employee data file.
     * This includes personal information, position details, and compensation rates.
     * 
     * @param employeeDataPath The path file for employee data table
     * @param employees The list where the loaded employee data will be stored
     */
    public static void loadEmployeeData(String employeeDataPath, ArrayList<Employee> employees) {

        try (BufferedReader br = new BufferedReader(new FileReader(employeeDataPath))) {
            // Skip header
            br.readLine();

            String line;

            // Read each line of the employee data file
            while ((line = br.readLine()) != null) {

                // Split the line by tab character to get individual fields
                String[] fields = line.split("\t");

                // First field (index 0) contains the employee ID
                String employeeId = fields[0];


                // Extract employee information from specific positions in the TSV
                String lastName = fields[1];
                String firstName = fields[2];
                String birthday = fields[3];
                String status = fields[10];
                String position = fields[11];

                // Parse allowance values, removing commas and converting to double
                double riceSubsidy = ParseNumber.parseDouble(fields[14]);
                double phoneAllowance = ParseNumber.parseDouble(fields[15]);
                double clothingAllowance = ParseNumber.parseDouble(fields[16]);
                double hourlyRate = ParseNumber.parseDouble(fields[18]);

                // Create a new EmployeeData object with the extracted information
                Employee entry = new Employee(employeeId, lastName, firstName, birthday, status, position,
                        riceSubsidy, phoneAllowance, clothingAllowance, hourlyRate);

                // Add the employee data to our array list
                employees.add(entry);
            }
        } catch (IOException e) {
            System.err.println("Error reading employee data file: " + e.getMessage());
        }
    }
    
}
