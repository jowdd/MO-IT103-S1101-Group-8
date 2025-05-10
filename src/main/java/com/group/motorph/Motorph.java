/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.group.motorph;

import com.group.motorph.models.Employee;
import java.util.ArrayList;
import java.nio.file.Paths;
import com.group.motorph.services.data_loader.LoadEmployeeData;
import com.group.motorph.services.data_loader.LoadTimeSheet;
import com.group.motorph.ui.ConsoleUI;
import com.group.motorph.services.payroll_calculations.CalculateWeeklyTotals;
import com.group.motorph.services.payroll_calculations.CalculateAndDisplay;

/**
 *
 * @author jude
 */
public class Motorph {

    /**
     * ---- Constants. ----*
     */
    // Path to the CSV file containing employee attendance records.
    private static final String ATTENDANCE_RECORD_PATH = Paths.get("src", "main", "java", "com", "group", "motorph", "resources", "attendance-record.csv").toString();

    // Path to the TSV file containing employee information such as name, birthday, salary, allowances, etc.
    private static final String EMPLOYEE_DATA_PATH = Paths.get("src", "main", "java", "com", "group", "motorph", "resources", "employee-data.tsv").toString();

    // Path  to the TSV file containing SSS contribution table.
    private static final String SSS_TABLE_PATH = Paths.get("src", "main", "java", "com", "group", "motorph", "resources", "sss-contribution-table.tsv").toString();


    /**
     * ---- Data Structures. ----*
     */

    /*
    Stores employee data such as personal information, allowances, and salary rate.
    Each entry contains a single employee's complete profile.
     */
    static ArrayList<Employee> employees = new ArrayList<>();
    
    
    
    public static void main(String[] args) {
    
        LoadEmployeeData.loadEmployeeData(EMPLOYEE_DATA_PATH, employees);
        
        ConsoleUI.displayWelcomeMessage();
        
        for (Employee emp: employees) {
            String employeeId = emp.getId();
            
            LoadTimeSheet.loadTimeSheet(employeeId, ATTENDANCE_RECORD_PATH, emp);
            
            ConsoleUI.displayEmployeeDetails(emp);
            
            CalculateWeeklyTotals.calculateWeeklyTotals(emp);
            
            CalculateAndDisplay.calculateAndDisplaySalary(emp.getWeeklyTotals(), emp, SSS_TABLE_PATH);
        }
        
    }
    
}
