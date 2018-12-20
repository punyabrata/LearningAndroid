package com.learner.learndroid.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learner.learndroid.Product;
import com.learner.learndroid.R;

public class DetailActivity extends AppCompatActivity {
    /**
     * Tag is debugging purpose.
     */
    private static final String TAG = "DetailActivity";
    /**
     * Product Id tag.
     */
    private static final String PRODUCT_ID = "PRODUCT_ID";
    /**
     * The view model instance.
     */
    private DetailViewModel detailViewModel;

    /**
     * Activity on-create method.
     *
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        Log.d(TAG, "Detail activity onCreate.");

        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        String productId = getIntent().getStringExtra(PRODUCT_ID);
        detailViewModel.getProductById(productId).observe(this, new Observer<Product>() {
            @Override
            public void onChanged(@Nullable Product product) {
                updateDetailView(product);
            }
        });

    }

    /**
     * Updates the detail view.
     *
     * @param product Product object.
     */
    private void updateDetailView(Product product) {
        Log.d(TAG, "Product Received.");
        if (product == null)
            throw new NullPointerException("Product Detail Unavailable.");
        ImageView productImageView = findViewById(R.id.product_detail_image);
        TextView ratingView = findViewById(R.id.ratingView);
        TextView ratingText = findViewById(R.id.ratingText);
        TextView productName = findViewById(R.id.detail_product_name);
        TextView productOriginalPrice = findViewById(R.id.product_original_price);
        TextView productDealPrice = findViewById(R.id.product_sale_price);
        TextView productDescription = findViewById(R.id.product_detail_description);

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
