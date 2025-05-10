/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.motorph.services.payroll_calculations;

/**
 *
 * @author jude
 */
public class CalculateOvertimePay {
    
    /**
     * Calculates overtime pay based on hours and rate. Overtime is paid at 1.25
     * times the regular hourly rate.
     *
     * @param overTime The number of overtime hours
     * @param hourlyRate The regular hourly rate
     * @return The overtime pay amount
     */
    public static double calculateOvertimePay(double overTime, double hourlyRate) {
        return overTime * (hourlyRate + (hourlyRate * 0.25));
    }
    
}
