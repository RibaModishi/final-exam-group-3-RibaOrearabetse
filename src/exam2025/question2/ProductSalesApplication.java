package exam2025.question2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// Q2.1 build the GUI
public class ProductSalesApplication extends JFrame {

    private final ProductSales productSales = new ProductSales();
    private final JTextArea outputArea = new JTextArea();
    private final JLabel yearsLabel = new JLabel("Years Processed: 0");

    public ProductSalesApplication() {
        super("Product Sales Application");
        buildUi();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ProductSalesApplication frame = new ProductSalesApplication();
            frame.setVisible(true);
        });
    }

    private void buildUi() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 360);
        setLocationRelativeTo(null);

        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JButton loadButton = new JButton("Load Product Data");
        loadButton.addActionListener(e -> loadData());

        JButton saveButton = new JButton("Save Product Data");
        saveButton.addActionListener(e -> saveData());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(loadButton);
        topPanel.add(saveButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(yearsLabel, BorderLayout.SOUTH);

        setJMenuBar(createMenuBar());
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> dispose());
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem loadItem = new JMenuItem("Load Product Data");
        loadItem.addActionListener(e -> loadData());

        JMenuItem saveItem = new JMenuItem("Save Product Data");
        saveItem.addActionListener(e -> saveData());

        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        return menuBar;
    }

    // Q2.2 gather and show the data
    private void loadData() {
        StringBuilder builder = new StringBuilder();

        int[][] sales = productSales.GetProductSales();
        String[] names = productSales.getProductNames();
        for (int year = 0; year < sales.length; year++) {
            builder.append("Sales for year ").append(year + 1).append("\n");
            for (int product = 0; product < sales[year].length; product++) {
                builder.append(names[product]).append(": ")
                        .append(sales[year][product]).append("\n");
            }
            builder.append("\n");
        }

        builder.append("Total Sales: ").append(productSales.GetTotalSales()).append("\n");
        builder.append("Average Sales: ").append((int) Math.floor(productSales.GetAverageSales())).append("\n");
        builder.append("Sales over limit: ").append(productSales.GetSalesOverLimit()).append("\n");
        builder.append("Sales under limit: ").append(productSales.GetSalesUnderLimit()).append("\n");
        builder.append("Years Processed: ").append(productSales.GetProductsProcessed()).append("\n");

        outputArea.setText(builder.toString());
        yearsLabel.setText("Years Processed: " + productSales.GetProductsProcessed());
    }

    // Q2.2 save summary to file
    private void saveData() {
        if (outputArea.getText().isEmpty()) {
            loadData();
        }
        StringBuilder builder = new StringBuilder();
        builder.append("DATA LOG\n\n");
        builder.append("***********************************\n\n");
        builder.append("Total Sales: ").append(productSales.GetTotalSales()).append("\n");
        builder.append("Average Sales: ").append((int) Math.floor(productSales.GetAverageSales())).append("\n");
        builder.append("Sales over limit: ").append(productSales.GetSalesOverLimit()).append("\n");
        builder.append("Sales under limit: ").append(productSales.GetSalesUnderLimit()).append("\n");
        builder.append("***********************************\n\n");
        try {
            Files.writeString(Path.of("data.txt"), builder.toString());
            JOptionPane.showMessageDialog(this, "Product data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save file: " + ex.getMessage(),
                    "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Q2.3 clear info
    private void clearData() {
        outputArea.setText("");
        yearsLabel.setText("Years Processed: 0");
    }
}

