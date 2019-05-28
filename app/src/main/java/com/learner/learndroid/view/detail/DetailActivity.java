package com.learner.learndroid.view.detail;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learner.learndroid.R;
import com.learner.learndroid.app.LearnDroidApplication;
import com.learner.learndroid.entity.trending.Item;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

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
     * Product image.
     */
    @BindView(R.id.product_detail_image)
    ImageView productImageView;

    /**
     * Product rating.
     */
    @BindView(R.id.ratingView)
    RatingBar ratingView;

    /**
     * Rating text.
     */
    @BindView(R.id.ratingText)
    TextView ratingText;

    /**
     * Product name.
     */
    @BindView(R.id.detail_product_name)
    TextView productName;

    /**
     * Product original price.
     */
    @BindView(R.id.product_original_price)
    TextView productOriginalPrice;

    /**
     * Product sale price.
     */
    @BindView(R.id.product_sale_price)
    TextView productDealPrice;

    /**
     * Product description.
     */
    @BindView(R.id.product_detail_description)
    TextView productDescription;

    /**
     * Action bar.
     */
    @BindView(R.id.detail_toolbar)
    Toolbar actionBar;

    /**
     * Activity on-create method.
     *
     * @param savedInstanceState Bundle.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);
        ButterKnife.bind(this);
        Log.d(TAG, "Detail activity onCreate.");

        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        LearnDroidApplication application = (LearnDroidApplication) getApplication();
        detailViewModel.setRepository(application.getRepository());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    /**
     * Activity on-resume method.
     */
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

        Glide.with(this)
                .asBitmap()
                .load(item.getLargeImage())
                .into(productImageView);

        productName.setText(item.getName());


        Double msrp = 0d;
        Double sale = 0d;

        if (item.getMsrp() != null) {
            msrp = item.getMsrp();
        }

        if (item.getSalePrice() != null) {
            sale = item.getSalePrice();
        }

        String originalPrice = String.format(Locale.US, "%.2f", msrp);
        String originalPriceText = getApplicationContext().getString(R.string.original_price_text, originalPrice);
        productOriginalPrice.setText(originalPriceText);

        String dealPrice = String.format(Locale.US, "%.2f", sale);
        String dealPriceText = getApplicationContext().getString(R.string.deal_price_text, dealPrice);
        productDealPrice.setText(dealPriceText);

        productDescription.setText(item.getShortDescription());

        float productRating = Float.valueOf(item.getCustomerRating());
        String productRatingValue = String.valueOf(productRating);
        String productRatingText = getApplicationContext().getString(R.string.product_rating_text, productRatingValue);
        ratingView.setRating(productRating);
        ratingText.setText(productRatingText);
    }
}
