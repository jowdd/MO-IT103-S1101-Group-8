/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.motorph.models;

import java.time.LocalDate;
/**
 *
 * @author jude
 */
public class WeeklyTotals {
    
    private final String employeeId;
    
    /**
     * The week number within the year (1-52). This identifies which specific
     * week these totals represent.
     */
    private final int weekNumber;

    /**
     * The first day of the pay period for this week. This date marks the
     * beginning of the time period for which these totals apply.
     */
    private LocalDate payPeriodStart;

    /**
     * The last day of the pay period for this week. This date marks the end of
     * the time period for which these totals apply.
     */
    private LocalDate payPeriodEnd;

    /**
     * The total number of regular hours worked during this week. This sum
     * excludes overtime hours and is used for calculating base pay.
     */
    private double weeklyHoursWorked;

    /**
     * The total number of overtime hours worked during this week. These hours
     * are typically paid at a premium rate compared to regular hours.
     */
    private double weeklyOverTime;

    /**
     * Constructs a new WeeklyTotals object for the specified week and pay
     * period.This constructor initializes the week details and sets hour
 totals to zero. The totals are expected to be populated later by adding
 individual day records.
     *
     * @param employeeId
     * @param weekNumber The week number within the year
     * @param payPeriodStart The start date of the pay period
     * @param payPeriodEnd The end date of the pay period
     */
    public WeeklyTotals(String employeeId, int weekNumber, LocalDate payPeriodStart, LocalDate payPeriodEnd) {
        this.employeeId = employeeId;
        this.weekNumber = weekNumber;
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
        this.weeklyHoursWorked = 0.0;  // Initialize with zero hours worked
        this.weeklyOverTime = 0.0;     // Initialize with zero overtime hours
    }
    
    // Getters
    
    public int getWeekNumber() {
        return weekNumber;
    }
    
    public double getWeeklyHours() {
        return weeklyHoursWorked;
    }
    
    public double getWeeklyOverTime() {
        return weeklyOverTime;
    }
    
    public LocalDate getPayPeriodStart() {
        return payPeriodStart;
    }
    
    public LocalDate getPayPeriodEnd() {
        return payPeriodEnd;
    }
    
    
    // Setters
    
    public void setWeeklyHoursWorked(double hoursWorked) {
        this.weeklyHoursWorked = hoursWorked;
    }
    
    public void setWeeklyOverTime(double overTime) {
        this.weeklyOverTime = overTime;
    }
    
    public void setPayPeriodStart(LocalDate date) {
        this.payPeriodStart = date;
    }
    
    public void setPayPeriodEnd(LocalDate date) {
        this.payPeriodEnd = date;
    }


    /**
     * Returns a string representation of the WeeklyTotals object. This method
     * formats the weekly data into a human-readable string that can be used for
     * reporting, display, or debugging purposes.
     *
     * @return A formatted string containing all weekly total fields
     */
    @Override
    public String toString() {
        return String.format("Employee ID: %s, Week %d:, Pay Period Start Date: %s, Pay Period End Date: %s, Total Weekly Hours Worked: %.2f, Total Weekly Over Time: %.2f",
                employeeId, weekNumber, payPeriodStart, payPeriodEnd, weeklyHoursWorked, weeklyOverTime);
    }
    
}
