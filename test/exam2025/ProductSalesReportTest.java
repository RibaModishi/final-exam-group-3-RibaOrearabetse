package exam2025;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// Q1.3 test maths
public class ProductSalesReportTest {

    private ProductSalesReport report;

    @Before
    public void setUp() {
        double[][] sales = {
            {300, 150, 700},
            {250, 200, 600}
        };
        report = new ProductSalesReport(sales);
    }

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        assertEquals(2200.0, report.calculateTotalSales(), 0.001);
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        assertEquals(2200.0 / 6, report.calculateAverageSales(), 0.001);
    }
}

