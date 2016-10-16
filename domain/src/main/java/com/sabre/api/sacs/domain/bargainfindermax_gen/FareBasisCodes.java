
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
    "FareBasisCode"
})
public class FareBasisCodes {

    @JsonProperty("FareBasisCode")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCode> FareBasisCode = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCode>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The FareBasisCode
     */
    @JsonProperty("FareBasisCode")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCode> getFareBasisCode() {
        return FareBasisCode;
    }

    /**
     * 
     * @param FareBasisCode
     *     The FareBasisCode
     */
    @JsonProperty("FareBasisCode")
    public void setFareBasisCode(List<com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCode> FareBasisCode) {
        this.FareBasisCode = FareBasisCode;
    }

    public FareBasisCodes withFareBasisCode(List<com.sabre.api.sacs.domain.bargainfindermax_gen.FareBasisCode> FareBasisCode) {
        this.FareBasisCode = FareBasisCode;
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

    public FareBasisCodes withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
