package exam2025.question2;

import java.util.Arrays;

// Q2.4 does the maths
public class ProductSales implements IProductSales {

    private static final int SALES_LIMIT = 500;

    private final int[][] sales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    private final String[] productNames = {"Microphone", "Speakers", "Mixing Desk"};

    public int getSalesLimit() {
        return SALES_LIMIT;
    }

    public String[] getProductNames() {
        return Arrays.copyOf(productNames, productNames.length);
    }

    @Override
    public int[][] GetProductSales() {
        int[][] copy = new int[sales.length][];
        for (int i = 0; i < sales.length; i++) {
            copy[i] = Arrays.copyOf(sales[i], sales[i].length);
        }
        return copy;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : sales) {
            for (int value : year) {
                total += value;
            }
        }
        return total;
    }

    @Override
    public double GetAverageSales() {
        int count = sales.length * sales[0].length;
        return (double) GetTotalSales() / count;
    }

    @Override
    public int GetSalesOverLimit() {
        return countByLimit(true);
    }

    @Override
    public int GetSalesUnderLimit() {
        return countByLimit(false);
    }

    @Override
    public int GetProductsProcessed() {
        return sales.length;
    }

    private int countByLimit(boolean overLimit) {
        int count = 0;
        for (int[] year : sales) {
            for (int value : year) {
                if (overLimit && value > SALES_LIMIT) {
                    count++;
                } else if (!overLimit && value <= SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }
}

