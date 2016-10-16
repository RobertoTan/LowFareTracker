
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
    "NonRefundableIndicator"
})
public class Endorsements {

    @JsonProperty("NonRefundableIndicator")
    private Boolean NonRefundableIndicator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The NonRefundableIndicator
     */
    @JsonProperty("NonRefundableIndicator")
    public Boolean getNonRefundableIndicator() {
        return NonRefundableIndicator;
    }

    /**
     * 
     * @param NonRefundableIndicator
     *     The NonRefundableIndicator
     */
    @JsonProperty("NonRefundableIndicator")
    public void setNonRefundableIndicator(Boolean NonRefundableIndicator) {
        this.NonRefundableIndicator = NonRefundableIndicator;
    }

    public Endorsements withNonRefundableIndicator(Boolean NonRefundableIndicator) {
        this.NonRefundableIndicator = NonRefundableIndicator;
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

    public Endorsements withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
