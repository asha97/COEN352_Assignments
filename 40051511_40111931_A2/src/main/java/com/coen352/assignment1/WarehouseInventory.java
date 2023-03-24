package com.coen352.assignment1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class WarehouseInventory {
    protected DLLDictionary<String, Inventory> invDict;

    public void populateDatabase() throws IOException {
        System.out.println("=====  =====");
        this.invDict = new DLLDictionary<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("tf02930030.xltm");
        XSSFWorkbook workbook = new XSSFWorkbook(is);
        DataFormatter dataFormatter = new DataFormatter();
        Sheet sheet = workbook.getSheet("Inventory List");

        invDict.clear();
        int skip = 0;
        for (Row row : sheet) {
            if (skip < 4) {
                skip++;
                continue;
            }
            String SKU = dataFormatter.formatCellValue(row.getCell(1));
            Inventory item = new Inventory(
                    SKU,
                    dataFormatter.formatCellValue(row.getCell(2)),
                    dataFormatter.formatCellValue(row.getCell(3)),
                    dataFormatter.formatCellValue(row.getCell(4)),
                    dataFormatter.formatCellValue(row.getCell(5)),
                    Integer.parseInt(dataFormatter.formatCellValue(row.getCell(6))),
                    Integer.parseInt(dataFormatter.formatCellValue(row.getCell(7))),
                    Double.parseDouble(dataFormatter.formatCellValue(row.getCell(8)).substring(1)),
                    dataFormatter.formatCellValue(row.getCell(10)).equals("Reorder")
            );
            invDict.insert(SKU, item);
        }
    }

    public void clearDatabase() {
        this.invDict.clear();
    }

    public static void main(String[] args) throws IOException {

        WarehouseInventory wi = new WarehouseInventory();
        wi.populateDatabase();


        try {
            // Part 2
            System.out.println(Arrays.toString(wi.invDict.createIndex()));

            // PART 3: copy the dictionary
            DLLDictionary<String, Inventory> copy = new DLLDictionary<>(wi.invDict);
            Inventory[] unsortedarr = new Inventory[copy.size()];
            for (int i = 0; i < unsortedarr.length; i++) {
                unsortedarr[i] = copy.removeAny();
            }
            heapsort(unsortedarr);
            System.out.println(Arrays.toString(unsortedarr));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void heapsort(Inventory[] arr) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            Inventory temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, i, 0);
        }
    }

    public static void maxHeapify(Inventory[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        if (l < n && arr[l].getInventoryValue() < arr[largest].getInventoryValue())
            largest = l;

        if (r < n && arr[r].getInventoryValue() < arr[largest].getInventoryValue())
            largest = r;

        // If largest is not root
        if (largest != i) {
            Inventory swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively maxHeapify the affected sub-tree
            maxHeapify(arr, n, largest);
        }
    }
}
