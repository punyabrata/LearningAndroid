package com.learner.learndroid.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.learner.learndroid.R;
import com.learner.learndroid.entity.trending.Item;
import com.learner.learndroid.view.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * Recycler view types.
     */
    public static final int LIST_TYPE = 0;
    public static final int GRID_TYPE = 1;
    /**
     * Tag for debugging.
     */
    private static final String TAG = "RecyclerViewAdapter";
    /**
     * List of products
     */
    private List<Item> productItems = new ArrayList<>();
    /**
     * Product Id tag.
     */
    private static final String PRODUCT_ID = "PRODUCT_ID";
    /**
     * Context.
     */
    private Context context;
    /**
     * Recycler view type.
     */
    private int viewType;

    /**
     * Default constructor.
     *
     * @param context Context.
     */
    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    /**
     * Gets called when the view holder is created.
     *
     * @param viewGroup View group.
     * @param viewType  View type.
     * @return View holder object.
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case LIST_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_list_item,
                        viewGroup, false);
                return new ListViewHolder(view);
            case GRID_TYPE:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_grid_item,
                        viewGroup, false);
                return new GridViewHolder(view);
        }
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_list_item,
                viewGroup, false);
        return new ListViewHolder(view);
    }

    /**
     * Gets called when the view holder is bound.
     *
     * @param recyclerViewHolder View holder object.
     * @param i                  Item index.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder recyclerViewHolder, final int i) {
        Log.d(TAG, "Binding view holder for position " + i);

        final Item item = productItems.get(i);
        switch (recyclerViewHolder.getItemViewType()) {
            case LIST_TYPE:
                setViewHolderValues((ListViewHolder) recyclerViewHolder, item);
                break;
            case GRID_TYPE:
                setViewHolderValues((GridViewHolder) recyclerViewHolder, item);
                break;
        }

    }

    /**
     * Sets the view holder component values.
     *
     * @param recyclerViewHolder View Holder
     * @param item               Item.
     */
    private void setViewHolderValues(@NonNull IViewHolder recyclerViewHolder, Item item) {
        recyclerViewHolder.setProductNameText(item.getName());
        recyclerViewHolder.setProductDescriptionText(item.getShortDescription());

        Double msrp = 0d;
        Double sale = 0d;
        Double save;

        if (item.getMsrp() != null) {
            msrp = item.getMsrp();
        }

        if (item.getSalePrice() != null) {
            sale = item.getSalePrice();
        }
        save = msrp - sale;

        String originalPrice = String.format(Locale.US, "%.2f", msrp);
        String originalPriceText = context.getString(R.string.original_price_text, originalPrice);
        if (msrp > sale) {
            recyclerViewHolder.showOriginalPrice();
            recyclerViewHolder.setOriginalPriceText(originalPriceText);
        } else {
            recyclerViewHolder.hideOriginalPrice();
        }

        String dealPrice = String.format(Locale.US, "%.2f", sale);
        String dealPriceText = context.getString(R.string.deal_price_text, dealPrice);
        recyclerViewHolder.setDealPriceText(dealPriceText);

        if (save > 0) {
            String yourPrice = String.format(Locale.US, "%.2f", save);
            String youSaveText = context.getString(R.string.you_save_text, yourPrice);
            recyclerViewHolder.setYouSaveText(youSaveText);
        } else {
            recyclerViewHolder.setYouSaveText(context.getString(R.string.best_price_text));
        }


        Glide.with(context)
                .asBitmap()
                .load(item.getThumbnailImage())
                .into(recyclerViewHolder.getProductImage());
    }

    /**
     * Gets the item count.
     *
     * @return Integer.
     */
    @Override
    public int getItemCount() {
        return productItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return this.viewType;
    }

    /**
     * Sets item data
     *
     * @param data data
     */
    public void setItemData(List<Item> data) {
        productItems.clear();
        productItems.addAll(data);
    }

    /**
     * Sets the view type.
     *
     * @param viewType The view type.
     */
    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    /**
     * The view holder class for recycler view.
     */
    public class ListViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        /**
         * View holder entries.
         */
        @BindView(R.id.product_name)
        TextView productName;
        @BindView(R.id.product_image)
        ImageView productImage;
        @BindView(R.id.product_description)
        TextView productDescription;
        @BindView(R.id.original_price)
        TextView originalPrice;
        @BindView(R.id.deal_price)
        TextView dealPrice;
        @BindView(R.id.you_save_text)
        TextView youSaveText;
        @BindView(R.id.parent_layout)
        CardView parentLayout;


        /**
         * View holder constructor.
         *
         * @param itemView Item view.
         */
        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        /**
         * Item on-click method.
         */
        @OnClick(R.id.parent_layout)
        void onclick() {
            final Item item = productItems.get(getAdapterPosition());
            Log.d(TAG, "Clicked on " + item.getName());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(PRODUCT_ID, item.getItemId().toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

        @Override
        public void setProductNameText(String text) {
            this.productName.setText(text);
        }

        @Override
        public void setProductDescriptionText(String text) {
            this.productDescription.setText(text);
        }

        @Override
        public void showOriginalPrice() {
            this.originalPrice.setVisibility(View.VISIBLE);
        }

        @Override
        public void hideOriginalPrice() {
            this.originalPrice.setVisibility(View.GONE);
        }

        @Override
        public void setOriginalPriceText(String text) {
            this.originalPrice.setText(text);
        }

        @Override
        public void setDealPriceText(String text) {
            this.dealPrice.setText(text);
        }

        @Override
        public void setYouSaveText(String text) {
            this.youSaveText.setText(text);
        }

        @Override
        public ImageView getProductImage() {
            return this.productImage;
        }
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements IViewHolder {
        /**
         * View holder entries.
         */
        @BindView(R.id.grid_product_name)
        TextView productName;
        @BindView(R.id.grid_product_image)
        ImageView productImage;
        @BindView(R.id.grid_original_price)
        TextView originalPrice;
        @BindView(R.id.grid_deal_price)
        TextView dealPrice;
        @BindView(R.id.grid_you_save_text)
        TextView youSaveText;
        @BindView(R.id.parent_grid_layout)
        CardView parentLayout;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        /**
         * Item on-click method.
         */
        @OnClick(R.id.parent_grid_layout)
        void onclick() {
            final Item item = productItems.get(getAdapterPosition());
            Log.d(TAG, "Clicked on " + item.getName());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(PRODUCT_ID, item.getItemId().toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

        @Override
        public void setProductNameText(String text) {
            this.productName.setText(text);
        }

        @Override
        public void setProductDescriptionText(String text) {
            // Not implemented for grid layout
        }

        @Override
        public void showOriginalPrice() {
            this.originalPrice.setVisibility(View.VISIBLE);
        }

        @Override
        public void hideOriginalPrice() {
            this.originalPrice.setVisibility(View.GONE);
        }

        @Override
        public void setOriginalPriceText(String text) {
            this.originalPrice.setText(text);
        }

        @Override
        public void setDealPriceText(String text) {
            this.dealPrice.setText(text);
        }

        @Override
        public void setYouSaveText(String text) {
            this.youSaveText.setText(text);
        }

        @Override
        public ImageView getProductImage() {
            return this.productImage;
        }
    }
}
