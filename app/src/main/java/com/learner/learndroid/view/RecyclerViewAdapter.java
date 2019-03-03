package com.learner.learndroid.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
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
     * @param i         View type.
     * @return View holder object.
     */
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_list_item,
                viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    /**
     * Gets called when the view holder is bound.
     *
     * @param recyclerViewHolder View holder object.
     * @param i                  Item index.
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, final int i) {
        Log.d(TAG, "Binding view holder for position " + i);

        final Item item = productItems.get(i);

        recyclerViewHolder.productName.setText(item.getName());
        recyclerViewHolder.productDescription.setText(item.getShortDescription());

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
        recyclerViewHolder.originalPrice.setText(originalPriceText);

        String dealPrice = String.format(Locale.US, "%.2f", sale);
        String dealPriceText = context.getString(R.string.deal_price_text, dealPrice);
        recyclerViewHolder.dealPrice.setText(dealPriceText);

        recyclerViewHolder.youSaveText.setText(String.valueOf(save));

        Glide.with(context)
                .asBitmap()
                .load(item.getThumbnailImage())
                .into(recyclerViewHolder.productImage);

        recyclerViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Clicked on " + item.getName());
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(PRODUCT_ID, item.getItemId().toString());
                context.startActivity(intent);


            }
        });
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
     * The view holder class for recycler view.
     */
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        /**
         * View holder entries.
         */
        TextView productName;
        ImageView productImage;
        TextView productDescription;
        TextView originalPrice;
        TextView dealPrice;
        TextView youSaveText;
        ConstraintLayout parentLayout;


        /**
         * View holder constructor.
         *
         * @param itemView Item view.
         */
        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productImage = itemView.findViewById(R.id.product_detail_image);
            productDescription = itemView.findViewById(R.id.product_description);
            originalPrice = itemView.findViewById(R.id.original_price);
            dealPrice = itemView.findViewById(R.id.deal_price);
            youSaveText = itemView.findViewById(R.id.you_save_text);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
