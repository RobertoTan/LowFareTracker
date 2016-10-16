
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
    "DivideInParty"
})
public class TPAExtensions____ {

    @JsonProperty("DivideInParty")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.DivideInParty DivideInParty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The DivideInParty
     */
    @JsonProperty("DivideInParty")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.DivideInParty getDivideInParty() {
        return DivideInParty;
    }

    /**
     * 
     * @param DivideInParty
     *     The DivideInParty
     */
    @JsonProperty("DivideInParty")
    public void setDivideInParty(com.sabre.api.sacs.domain.bargainfindermax_gen.DivideInParty DivideInParty) {
        this.DivideInParty = DivideInParty;
    }

    public TPAExtensions____ withDivideInParty(com.sabre.api.sacs.domain.bargainfindermax_gen.DivideInParty DivideInParty) {
        this.DivideInParty = DivideInParty;
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

    public TPAExtensions____ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


}
