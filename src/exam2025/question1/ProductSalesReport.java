package exam2025.question1;

import java.util.Arrays;

// Q1.2 handles sales maths
public class ProductSalesReport implements ProductSales {

    private final double[][] salesByYearAndQuarter;

    // save sales info
    public ProductSalesReport(double[][] salesByYearAndQuarter) {
        if (salesByYearAndQuarter == null || salesByYearAndQuarter.length == 0) {
            throw new IllegalArgumentException("Sales data must not be null or empty.");
        }
        this.salesByYearAndQuarter = deepCopy(salesByYearAndQuarter);
    }

    @Override
    public double calculateTotalSales() {
        double total = 0.0;
        for (double[] yearSales : salesByYearAndQuarter) {
            for (double quarterSale : yearSales) {
                total += quarterSale;
            }
        }
        return total;
    }

    @Override
    public double calculateAverageSales() {
        int dataPoints = 0;
        double total = 0.0;
        for (double[] yearSales : salesByYearAndQuarter) {
            for (double quarterSale : yearSales) {
                total += quarterSale;
                dataPoints++;
            }
        }
        if (dataPoints == 0) {
            throw new IllegalStateException("Sales data contains no entries.");
        }
        return total / dataPoints;
    }

    @Override
    public double findMaximumSale() {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] yearSales : salesByYearAndQuarter) {
            for (double quarterSale : yearSales) {
                max = Math.max(max, quarterSale);
            }
        }
        return max;
    }

    @Override
    public double findMinimumSale() {
        double min = Double.POSITIVE_INFINITY;
        for (double[] yearSales : salesByYearAndQuarter) {
            for (double quarterSale : yearSales) {
                min = Math.min(min, quarterSale);
            }
        }
        return min;
    }

    // make copy to protect data
    private double[][] deepCopy(double[][] source) {
        double[][] copy = new double[source.length][];
        for (int i = 0; i < source.length; i++) {
            copy[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return copy;
    }
}

