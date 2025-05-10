/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.motorph.services.payroll_calculations;

import com.group.motorph.models.Employee;
import com.group.motorph.models.WeeklyTotals;
import java.util.ArrayList;
import com.group.motorph.ui.ConsoleUI;
import com.group.motorph.services.government_contributions.CalculatePagIbig;
import com.group.motorph.services.government_contributions.CalculatePhilHealth;
import com.group.motorph.services.government_contributions.CalculateSss;
import com.group.motorph.services.government_contributions.CalculateWithholdingTax;

/**
 *
 * @author jude
 */
public class CalculateAndDisplay {
    
    /**
     * Calculates and displays salary details for each pay period.This includes
     * earnings, deductions, and net pay calculations.
     * @param weeklyTotals The list where the weekly totals are being stored
     * @param employee The list where the employee data are being stored
     * @param sssFilePath The file path for SSS contribution range table
     */
    public static void calculateAndDisplaySalary(ArrayList<WeeklyTotals> weeklyTotals, Employee employee, String sssFilePath) {

        // Process each week in the data
        for (WeeklyTotals weekly : weeklyTotals) {

                // Calculate weekly allowances from monthly values
                // Monthly allowances are divided by 4 to get weekly equivalent
                double weeklyAllowances = CalculateWeeklyAllowances.calculateWeeklyAllowances(employee);

                // Calculate overtime pay with 25% premium rate
                // Overtime is paid at 1.25 times the regular hourly rate
                double overtimePay = CalculateOvertimePay.calculateOvertimePay(weekly.getWeeklyOverTime(), employee.getHourlyRate());

                // Calculate regular weekly earnings (hours worked * hourly rate)
                // Plus overtime pay for total earnings
                double weeklyEarnings = (weekly.getWeeklyHours() * employee.getHourlyRate()) + overtimePay;

                // Calculate gross pay (earnings + allowances)
                double grossWeekPay = weeklyEarnings + weeklyAllowances;

                // Calculate mandatory government deductions
                double sss = CalculateSss.calculateSss(grossWeekPay, sssFilePath);
                double pagIbig = CalculatePagIbig.calculatePagIbig(grossWeekPay);
                double philHealth = CalculatePhilHealth.calculatePhilHealth(grossWeekPay);
                double tax = CalculateWithholdingTax.calculateWithholdingTax(weeklyEarnings);

                // Calculate net pay after all deductions
                double totalDeductions = sss + pagIbig + philHealth + tax;
                double netWeekPay = grossWeekPay - totalDeductions;

                // Display results in a formatted manner
                ConsoleUI.displayWeeklySalary(weekly, employee, sss, pagIbig, philHealth, tax, grossWeekPay, netWeekPay);
            
        }
    }
    
}
