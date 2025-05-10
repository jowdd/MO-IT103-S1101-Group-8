/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group.motorph.models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author jude
 */
public class TimeLogs {
    
    private final String employeeId;

    // Time tracking data
    
    /**
     * The calendar date for this attendance record. Stored as a LocalDate
     * object for accurate date calculations.
     */
    private final LocalDate date;

    /**
     * The time when the employee checked in or started work. Used to calculate
     * total hours worked and any late penalties.
     */
    private final LocalTime logIn;

    /**
     * The time when the employee checked out or ended work. Used to calculate
     * total hours worked and any overtime.
     */
    private final LocalTime logOut;

    /**
     * Total number of regular hours worked for this day. This excludes overtime
     * hours and is capped at standard workday length.
     */
    private final double hoursWorked;

    /**
     * Total number of overtime hours worked for this day. These are hours
     * worked beyond the standard workday length.
     */
    private final double overTime;

    /**
     * The week number of the year (1-52) for this time log entry. Used to group
     * entries for weekly payroll processing.
     */
    private final int weekNumber;

    /**
     * Constructs a new TimeLogDetails object with the specified parameters.This constructor initializes a complete time log entry for an employee.
     *
     * @param employeeId
     * @param date The date of the time log entry
     * @param logIn The time the employee started work
     * @param logOut The time the employee ended work
     * @param hoursWorked The total regular hours worked for the day
     * @param overTime The total overtime hours for the day
     * @param weekNumber The week number within the year
     */
    public TimeLogs(String employeeId, LocalDate date, LocalTime logIn, LocalTime logOut, double hoursWorked, double overTime, int weekNumber) {
        
        this.employeeId = employeeId;
        this.date = date;
        this.logIn = logIn;
        this.logOut = logOut;
        this.hoursWorked = hoursWorked;
        this.overTime = overTime;
        this.weekNumber = weekNumber;
    }
    
    // Getters
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public int getWeekNumber() {
        return weekNumber;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    public double getOverTime() {
        return overTime;
    }
    

    /**
     * Returns a string representation of the TimeLogDetails object. This method
     * formats the time log data into a human-readable format that can be used
     * for display, logging, or debugging purposes.
     *
     * @return A formatted string containing all time log data fields
     */
    @Override
    public String toString() {
        return String.format("Employee ID: %s, Date: %s, Log In: %s, Log Out: %s, Hours Worked: %.2f, Over Time: %.2f, Week Number: %d",
                employeeId, date, logIn, logOut, hoursWorked, overTime, weekNumber);
    }
    
}
