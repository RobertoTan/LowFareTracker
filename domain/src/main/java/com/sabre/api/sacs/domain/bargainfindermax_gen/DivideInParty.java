
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
    "Indicator"
})
public class DivideInParty {

    @JsonProperty("Indicator")
    private Boolean Indicator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Indicator
     */
    @JsonProperty("Indicator")
    public Boolean getIndicator() {
        return Indicator;
    }

    /**
     * 
     * @param Indicator
     *     The Indicator
     */
    @JsonProperty("Indicator")
    public void setIndicator(Boolean Indicator) {
        this.Indicator = Indicator;
    }

    public DivideInParty withIndicator(Boolean Indicator) {
        this.Indicator = Indicator;
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

    public DivideInParty withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
