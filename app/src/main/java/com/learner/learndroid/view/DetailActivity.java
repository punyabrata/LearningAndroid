package com.learner.learndroid.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learner.learndroid.R;
import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.repository.ProductRepository;
import com.learner.learndroid.service.WalmartService;

import java.util.Locale;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        //This code has to be uncommented once DB is fully implemented.
        //AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        //AppDatabase.class, "database-name").build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WalmartService.TREND_BASE_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WalmartService service = retrofit.create(WalmartService.class);
        ProductRepository productRepository = new ProductRepository(service);
        detailViewModel.setRepository(productRepository);

    }

    @Override
    protected void onResume() {
        super.onResume();

        String itemId = getIntent().getStringExtra(PRODUCT_ID);
        detailViewModel.getItem(itemId).observe(this, new Observer<Item>() {
            @Override
            public void onChanged(@Nullable Item item) {
                updateDetailView(item);
            }
        });
    }

    /**
     * Updates the detail view.
     *
     * @param item Product object.
     */
    private void updateDetailView(Item item) {
        Log.d(TAG, "Product Received.");
        if (item == null)
            throw new NullPointerException("Product Detail Unavailable.");
        ImageView productImageView = findViewById(R.id.product_detail_image);
        RatingBar ratingView = findViewById(R.id.ratingView);
        TextView ratingText = findViewById(R.id.ratingText);
        TextView productName = findViewById(R.id.detail_product_name);
        TextView productOriginalPrice = findViewById(R.id.product_original_price);
        TextView productDealPrice = findViewById(R.id.product_sale_price);
        TextView productDescription = findViewById(R.id.product_detail_description);
        Button doneButton = findViewById(R.id.done_button);

        Glide.with(this)
                .asBitmap()
                .load(item.getLargeImage())
                .into(productImageView);

        productName.setText(item.getName());


        Double msrp = 0d;
        Double sale = 0d;

        if(item.getMsrp() != null) {
            msrp = item.getMsrp();
        }

        if(item.getSalePrice() != null) {
            sale = item.getSalePrice();
        }

        String originalPrice = String.format(Locale.US, "%.2f", msrp);
        String originalPriceText = getApplicationContext().getString(R.string.original_price_text, originalPrice);
        productOriginalPrice.setText(originalPriceText);

        String dealPrice = String.format(Locale.US, "%.2f", sale);
        String dealPriceText = getApplicationContext().getString(R.string.deal_price_text, dealPrice);
        productDealPrice.setText(dealPriceText);

        productDescription.setText(item.getLongDescription());

        float productRating = Float.valueOf(item.getCustomerRating());
        String productRatingValue = String.valueOf(productRating);
        String productRatingText = getApplicationContext().getString(R.string.product_rating_text, productRatingValue);
        ratingView.setRating(productRating);
        ratingText.setText(productRatingText);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
