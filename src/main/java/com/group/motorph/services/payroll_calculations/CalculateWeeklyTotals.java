package com.group.motorph.services.payroll_calculations;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.group.motorph.models.Employee;
import com.group.motorph.models.TimeLogs;
import com.group.motorph.models.WeeklyTotals;
import java.time.LocalDate;

/**
 *
 * @author jude
 */
public class CalculateWeeklyTotals {
    
    /**
     * Calculates weekly totals for hours worked and overtime from the time
     * sheet data.This aggregates daily values into weekly summaries and establishes pay period dates.
     * @param timeSheet The list where the loaded employee time logs are stored 
     * @param weeklyTotals The list where the weekly totals are being stored
     */
    public static void calculateWeeklyTotals(Employee employee) {

        // Process each time log entry to calculate weekly totals
        for (TimeLogs log : employee.getTimeLogs()) {
            // Find existing weekly total for this week or create a new one
            WeeklyTotals weeklyTotal = findOrCreateWeeklyTotal(log.getEmployeeId(), log.getWeekNumber(), log.getDate(), employee);
            
            // Update pay period start and end dates to cover all dates in this week
            updatePayPeriodDates(weeklyTotal, log.getDate());

            // Add this day's hours to the weekly total
            double weeklyTotalHours = 0;
            double weeklyOverTime = 0;
            
            weeklyTotalHours += log.getHoursWorked();
            
            weeklyTotal.setWeeklyHoursWorked(weeklyTotalHours);
            
            // Add this day's overtime to the weekly total
            weeklyOverTime += log.getOverTime();
            
            weeklyTotal.setWeeklyOverTime(weeklyOverTime);
        }
    }
    
    
    /**
     * Finds an existing weekly total record or creates a new one if none
     * exists. This helps in organizing time sheet data by week for salary
     * calculations.
     *
     * @param weekNumber The week number to find or create
     * @param date The date associated with this week
     * @return The existing or newly created WeeklyTotals object
     */
    private static WeeklyTotals findOrCreateWeeklyTotal(String employeeId, int weekNumber, LocalDate date, Employee employee) {

        // Look through existing weekly totals to find a match
        for (WeeklyTotals wt : employee.getWeeklyTotals()) {

            // If we already have data for this week, return it
            if (wt.getWeekNumber() == weekNumber) {

                // Return existing record for this week
                return wt;
            }
        }

        // If week not found, create a new weekly total record
        // Initialize with the current date as both start and end date
        WeeklyTotals newTotal = new WeeklyTotals(employeeId, weekNumber, date, date);

        // Add the new weekly total to our collection
        employee.addWeeklyTotal(newTotal);
        return newTotal;
    }
    
    
    /**
     * Updates the pay period start and end dates based on the given date. This
     * ensures that the pay period spans all dates within the week.
     *
     * @param weeklyTotal The weekly total record to update
     * @param date The date to consider for updating pay period dates
     */
    private static void updatePayPeriodDates(WeeklyTotals weeklyTotal, LocalDate date) {

        // If this date is earlier than current start date, update start date
        if (date.compareTo(weeklyTotal.getPayPeriodStart()) < 0) {

            // New earliest date in the pay period
            weeklyTotal.setPayPeriodStart(date);
        }

        // If this date is later than current end date, update end date
        if (date.compareTo(weeklyTotal.getPayPeriodEnd()) > 0) {

            // New latest date in the pay period
            weeklyTotal.setPayPeriodEnd(date);
        }
    }
    
}
