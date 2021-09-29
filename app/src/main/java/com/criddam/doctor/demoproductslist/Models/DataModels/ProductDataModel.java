package com.criddam.doctor.demoproductslist.Models.DataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDataModel {

    @SerializedName("product_uuid")
    @Expose
    private String productUuid;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("average_rate")
    @Expose
    private Double averageRate;
    @SerializedName("creator_provider_uuid")
    @Expose
    private String creatorProviderUuid;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("discountable")
    @Expose
    private Boolean discountable;
    @SerializedName("visible")
    @Expose
    private Boolean visible;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("files")
    @Expose
    private List<File> files = null;
    @SerializedName("properties")
    @Expose
    private Properties properties;
    @SerializedName("min_units")
    @Expose
    private Integer minUnits;
    @SerializedName("max_units")
    @Expose
    private Integer maxUnits;
    @SerializedName("default_units")
    @Expose
    private Integer defaultUnits;
    @SerializedName("skip_children_price")
    @Expose
    private Boolean skipChildrenPrice;

    public String getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(String productUuid) {
        this.productUuid = productUuid;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(Double averageRate) {
        this.averageRate = averageRate;
    }

    public String getCreatorProviderUuid() {
        return creatorProviderUuid;
    }

    public void setCreatorProviderUuid(String creatorProviderUuid) {
        this.creatorProviderUuid = creatorProviderUuid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getDiscountable() {
        return discountable;
    }

    public void setDiscountable(Boolean discountable) {
        this.discountable = discountable;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Integer getMinUnits() {
        return minUnits;
    }

    public void setMinUnits(Integer minUnits) {
        this.minUnits = minUnits;
    }

    public Integer getMaxUnits() {
        return maxUnits;
    }

    public void setMaxUnits(Integer maxUnits) {
        this.maxUnits = maxUnits;
    }

    public Integer getDefaultUnits() {
        return defaultUnits;
    }

    public void setDefaultUnits(Integer defaultUnits) {
        this.defaultUnits = defaultUnits;
    }

    public Boolean getSkipChildrenPrice() {
        return skipChildrenPrice;
    }

    public void setSkipChildrenPrice(Boolean skipChildrenPrice) {
        this.skipChildrenPrice = skipChildrenPrice;
    }

    public class Price {

        @SerializedName("price_uuid")
        @Expose
        private String priceUuid;
        @SerializedName("price")
        @Expose
        private Double price;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("start_date")
        @Expose
        private String startDate;

        public String getPriceUuid() {
            return priceUuid;
        }

        public void setPriceUuid(String priceUuid) {
            this.priceUuid = priceUuid;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

    }

    public class Properties {

        @SerializedName("bundle_group")
        @Expose
        private String bundleGroup;
        @SerializedName("available_on")
        @Expose
        private String availableOn;
        @SerializedName("sell_on_its_own")
        @Expose
        private String sellOnItsOwn;
        @SerializedName("available")
        @Expose
        private String available;
        @SerializedName("print_order")
        @Expose
        private String printOrder;
        @SerializedName("print_item_component_order")
        @Expose
        private String printItemComponentOrder;
        @SerializedName("offer_price")
        @Expose
        private String offerPrice;
        @SerializedName("offer")
        @Expose
        private String offer;
        @SerializedName("categories_epos")
        @Expose
        private String categoriesEpos;
        @SerializedName("categories_key")
        @Expose
        private String categoriesKey;
        @SerializedName("review_enabled")
        @Expose
        private String reviewEnabled;
        @SerializedName("categories")
        @Expose
        private String categories;
        @SerializedName("sort_order")
        @Expose
        private String sortOrder;

        public String getBundleGroup() {
            return bundleGroup;
        }

        public void setBundleGroup(String bundleGroup) {
            this.bundleGroup = bundleGroup;
        }

        public String getAvailableOn() {
            return availableOn;
        }

        public void setAvailableOn(String availableOn) {
            this.availableOn = availableOn;
        }

        public String getSellOnItsOwn() {
            return sellOnItsOwn;
        }

        public void setSellOnItsOwn(String sellOnItsOwn) {
            this.sellOnItsOwn = sellOnItsOwn;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        public String getPrintOrder() {
            return printOrder;
        }

        public void setPrintOrder(String printOrder) {
            this.printOrder = printOrder;
        }

        public String getPrintItemComponentOrder() {
            return printItemComponentOrder;
        }

        public void setPrintItemComponentOrder(String printItemComponentOrder) {
            this.printItemComponentOrder = printItemComponentOrder;
        }

        public String getOfferPrice() {
            return offerPrice;
        }

        public void setOfferPrice(String offerPrice) {
            this.offerPrice = offerPrice;
        }

        public String getOffer() {
            return offer;
        }

        public void setOffer(String offer) {
            this.offer = offer;
        }

        public String getCategoriesEpos() {
            return categoriesEpos;
        }

        public void setCategoriesEpos(String categoriesEpos) {
            this.categoriesEpos = categoriesEpos;
        }

        public String getCategoriesKey() {
            return categoriesKey;
        }

        public void setCategoriesKey(String categoriesKey) {
            this.categoriesKey = categoriesKey;
        }

        public String getReviewEnabled() {
            return reviewEnabled;
        }

        public void setReviewEnabled(String reviewEnabled) {
            this.reviewEnabled = reviewEnabled;
        }

        public String getCategories() {
            return categories;
        }

        public void setCategories(String categories) {
            this.categories = categories;
        }

        public String getSortOrder() {
            return sortOrder;
        }

        public void setSortOrder(String sortOrder) {
            this.sortOrder = sortOrder;
        }

    }

    public class File {

        @SerializedName("file_uuid")
        @Expose
        private String fileUuid;
        @SerializedName("key_name")
        @Expose
        private String keyName;
        @SerializedName("file_name")
        @Expose
        private String fileName;
        @SerializedName("content_type")
        @Expose
        private String contentType;
        @SerializedName("scope")
        @Expose
        private String scope;
        @SerializedName("creation_date")
        @Expose
        private String creationDate;
        @SerializedName("last_update")
        @Expose
        private String lastUpdate;
        @SerializedName("product_uuid")
        @Expose
        private String productUuid;

        public String getFileUuid() {
            return fileUuid;
        }

        public void setFileUuid(String fileUuid) {
            this.fileUuid = fileUuid;
        }

        public String getKeyName() {
            return keyName;
        }

        public void setKeyName(String keyName) {
            this.keyName = keyName;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }

        public String getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(String lastUpdate) {
            this.lastUpdate = lastUpdate;
        }

        public String getProductUuid() {
            return productUuid;
        }

        public void setProductUuid(String productUuid) {
            this.productUuid = productUuid;
        }

    }
}

