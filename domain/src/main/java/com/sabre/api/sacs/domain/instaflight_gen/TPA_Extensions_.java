
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
    "ValidatingCarrier"
})
public class TPA_Extensions_ {

    @JsonProperty("ValidatingCarrier")
    private com.sabre.api.sacs.domain.instaflight_gen.ValidatingCarrier ValidatingCarrier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ValidatingCarrier
     */
    @JsonProperty("ValidatingCarrier")
    public com.sabre.api.sacs.domain.instaflight_gen.ValidatingCarrier getValidatingCarrier() {
        return ValidatingCarrier;
    }

    /**
     * 
     * @param ValidatingCarrier
     *     The ValidatingCarrier
     */
    @JsonProperty("ValidatingCarrier")
    public void setValidatingCarrier(com.sabre.api.sacs.domain.instaflight_gen.ValidatingCarrier ValidatingCarrier) {
        this.ValidatingCarrier = ValidatingCarrier;
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
