
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
    "PricedItinerary"
})
public class PricedItineraries {

    @JsonProperty("PricedItinerary")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.PricedItinerary> PricedItinerary = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.PricedItinerary>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The PricedItinerary
     */
    @JsonProperty("PricedItinerary")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.PricedItinerary> getPricedItinerary() {
        return PricedItinerary;
    }

    /**
     * 
     * @param PricedItinerary
     *     The PricedItinerary
     */
    @JsonProperty("PricedItinerary")
    public void setPricedItinerary(List<com.sabre.api.sacs.domain.bargainfindermax_gen.PricedItinerary> PricedItinerary) {
        this.PricedItinerary = PricedItinerary;
    }

    public PricedItineraries withPricedItinerary(List<com.sabre.api.sacs.domain.bargainfindermax_gen.PricedItinerary> PricedItinerary) {
        this.PricedItinerary = PricedItinerary;
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

    public PricedItineraries withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
