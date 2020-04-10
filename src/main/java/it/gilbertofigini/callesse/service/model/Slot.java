
package it.gilbertofigini.callesse.service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "originalPrice",
    "storeManagerId",
    "price",
    "statusDescription",
    "reactivable",
    "cutoffInsert",
    "deliveryDiscountRuleId",
    "priceDiscount",
    "uniqueTimeId",
    "supermercatoOrdersPublicIds",
    "viewStatus",
    "endTime",
    "startTime",
    "active",
    "status"
})
public class Slot {

    @JsonProperty("originalPrice")
    private Double originalPrice;
    @JsonProperty("storeManagerId")
    private Integer storeManagerId;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("statusDescription")
    private Object statusDescription;
    @JsonProperty("reactivable")
    private Boolean reactivable;
    @JsonProperty("cutoffInsert")
    private Integer cutoffInsert;
    @JsonProperty("deliveryDiscountRuleId")
    private Object deliveryDiscountRuleId;
    @JsonProperty("priceDiscount")
    private Double priceDiscount;
    @JsonProperty("uniqueTimeId")
    private String uniqueTimeId;
    @JsonProperty("supermercatoOrdersPublicIds")
    private List<Object> supermercatoOrdersPublicIds = null;
    @JsonProperty("viewStatus")
    private String viewStatus;
    @JsonProperty("endTime")
    private String endTime;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("originalPrice")
    public Double getOriginalPrice() {
        return originalPrice;
    }

    @JsonProperty("originalPrice")
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @JsonProperty("storeManagerId")
    public Integer getStoreManagerId() {
        return storeManagerId;
    }

    @JsonProperty("storeManagerId")
    public void setStoreManagerId(Integer storeManagerId) {
        this.storeManagerId = storeManagerId;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("statusDescription")
    public Object getStatusDescription() {
        return statusDescription;
    }

    @JsonProperty("statusDescription")
    public void setStatusDescription(Object statusDescription) {
        this.statusDescription = statusDescription;
    }

    @JsonProperty("reactivable")
    public Boolean getReactivable() {
        return reactivable;
    }

    @JsonProperty("reactivable")
    public void setReactivable(Boolean reactivable) {
        this.reactivable = reactivable;
    }

    @JsonProperty("cutoffInsert")
    public Integer getCutoffInsert() {
        return cutoffInsert;
    }

    @JsonProperty("cutoffInsert")
    public void setCutoffInsert(Integer cutoffInsert) {
        this.cutoffInsert = cutoffInsert;
    }

    @JsonProperty("deliveryDiscountRuleId")
    public Object getDeliveryDiscountRuleId() {
        return deliveryDiscountRuleId;
    }

    @JsonProperty("deliveryDiscountRuleId")
    public void setDeliveryDiscountRuleId(Object deliveryDiscountRuleId) {
        this.deliveryDiscountRuleId = deliveryDiscountRuleId;
    }

    @JsonProperty("priceDiscount")
    public Double getPriceDiscount() {
        return priceDiscount;
    }

    @JsonProperty("priceDiscount")
    public void setPriceDiscount(Double priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    @JsonProperty("uniqueTimeId")
    public String getUniqueTimeId() {
        return uniqueTimeId;
    }

    @JsonProperty("uniqueTimeId")
    public void setUniqueTimeId(String uniqueTimeId) {
        this.uniqueTimeId = uniqueTimeId;
    }

    @JsonProperty("supermercatoOrdersPublicIds")
    public List<Object> getSupermercatoOrdersPublicIds() {
        return supermercatoOrdersPublicIds;
    }

    @JsonProperty("supermercatoOrdersPublicIds")
    public void setSupermercatoOrdersPublicIds(List<Object> supermercatoOrdersPublicIds) {
        this.supermercatoOrdersPublicIds = supermercatoOrdersPublicIds;
    }

    @JsonProperty("viewStatus")
    public String getViewStatus() {
        return viewStatus;
    }

    @JsonProperty("viewStatus")
    public void setViewStatus(String viewStatus) {
        this.viewStatus = viewStatus;
    }

    @JsonProperty("endTime")
    public String getEndTime() {
        return endTime;
    }

    @JsonProperty("endTime")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
