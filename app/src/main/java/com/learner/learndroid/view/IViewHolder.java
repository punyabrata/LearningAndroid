package com.learner.learndroid.view;

import android.widget.ImageView;

public interface IViewHolder {
    void setProductNameText(String text);
    void setProductDescriptionText(String text);
    void setOriginalPriceText(String text);
    void setDealPriceText(String text);
    void setYouSaveText(String text);
    ImageView getProductImage();
}
