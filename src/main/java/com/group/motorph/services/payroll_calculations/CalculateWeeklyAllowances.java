/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.motorph.services.payroll_calculations;

import com.group.motorph.models.Employee;

/**
 *
 * @author jude
 */
public class CalculateWeeklyAllowances {
    
     /**
     * Calculates weekly allowances from monthly allowance values. This divides
     * each monthly allowance by 4 to get weekly equivalent amounts.
     *
     * @param data The employee data containing allowance information
     * @return The total weekly allowances
     */
    public static double calculateWeeklyAllowances(Employee data) {

        // Sum all monthly allowances and divide by 4 to get weekly value
        // Assumes 4 weeks in a month for calculation purposes
        return (data.getClothingAllowance() + data.getPhoneAllowance() + data.getRiceSubsidy()) / 4;
    }
    
}
