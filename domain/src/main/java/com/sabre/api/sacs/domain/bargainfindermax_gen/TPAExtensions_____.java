
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
    "ValidatingCarrier"
})
public class TPAExtensions_____ {

    @JsonProperty("ValidatingCarrier")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.ValidatingCarrier ValidatingCarrier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ValidatingCarrier
     */
    @JsonProperty("ValidatingCarrier")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.ValidatingCarrier getValidatingCarrier() {
        return ValidatingCarrier;
    }

    /**
     * 
     * @param ValidatingCarrier
     *     The ValidatingCarrier
     */
    @JsonProperty("ValidatingCarrier")
    public void setValidatingCarrier(com.sabre.api.sacs.domain.bargainfindermax_gen.ValidatingCarrier ValidatingCarrier) {
        this.ValidatingCarrier = ValidatingCarrier;
    }

    public TPAExtensions_____ withValidatingCarrier(com.sabre.api.sacs.domain.bargainfindermax_gen.ValidatingCarrier ValidatingCarrier) {
        this.ValidatingCarrier = ValidatingCarrier;
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

    public TPAExtensions_____ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
