
package com.sabre.api.sacs.domain.bargainfindermax_gen;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SequenceNumber",
    "AirItinerary",
    "AirItineraryPricingInfo",
    "TicketingInfo",
    "TPA_Extensions"
})
public class PricedItinerary {

    @JsonProperty("SequenceNumber")
    private Integer SequenceNumber;
    @JsonProperty("AirItinerary")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.AirItinerary AirItinerary;
    @JsonProperty("AirItineraryPricingInfo")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.AirItineraryPricingInfo> AirItineraryPricingInfo = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.AirItineraryPricingInfo>();
    @JsonProperty("TicketingInfo")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.TicketingInfo TicketingInfo;
    @JsonProperty("TPA_Extensions")
    private TPAExtensions_____ TPAExtensions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The SequenceNumber
     */
    @JsonProperty("SequenceNumber")
    public Integer getSequenceNumber() {
        return SequenceNumber;
    }

    /**
     * 
     * @param SequenceNumber
     *     The SequenceNumber
     */
    @JsonProperty("SequenceNumber")
    public void setSequenceNumber(Integer SequenceNumber) {
        this.SequenceNumber = SequenceNumber;
    }

    public PricedItinerary withSequenceNumber(Integer SequenceNumber) {
        this.SequenceNumber = SequenceNumber;
        return this;
    }

    /**
     * 
     * @return
     *     The AirItinerary
     */
    @JsonProperty("AirItinerary")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.AirItinerary getAirItinerary() {
        return AirItinerary;
    }

    /**
     * 
     * @param AirItinerary
     *     The AirItinerary
     */
    @JsonProperty("AirItinerary")
    public void setAirItinerary(com.sabre.api.sacs.domain.bargainfindermax_gen.AirItinerary AirItinerary) {
        this.AirItinerary = AirItinerary;
    }

    public PricedItinerary withAirItinerary(com.sabre.api.sacs.domain.bargainfindermax_gen.AirItinerary AirItinerary) {
        this.AirItinerary = AirItinerary;
        return this;
    }

    /**
     * 
     * @return
     *     The AirItineraryPricingInfo
     */
    @JsonProperty("AirItineraryPricingInfo")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.AirItineraryPricingInfo> getAirItineraryPricingInfo() {
        return AirItineraryPricingInfo;
    }

    /**
     * 
     * @param AirItineraryPricingInfo
     *     The AirItineraryPricingInfo
     */
    @JsonProperty("AirItineraryPricingInfo")
    public void setAirItineraryPricingInfo(List<com.sabre.api.sacs.domain.bargainfindermax_gen.AirItineraryPricingInfo> AirItineraryPricingInfo) {
        this.AirItineraryPricingInfo = AirItineraryPricingInfo;
    }

    public PricedItinerary withAirItineraryPricingInfo(List<com.sabre.api.sacs.domain.bargainfindermax_gen.AirItineraryPricingInfo> AirItineraryPricingInfo) {
        this.AirItineraryPricingInfo = AirItineraryPricingInfo;
        return this;
    }

    /**
     * 
     * @return
     *     The TicketingInfo
     */
    @JsonProperty("TicketingInfo")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.TicketingInfo getTicketingInfo() {
        return TicketingInfo;
    }

    /**
     * 
     * @param TicketingInfo
     *     The TicketingInfo
     */
    @JsonProperty("TicketingInfo")
    public void setTicketingInfo(com.sabre.api.sacs.domain.bargainfindermax_gen.TicketingInfo TicketingInfo) {
        this.TicketingInfo = TicketingInfo;
    }

    public PricedItinerary withTicketingInfo(com.sabre.api.sacs.domain.bargainfindermax_gen.TicketingInfo TicketingInfo) {
        this.TicketingInfo = TicketingInfo;
        return this;
    }

    /**
     * 
     * @return
     *     The TPAExtensions
     */
    @JsonProperty("TPA_Extensions")
    public TPAExtensions_____ getTPAExtensions() {
        return TPAExtensions;
    }

    /**
     * 
     * @param TPAExtensions
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public void setTPAExtensions(TPAExtensions_____ TPAExtensions) {
        this.TPAExtensions = TPAExtensions;
    }

    public PricedItinerary withTPAExtensions(TPAExtensions_____ TPAExtensions) {
        this.TPAExtensions = TPAExtensions;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PricedItinerary withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
