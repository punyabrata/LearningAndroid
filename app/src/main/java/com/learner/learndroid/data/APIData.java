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
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $200!",
                3.7f);
        products.add(p1);

        Product p2 = new Product("2",
                "Dell Laptop 16 Inch",
                "https://i.redd.it/tpsnoz5bzo501.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
        products.add(p2);

        Product p3 = new Product("3",
                "Asus Laptop",
                "https://i.redd.it/qn7f9oqu7o501.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
        products.add(p3);

        Product p4 = new Product("4",
                "Apple Macbook Super",
                "https://i.redd.it/j6myfqglup501.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
        products.add(p4);

        Product p5 = new Product("5",
                "Lenovo Laptop 14 Inch",
                "https://i.redd.it/0h2gm1ix6p501.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
        products.add(p5);

        Product p6 = new Product("6",
                "IBM Thinkpad",
                "https://i.redd.it/k98uzl68eh501.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
        products.add(p6);

        Product p7 = new Product("7",
                "Google Chromebook",
                "https://i.redd.it/glin0nwndo501.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
        products.add(p7);

        Product p8 = new Product("8",
                "Sony Vio",
                "https://i.redd.it/obx4zydshg601.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
        products.add(p8);

        Product p9 = new Product("9",
                "Apple Macbook Air",
                "https://i.imgur.com/ZcLLrkY.jpg",
                "Lorem ipsum dolor sit amet, his et tation qualisque. Quas ludus forensibus vel ad, esse nonumes te est. Ex petentium evertitur adolescens qui, per id quando dictas iisque, utinam saperet accusam ut sit. Ad impetus abhorreant quo, quo augue consulatu ea. Eu enim admodum euripidis ius. No unum dicit causae qui. Nam no odio enim errem, ei nostro albucius sadipscing vel. Usu ne maluisset argumentum, iusto appellantur ex eam. Velit dissentias mel ne, vis congue nostrud no. Nam at semper tamquam, ne vis debitis epicurei. Usu quas admodum nusquam te, te nam dicit noster iriure. Ne meis concludaturque est.",
                350.50f,
                150.50f,
                "You save $500!",
                3.7f);
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
