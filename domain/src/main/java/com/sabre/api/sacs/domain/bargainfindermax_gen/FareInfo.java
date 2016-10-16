
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
    "FareReference",
    "TPA_Extensions"
})
public class FareInfo {

    @JsonProperty("FareReference")
    private String FareReference;
    @JsonProperty("TPA_Extensions")
    private TPAExtensions___ TPAExtensions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FareReference
     */
    @JsonProperty("FareReference")
    public String getFareReference() {
        return FareReference;
    }

    /**
     * 
     * @param FareReference
     *     The FareReference
     */
    @JsonProperty("FareReference")
    public void setFareReference(String FareReference) {
        this.FareReference = FareReference;
    }

    public FareInfo withFareReference(String FareReference) {
        this.FareReference = FareReference;
        return this;
    }

    /**
     * 
     * @return
     *     The TPAExtensions
     */
    @JsonProperty("TPA_Extensions")
    public TPAExtensions___ getTPAExtensions() {
        return TPAExtensions;
    }

    /**
     * 
     * @param TPAExtensions
     *     The TPA_Extensions
     */
    @JsonProperty("TPA_Extensions")
    public void setTPAExtensions(TPAExtensions___ TPAExtensions) {
        this.TPAExtensions = TPAExtensions;
    }

    public FareInfo withTPAExtensions(TPAExtensions___ TPAExtensions) {
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

    public FareInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
