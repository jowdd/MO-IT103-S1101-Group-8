package com.group.motorph.ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.group.motorph.models.Employee;
import com.group.motorph.models.WeeklyTotals;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import com.group.motorph.utilities.Formatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jude
 */
public class ConsoleUI {
    
    // Date formatter for displaying dates (Month dd, yyyy).
    private static final DateTimeFormatter DISPLAY_DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    
    /**
     * Displays the welcome message for the MotorPH Payroll System. This is
     * shown at the start of the program to identify the application.
     */
    public static void displayWelcomeMessage() {
        System.out.println("-------------------------");
        System.out.println("MotorPH Payroll System");
        System.out.println("-------------------------");
    }
    
    /**
     * Displays detailed weekly salary information in a formatted manner. This
     * includes pay period dates, earnings, allowances, deductions, and net pay.
     * @param weekly The weekly totals containing hours worked and overtime
     * @param employee The employee data containing rates and allowances
     * @param sss The SSS contribution amount
     * @param pagIbig The Pag-IBIG contribution amount
     * @param philHealth The PhilHealth contribution amount
     * @param tax The withholding tax amount
     * @param grossWeekPay The gross weekly pay
     * @param netWeekPay The net weekly pay after deductions
     */
    public static void displayWeeklySalary(WeeklyTotals weekly, Employee employee,
            double sss, double pagIbig, double philHealth, double tax, double grossWeekPay, double netWeekPay) {

        // Display pay period dates in a readable format
        System.out.println("Pay Period: "
                + weekly.getPayPeriodStart().format(DISPLAY_DATE_FORMATTER) + " - "
                + weekly.getPayPeriodEnd().format(DISPLAY_DATE_FORMATTER));

        // Display weekly earning details
        System.out.println("--- Weekly Earning ---");
        System.out.println("Hours Worked: " + Formatter.formatDecimal(weekly.getWeeklyHours()));
        System.out.println("Hourly Rate: " + Formatter.formatDecimal(employee.getHourlyRate()));
        System.out.println("Over Time: " + Formatter.formatDecimal(weekly.getWeeklyOverTime()));

        // Display weekly allowances (monthly allowances divided by 4)
        System.out.println("--- Weekly Allowances ---");
        System.out.println("Rice Subsidy: " + Formatter.formatDecimal(employee.getRiceSubsidy() / 4));
        System.out.println("Phone Allowance: " + Formatter.formatDecimal(employee.getPhoneAllowance() / 4));
        System.out.println("Clothing Allowance: " + Formatter.formatDecimal(employee.getClothingAllowance() / 4));

        // Display government-mandated deductions
        System.out.println("--- Deductions ---");
        System.out.println("SSS: " + Formatter.formatDecimal(sss));
        System.out.println("PAGIbig: " + Formatter.formatDecimal(pagIbig));
        System.out.println("Phil Health: " + Formatter.formatDecimal(philHealth));
        System.out.println("Withholding Tax: " + Formatter.formatDecimal(tax));

        // Display final pay details
        System.out.println("Gross Pay: " + Formatter.formatDecimal(grossWeekPay));
        System.out.println("Net Pay: " + Formatter.formatDecimal(netWeekPay));
        System.out.println("-------------------------------------------------------");
    }
    
    
    /**
     * Displays basic employee details from the loaded employee data.This 
     * includes personal information and position details.
     * @param employeeData The list where the employee data are stored
     */
    public static void displayEmployeeDetails(Employee employeeData) {

            // Display section header for employee information
            System.out.println("\n----------------------");
            System.out.println("Employee Information");
            System.out.println("----------------------");

            // Display basic employee details
            System.out.println("Employee ID: " + employeeData.getId());
            System.out.println("Employee Name: " + employeeData.getLastName() + ", " + employeeData.getFirstName());
            System.out.println("Birthday: " + employeeData.getBirthday());
            System.out.println("Status: " + employeeData.getStatus());
            System.out.println("Position: " + employeeData.getPosition() + "\n");
            System.out.println("-------------------------------------------------------");

            // Display section header for salary information
            System.out.println("Salary Details");
            System.out.println("-------------------------------------------------------");
    }
}