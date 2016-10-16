
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
    "GMTOffset"
})
public class DepartureTimeZone {

    @JsonProperty("GMTOffset")
    private Double GMTOffset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The GMTOffset
     */
    @JsonProperty("GMTOffset")
    public Double getGMTOffset() {
        return GMTOffset;
    }

    /**
     * 
     * @param GMTOffset
     *     The GMTOffset
     */
    @JsonProperty("GMTOffset")
    public void setGMTOffset(Double GMTOffset) {
        this.GMTOffset = GMTOffset;
    }

    public DepartureTimeZone withGMTOffset(Double GMTOffset) {
        this.GMTOffset = GMTOffset;
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

    public DepartureTimeZone withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
