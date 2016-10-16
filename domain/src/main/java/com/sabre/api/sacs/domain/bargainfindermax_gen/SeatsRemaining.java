
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
    "Number",
    "BelowMin"
})
public class SeatsRemaining {

    @JsonProperty("Number")
    private Integer Number;
    @JsonProperty("BelowMin")
    private Boolean BelowMin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Number
     */
    @JsonProperty("Number")
    public Integer getNumber() {
        return Number;
    }

    /**
     * 
     * @param Number
     *     The Number
     */
    @JsonProperty("Number")
    public void setNumber(Integer Number) {
        this.Number = Number;
    }

    public SeatsRemaining withNumber(Integer Number) {
        this.Number = Number;
        return this;
    }

    /**
     * 
     * @return
     *     The BelowMin
     */
    @JsonProperty("BelowMin")
    public Boolean getBelowMin() {
        return BelowMin;
    }

    /**
     * 
     * @param BelowMin
     *     The BelowMin
     */
    @JsonProperty("BelowMin")
    public void setBelowMin(Boolean BelowMin) {
        this.BelowMin = BelowMin;
    }

    public SeatsRemaining withBelowMin(Boolean BelowMin) {
        this.BelowMin = BelowMin;
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

    public SeatsRemaining withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
