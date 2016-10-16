
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
    "Cabin",
    "SeatsRemaining"
})
public class TPA_Extensions__ {

    @JsonProperty("Cabin")
    private com.sabre.api.sacs.domain.instaflight_gen.Cabin Cabin;
    @JsonProperty("SeatsRemaining")
    private com.sabre.api.sacs.domain.instaflight_gen.SeatsRemaining SeatsRemaining;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Cabin
     */
    @JsonProperty("Cabin")
    public com.sabre.api.sacs.domain.instaflight_gen.Cabin getCabin() {
        return Cabin;
    }

    /**
     * 
     * @param Cabin
     *     The Cabin
     */
    @JsonProperty("Cabin")
    public void setCabin(com.sabre.api.sacs.domain.instaflight_gen.Cabin Cabin) {
        this.Cabin = Cabin;
    }

    /**
     * 
     * @return
     *     The SeatsRemaining
     */
    @JsonProperty("SeatsRemaining")
    public com.sabre.api.sacs.domain.instaflight_gen.SeatsRemaining getSeatsRemaining() {
        return SeatsRemaining;
    }

    /**
     * 
     * @param SeatsRemaining
     *     The SeatsRemaining
     */
    @JsonProperty("SeatsRemaining")
    public void setSeatsRemaining(com.sabre.api.sacs.domain.instaflight_gen.SeatsRemaining SeatsRemaining) {
        this.SeatsRemaining = SeatsRemaining;
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
