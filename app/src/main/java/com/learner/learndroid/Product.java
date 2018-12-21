package com.learner.learndroid;

/**
 * Product wrapper class.
 * TODO: This will be discontinued.
 */
public class Product {
    /**
     * Member variables.
     */
    private String productID;
    private String productName;
    private String productImageURL;
    private String productDescription;
    private float productOriginalPrice;
    private float productDealPrice;
    private String productYouSaveText;
    private float rating;

    /**
     * Constructor.
     *
     * @param productID            ID
     * @param productName          Name
     * @param productImageURL      URL
     * @param productDescription   Description
     * @param productOriginalPrice Original Price
     * @param productDealPrice     Deal Price
     * @param productYouSaveText   You save text.
     * @param rating               Product rating.
     */
    public Product(String productID, String productName, String productImageURL, String productDescription,
                   float productOriginalPrice, float productDealPrice, String productYouSaveText, float rating) {
        this.productID = productID;
        this.productName = productName;
        this.productImageURL = productImageURL;
        this.productDescription = productDescription;
        this.productOriginalPrice = productOriginalPrice;
        this.productDealPrice = productDealPrice;
        this.productYouSaveText = productYouSaveText;
        this.rating = rating;
    }


    /**
     * Gets the product ID.
     *
     * @return String.
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Gets the product name.
     *
     * @return String.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Gets the product image URL.
     *
     * @return String.
     */
    public String getProductImageURL() {
        return productImageURL;
    }

    /**
     * Gets the product description.
     *
     * @return String.
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Gets the product original price.
     *
     * @return Float.
     */
    public float getProductOriginalPrice() {
        return productOriginalPrice;
    }

    /**
     * Gets the product deal price.
     *
     * @return Float.
     */
    public float getProductDealPrice() {
        return productDealPrice;
    }

    /**
     * Gets the product you-save-text.
     *
     * @return String.
     */
    public String getProductYouSaveText() {
        return productYouSaveText;
    }

    /**
     * Gets the product rating.
     * @return Float.
     */
    public float getRating() {
        return rating;
    }
}
