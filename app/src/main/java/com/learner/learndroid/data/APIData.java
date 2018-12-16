package com.learner.learndroid.data;

import com.learner.learndroid.Product;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.Nullable;

public class APIData {
    /**
     * Dummy method to get the products.
     * TODO: This will have to be replaced with the data coming from Repository.
     *
     * @return List of products.
     */
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product("1",
                "Apple Macbook Pro",
                "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p1);

        Product p2 = new Product("2",
                "Dell Laptop 16 Inch",
                "https://i.redd.it/tpsnoz5bzo501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p2);

        Product p3 = new Product("3",
                "Asus Laptop",
                "https://i.redd.it/qn7f9oqu7o501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p3);

        Product p4 = new Product("4",
                "Apple Macbook Super",
                "https://i.redd.it/j6myfqglup501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p4);

        Product p5 = new Product("5",
                "Lenovo Laptop 14 Inch",
                "https://i.redd.it/0h2gm1ix6p501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p5);

        Product p6 = new Product("6",
                "IBM Thinkpad",
                "https://i.redd.it/k98uzl68eh501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p6);

        Product p7 = new Product("7",
                "Google Chromebook",
                "https://i.redd.it/glin0nwndo501.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p7);

        Product p8 = new Product("8",
                "Sony Vio",
                "https://i.redd.it/obx4zydshg601.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p8);

        Product p9 = new Product("9",
                "Apple Macbook Air",
                "https://i.imgur.com/ZcLLrkY.jpg",
                "Very cool laptop to use",
                "$1000 USD",
                "$500 USD",
                "You save $500!");
        products.add(p9);

        return products;
    }

    /**
     * Gets a product based on its Id.
     *
     * @param id ID.
     * @return Product.
     */
    @Nullable
    public static Product getProductById(String id) {
        if (id == null || "".equals(id)) {
            throw new RuntimeException("Product Id cannot be null.");
        }

        List<Product> products = getProducts();
        for (Product product : products) {
            if (id.equals(product.getProductID())) {
                return product;
            }
        }
        return null;
    }
}
