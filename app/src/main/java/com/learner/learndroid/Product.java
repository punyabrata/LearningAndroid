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
    private String productOriginalPrice;
    private String productDealPrice;
    private String productYouSaveText;


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
     */
    public Product(String productID, String productName, String productImageURL, String productDescription,
                   String productOriginalPrice, String productDealPrice, String productYouSaveText) {
        this.productID = productID;
        this.productName = productName;
        this.productImageURL = productImageURL;
        this.productDescription = productDescription;
        this.productOriginalPrice = productOriginalPrice;
        this.productDealPrice = productDealPrice;
        this.productYouSaveText = productYouSaveText;
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
     * @return String.
     */
    public String getProductOriginalPrice() {
        return productOriginalPrice;
    }

    /**
     * Gets the product deal price.
     *
     * @return String.
     */
    public String getProductDealPrice() {
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
}
