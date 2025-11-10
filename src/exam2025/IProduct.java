package exam2025;

// Q1.2 sales rules
public interface IProduct {

    /**
     * Calculates the total sales across the configured period.
     *
     * @return total sales value
     */
    double calculateTotalSales();

    /**
     * Calculates the average sales across the configured period.
     *
     * @return average sales value
     */
    double calculateAverageSales();

    /**
     * Returns the maximum single sales entry recorded.
     *
     * @return maximum sales value
     */
    double findMaximumSale();

    /**
     * Returns the minimum single sales entry recorded.
     *
     * @return minimum sales value
     */
    double findMinimumSale();
}

