package com.learner.learndroid.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learner.learndroid.Product;
import com.learner.learndroid.R;
import com.learner.learndroid.data.APIData;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";

    private ImageView productImageView;
    private TextView ratingView;
    private TextView ratingText;
    private TextView productName;
    private TextView productOriginalPrice;
    private TextView productDealPrice;
    private TextView productDescription;

    /**
     * Product Id tag.
     */
    private static final String PRODUCT_ID = "PRODUCT_ID";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        Log.d(TAG, "Detail activity onCreate.");
        String productId = getIntent().getStringExtra(PRODUCT_ID);
        Product product = APIData.getProductById(productId);
        updateDetailView(product);
    }

    private void updateDetailView(Product product) {
        Log.d(TAG, "Product Received.");
        if (product == null)
            throw new NullPointerException("Product Detail Unavailable.");
        productImageView = findViewById(R.id.product_detail_image);
        ratingView = findViewById(R.id.ratingView);
        ratingText = findViewById(R.id.ratingText);
        productName = findViewById(R.id.detail_product_name);
        productOriginalPrice = findViewById(R.id.product_original_price);
        productDealPrice = findViewById(R.id.product_sale_price);
        productDescription = findViewById(R.id.product_detail_description);

        Glide.with(this)
                .asBitmap()
                .load(product.getProductImageURL())
                .into(productImageView);

        ratingView.setText("3 out of 5 *");
        ratingText.setText("3/5");
        productName.setText(product.getProductName());
        productOriginalPrice.setText(product.getProductOriginalPrice());
        productDealPrice.setText(product.getProductDealPrice());
        productDescription.setText(product.getProductDescription());
    }
}
