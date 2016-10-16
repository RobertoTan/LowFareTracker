
package com.sabre.api.sacs.domain.instaflight_gen;

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
    "OriginDestinationOptions",
    "DirectionInd"
})
public class AirItinerary {

    @JsonProperty("OriginDestinationOptions")
    private com.sabre.api.sacs.domain.instaflight_gen.OriginDestinationOptions OriginDestinationOptions;
    @JsonProperty("DirectionInd")
    private String DirectionInd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The OriginDestinationOptions
     */
    @JsonProperty("OriginDestinationOptions")
    public com.sabre.api.sacs.domain.instaflight_gen.OriginDestinationOptions getOriginDestinationOptions() {
        return OriginDestinationOptions;
    }

    /**
     * 
     * @param OriginDestinationOptions
     *     The OriginDestinationOptions
     */
    @JsonProperty("OriginDestinationOptions")
    public void setOriginDestinationOptions(com.sabre.api.sacs.domain.instaflight_gen.OriginDestinationOptions OriginDestinationOptions) {
        this.OriginDestinationOptions = OriginDestinationOptions;
    }

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
