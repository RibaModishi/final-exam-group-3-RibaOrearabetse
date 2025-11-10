/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exam2025;

/**
 *
 * @author lab_services_student
 */
public class Exam2025 {

    /**
     * @param args the command line arguments
     */
    // Q1.1 start program
    public static void main(String[] args) {
        double[][] quarterlySales = {
            {300, 150, 700},
            {250, 200, 600}
        };

        ProductSalesReport report = new ProductSalesReport(quarterlySales);

        double totalSales = report.calculateTotalSales();
        double averageSales = report.calculateAverageSales();
        double maximumSale = report.findMaximumSale();
        double minimumSale = report.findMinimumSale();

        printReport(totalSales, averageSales, maximumSale, minimumSale);
    }

    // Q1.1 print report lines
    private static void printReport(double totalSales, double averageSales, double maximumSale, double minimumSale) {
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("------------------------------");
        System.out.printf("Total Sales: %.0f%n", totalSales);
        System.out.printf("Average Sales: %d%n", Math.round(averageSales));
        System.out.printf("Maximum sales: %.0f%n", maximumSale);
        System.out.printf("Minimum sales: %.0f%n", minimumSale);
    }
    
}
