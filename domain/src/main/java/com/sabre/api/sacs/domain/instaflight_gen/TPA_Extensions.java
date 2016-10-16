
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
    "eTicket"
})
public class TPA_Extensions {

    @JsonProperty("eTicket")
    private ETicket eTicket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The eTicket
     */
    @JsonProperty("eTicket")
    public ETicket getETicket() {
        return eTicket;
    }

    /**
     * 
     * @param eTicket
     *     The eTicket
     */
    @JsonProperty("eTicket")
    public void setETicket(ETicket eTicket) {
        this.eTicket = eTicket;
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
