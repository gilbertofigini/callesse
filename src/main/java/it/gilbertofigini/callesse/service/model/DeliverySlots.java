
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
    "messages",
    "slotReservation",
    "forChangeSlot",
    "currentSlot",
    "slotReservationMessage",
    "numberOfDays",
    "bestRuleCarnetPromo",
    "startDate",
    "slots"
})
public class DeliverySlots {

    @JsonProperty("messages")
    private List<Object> messages = null;
    @JsonProperty("slotReservation")
    private Object slotReservation;
    @JsonProperty("forChangeSlot")
    private Boolean forChangeSlot;
    @JsonProperty("currentSlot")
    private Object currentSlot;
    @JsonProperty("slotReservationMessage")
    private Object slotReservationMessage;
    @JsonProperty("numberOfDays")
    private Integer numberOfDays;
    @JsonProperty("bestRuleCarnetPromo")
    private Boolean bestRuleCarnetPromo;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("slots")
    private List<Slot> slots = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("messages")
    public List<Object> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }

    @JsonProperty("slotReservation")
    public Object getSlotReservation() {
        return slotReservation;
    }

    @JsonProperty("slotReservation")
    public void setSlotReservation(Object slotReservation) {
        this.slotReservation = slotReservation;
    }

    @JsonProperty("forChangeSlot")
    public Boolean getForChangeSlot() {
        return forChangeSlot;
    }

    @JsonProperty("forChangeSlot")
    public void setForChangeSlot(Boolean forChangeSlot) {
        this.forChangeSlot = forChangeSlot;
    }

    @JsonProperty("currentSlot")
    public Object getCurrentSlot() {
        return currentSlot;
    }

    @JsonProperty("currentSlot")
    public void setCurrentSlot(Object currentSlot) {
        this.currentSlot = currentSlot;
    }

    @JsonProperty("slotReservationMessage")
    public Object getSlotReservationMessage() {
        return slotReservationMessage;
    }

    @JsonProperty("slotReservationMessage")
    public void setSlotReservationMessage(Object slotReservationMessage) {
        this.slotReservationMessage = slotReservationMessage;
    }

    @JsonProperty("numberOfDays")
    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    @JsonProperty("numberOfDays")
    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    @JsonProperty("bestRuleCarnetPromo")
    public Boolean getBestRuleCarnetPromo() {
        return bestRuleCarnetPromo;
    }

    @JsonProperty("bestRuleCarnetPromo")
    public void setBestRuleCarnetPromo(Boolean bestRuleCarnetPromo) {
        this.bestRuleCarnetPromo = bestRuleCarnetPromo;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("slots")
    public List<Slot> getSlots() {
        return slots;
    }

    @JsonProperty("slots")
    public void setSlots(List<Slot> slots) {
        this.slots = slots;
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
