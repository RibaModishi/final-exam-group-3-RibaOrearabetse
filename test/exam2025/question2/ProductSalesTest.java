package exam2025.question2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

// Q2.5 ensure limit maths
public class ProductSalesTest {

    private ProductSales productSales;

    @Before
    public void setUp() {
        productSales = new ProductSales();
    }

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        assertEquals(2, productSales.GetSalesOverLimit());
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        assertEquals(4, productSales.GetSalesUnderLimit());
    }
}

