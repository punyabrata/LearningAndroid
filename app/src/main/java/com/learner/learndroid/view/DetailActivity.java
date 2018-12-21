package com.learner.learndroid.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learner.learndroid.Product;
import com.learner.learndroid.R;

import java.util.Locale;

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
        RatingBar ratingView = findViewById(R.id.ratingView);
        TextView ratingText = findViewById(R.id.ratingText);
        TextView productName = findViewById(R.id.detail_product_name);
        TextView productOriginalPrice = findViewById(R.id.product_original_price);
        TextView productDealPrice = findViewById(R.id.product_sale_price);
        TextView productDescription = findViewById(R.id.product_detail_description);

        Glide.with(this)
                .asBitmap()
                .load(product.getProductImageURL())
                .into(productImageView);

        productName.setText(product.getProductName());


        String originalPrice = String.format(Locale.US, "%.2f", product.getProductOriginalPrice());
        String originalPriceText = getApplicationContext().getString(R.string.original_price_text, originalPrice);
        productOriginalPrice.setText(originalPriceText);

        String dealPrice = String.format(Locale.US, "%.2f", product.getProductDealPrice());
        String dealPriceText = getApplicationContext().getString(R.string.deal_price_text, dealPrice);
        productDealPrice.setText(dealPriceText);

        productDescription.setText(product.getProductDescription());

        float productRating = product.getRating();
        String productRatingValue = String.valueOf(productRating);
        String productRatingText = getApplicationContext().getString(R.string.product_rating_text, productRatingValue);
        ratingView.setRating(productRating);
        ratingText.setText(productRatingText);
    }
}
