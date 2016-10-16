
package com.sabre.api.sacs.domain.bargainfindermax_gen;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DirectionInd",
    "OriginDestinationOptions"
})
public class AirItinerary {

    @JsonProperty("DirectionInd")
    private String DirectionInd;
    @JsonProperty("OriginDestinationOptions")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOptions OriginDestinationOptions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DirectionInd
     */
    @JsonProperty("DirectionInd")
    public String getDirectionInd() {
        return DirectionInd;
    }

    /**
     * 
     * @param DirectionInd
     *     The DirectionInd
     */
    @JsonProperty("DirectionInd")
    public void setDirectionInd(String DirectionInd) {
        this.DirectionInd = DirectionInd;
    }

    public AirItinerary withDirectionInd(String DirectionInd) {
        this.DirectionInd = DirectionInd;
        return this;
    }

    /**
     * 
     * @return
     *     The OriginDestinationOptions
     */
    @JsonProperty("OriginDestinationOptions")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOptions getOriginDestinationOptions() {
        return OriginDestinationOptions;
    }

    /**
     * 
     * @param OriginDestinationOptions
     *     The OriginDestinationOptions
     */
    @JsonProperty("OriginDestinationOptions")
    public void setOriginDestinationOptions(com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOptions OriginDestinationOptions) {
        this.OriginDestinationOptions = OriginDestinationOptions;
    }

    public AirItinerary withOriginDestinationOptions(com.sabre.api.sacs.domain.bargainfindermax_gen.OriginDestinationOptions OriginDestinationOptions) {
        this.OriginDestinationOptions = OriginDestinationOptions;
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

    public AirItinerary withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }
}
