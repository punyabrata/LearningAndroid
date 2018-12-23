package com.learner.learndroid.entity.trending;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class Item {

    @PrimaryKey
    @SerializedName("itemId")
    @Expose
    private Long itemId;

    @ColumnInfo(name="parentItemId")
    @SerializedName("parentItemId")
    @Expose
    private Long parentItemId;

    @SerializedName("name")
    @Expose
    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name = "msrp")
    @SerializedName("msrp")
    @Expose
    private Double msrp;

    @ColumnInfo(name = "salePrice")
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;

    @ColumnInfo(name = "upc")
    @SerializedName("upc")
    @Expose
    private String upc;

    @Ignore
    @SerializedName("categoryPath")
    @Expose
    private String categoryPath;

    @SerializedName("shortDescription")
    @Expose
    @ColumnInfo(name = "shortDescription")
    private String shortDescription;

    @ColumnInfo(name = "longDescription")
    @SerializedName("longDescription")
    @Expose
    private String longDescription;

    @Ignore
    @SerializedName("brandName")
    @Expose
    private String brandName;

    @ColumnInfo(name = "thumbnailImage")
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;

    @ColumnInfo(name = "mediumImage")
    @SerializedName("mediumImage")
    @Expose
    private String mediumImage;

    @ColumnInfo(name = "largeImage")
    @SerializedName("largeImage")
    @Expose
    private String largeImage;

    @Ignore
    @SerializedName("productTrackingUrl")
    @Expose
    private String productTrackingUrl;
    @Ignore
    @SerializedName("ninetySevenCentShipping")
    @Expose
    private Boolean ninetySevenCentShipping;
    @Ignore
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @Ignore
    @SerializedName("color")
    @Expose
    private String color;
    @Ignore
    @SerializedName("marketplace")
    @Expose
    private Boolean marketplace;
    @Ignore
    @SerializedName("modelNumber")
    @Expose
    private String modelNumber;
    @Ignore
    @SerializedName("sellerInfo")
    @Expose
    private String sellerInfo;
    @Ignore
    @SerializedName("productUrl")
    @Expose
    private String productUrl;

    @ColumnInfo(name = "customerRating")
    @SerializedName("customerRating")
    @Expose
    private String customerRating;

    @ColumnInfo(name = "numReviews")
    @SerializedName("numReviews")
    @Expose
    private Integer numReviews;

    @ColumnInfo(name = "customerRatingImage")
    @SerializedName("customerRatingImage")
    @Expose
    private String customerRatingImage;
    @Ignore
    @SerializedName("categoryNode")
    @Expose
    private String categoryNode;
    @Ignore
    @SerializedName("rhid")
    @Expose
    private String rhid;
    @Ignore
    @SerializedName("bundle")
    @Expose
    private Boolean bundle;
    @Ignore
    @SerializedName("clearance")
    @Expose
    private Boolean clearance;
    @Ignore
    @SerializedName("preOrder")
    @Expose
    private Boolean preOrder;
    @Ignore
    @SerializedName("stock")
    @Expose
    private String stock;

    @Ignore
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @Ignore
    @SerializedName("addToCartUrl")
    @Expose
    private String addToCartUrl;
    @Ignore
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    private String affiliateAddToCartUrl;
    @Ignore
    @SerializedName("freeShippingOver35Dollars")
    @Expose
    private Boolean freeShippingOver35Dollars;
    @Ignore
    @SerializedName("giftOptions")
    @Expose
    private GiftOptions giftOptions;
    @Ignore
    @SerializedName("imageEntities")
    @Expose
    private List<ImageEntity> imageEntities = null;
    @Ignore
    @SerializedName("offerType")
    @Expose
    private String offerType;
    @Ignore
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;
    @Ignore
    @SerializedName("shipToStore")
    @Expose
    private Boolean shipToStore;
    @Ignore
    @SerializedName("freeShipToStore")
    @Expose
    private Boolean freeShipToStore;
    @Ignore
    @SerializedName("bestMarketplacePrice")
    @Expose
    private BestMarketplacePrice bestMarketplacePrice;
    @Ignore
    @SerializedName("gender")
    @Expose
    private String gender;
    @Ignore
    @SerializedName("age")
    @Expose
    private String age;
    @Ignore
    @SerializedName("isTwoDayShippingEligible")
    @Expose
    private Boolean isTwoDayShippingEligible;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Long parentItemId) {
        this.parentItemId = parentItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMsrp() {
        return msrp;
    }

    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    public Boolean getNinetySevenCentShipping() {
        return ninetySevenCentShipping;
    }

    public void setNinetySevenCentShipping(Boolean ninetySevenCentShipping) {
        this.ninetySevenCentShipping = ninetySevenCentShipping;
    }

    public Double getStandardShipRate() {
        return standardShipRate;
    }

    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Boolean marketplace) {
        this.marketplace = marketplace;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSellerInfo() {
        return sellerInfo;
    }

    public void setSellerInfo(String sellerInfo) {
        this.sellerInfo = sellerInfo;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getCustomerRating() {
        return customerRating;
    }

    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    public String getCategoryNode() {
        return categoryNode;
    }

    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    public String getRhid() {
        return rhid;
    }

    public void setRhid(String rhid) {
        this.rhid = rhid;
    }

    public Boolean getBundle() {
        return bundle;
    }

    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    public Boolean getClearance() {
        return clearance;
    }

    public void setClearance(Boolean clearance) {
        this.clearance = clearance;
    }

    public Boolean getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Boolean preOrder) {
        this.preOrder = preOrder;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    public Boolean getFreeShippingOver35Dollars() {
        return freeShippingOver35Dollars;
    }

    public void setFreeShippingOver35Dollars(Boolean freeShippingOver35Dollars) {
        this.freeShippingOver35Dollars = freeShippingOver35Dollars;
    }

    public GiftOptions getGiftOptions() {
        return giftOptions;
    }

    public void setGiftOptions(GiftOptions giftOptions) {
        this.giftOptions = giftOptions;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

    public Boolean getShipToStore() {
        return shipToStore;
    }

    public void setShipToStore(Boolean shipToStore) {
        this.shipToStore = shipToStore;
    }

    public Boolean getFreeShipToStore() {
        return freeShipToStore;
    }

    public void setFreeShipToStore(Boolean freeShipToStore) {
        this.freeShipToStore = freeShipToStore;
    }

    public BestMarketplacePrice getBestMarketplacePrice() {
        return bestMarketplacePrice;
    }

    public void setBestMarketplacePrice(BestMarketplacePrice bestMarketplacePrice) {
        this.bestMarketplacePrice = bestMarketplacePrice;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getIsTwoDayShippingEligible() {
        return isTwoDayShippingEligible;
    }

    public void setIsTwoDayShippingEligible(Boolean isTwoDayShippingEligible) {
        this.isTwoDayShippingEligible = isTwoDayShippingEligible;
    }

}
