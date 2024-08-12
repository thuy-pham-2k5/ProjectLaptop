package com.example.shop_laptop.productlist;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDataSaver {
    private static final String FILE_PATH = "students.txt";

    public void saveData(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Product product : products) {
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> loadData() {
        List<Product> products = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Tạo tệp tin nếu không tồn tại
            } catch (IOException e) {
                e.printStackTrace();
            }
            return products; // Trả về danh sách rỗng nếu tệp tin mới tạo
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int price = Integer.parseInt(data[2]);
                products.add(new Product(id, name, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
