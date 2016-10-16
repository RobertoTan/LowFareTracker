
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
    "TicketType",
    "ValidInterline"
})
public class TicketingInfo {

    @JsonProperty("TicketType")
    private String TicketType;
    @JsonProperty("ValidInterline")
    private String ValidInterline;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The TicketType
     */
    @JsonProperty("TicketType")
    public String getTicketType() {
        return TicketType;
    }

    /**
     * 
     * @param TicketType
     *     The TicketType
     */
    @JsonProperty("TicketType")
    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }

    public TicketingInfo withTicketType(String TicketType) {
        this.TicketType = TicketType;
        return this;
    }

    /**
     * 
     * @return
     *     The ValidInterline
     */
    @JsonProperty("ValidInterline")
    public String getValidInterline() {
        return ValidInterline;
    }

    /**
     * 
     * @param ValidInterline
     *     The ValidInterline
     */
    @JsonProperty("ValidInterline")
    public void setValidInterline(String ValidInterline) {
        this.ValidInterline = ValidInterline;
    }

    public TicketingInfo withValidInterline(String ValidInterline) {
        this.ValidInterline = ValidInterline;
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

    public TicketingInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
