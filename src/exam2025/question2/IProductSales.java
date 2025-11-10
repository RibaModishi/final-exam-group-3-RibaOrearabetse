package exam2025.question2;

// Q2.4 sales rules
public interface IProductSales {

    int[][] GetProductSales();

    int GetTotalSales();

    int GetSalesOverLimit();

    int GetSalesUnderLimit();

    int GetProductsProcessed();

    double GetAverageSales();
}

