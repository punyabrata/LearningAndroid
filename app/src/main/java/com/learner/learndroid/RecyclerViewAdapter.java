package com.learner.learndroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    /**
     * Tag for debugging.
     */
    private static final String TAG = "RecyclerViewAdapter";
    /**
     * List of product names.
     */
    private ArrayList<String> productNames;
    /**
     * List of product image URLs.
     */
    private ArrayList<String> productImageURLs;
    /**
     * List of product descriptions.
     */
    private ArrayList<String> productDescriptions;
    /**
     * List of product original prices.
     */
    private ArrayList<String> productOriginalPrices;
    /**
     * List of product deal prices.
     */
    private ArrayList<String> productDealPrices;
    /**
     * List of product you save texts.
     */
    private ArrayList<String> productYouSaveTexts;
    /**
     * Context.
     */
    private Context context;


    /**
     * Default constructor.
     *
     * @param productNames          Product names.
     * @param productImageURLs      Product image urls.
     * @param productDescriptions   Product description.
     * @param productOriginalPrices Product original prices.
     * @param productDealPrices     Product deal prices.
     * @param productYouSaveTexts   Product you save texts.
     * @param context               Context.
     */
    public RecyclerViewAdapter(ArrayList<String> productNames, ArrayList<String> productImageURLs,
                               ArrayList<String> productDescriptions, ArrayList<String> productOriginalPrices,
                               ArrayList<String> productDealPrices, ArrayList<String> productYouSaveTexts,
                               Context context) {
        this.productNames = productNames;
        this.productImageURLs = productImageURLs;
        this.productDescriptions = productDescriptions;
        this.productOriginalPrices = productOriginalPrices;
        this.productDealPrices = productDealPrices;
        this.productYouSaveTexts = productYouSaveTexts;
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
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
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

        recyclerViewHolder.productName.setText(productNames.get(i));
        recyclerViewHolder.productDescription.setText(productDescriptions.get(i));
        recyclerViewHolder.originalPrice.setText(productOriginalPrices.get(i));
        recyclerViewHolder.dealPrice.setText(productDealPrices.get(i));
        recyclerViewHolder.youSaveText.setText(productYouSaveTexts.get(i));

        Glide.with(context)
                .asBitmap()
                .load(productImageURLs.get(i))
                .into(recyclerViewHolder.productImage);

        recyclerViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked on " + productNames.get(i));
                Toast.makeText(context, productNames.get(i), Toast.LENGTH_SHORT).show();
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
        return productNames.size();
    }

    /**
     * The view holder class for recycler view.
     */
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        /**
         * View holder entries.
         */
        TextView productName;
        CircleImageView productImage;
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
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productImage = itemView.findViewById(R.id.product_image);
            productDescription = itemView.findViewById(R.id.product_description);
            originalPrice = itemView.findViewById(R.id.original_price);
            dealPrice = itemView.findViewById(R.id.deal_price);
            youSaveText = itemView.findViewById(R.id.you_save_text);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
