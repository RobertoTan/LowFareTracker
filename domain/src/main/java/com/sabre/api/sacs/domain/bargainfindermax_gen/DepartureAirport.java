
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
    "LocationCode",
    "TerminalID",
    "content"
})
public class DepartureAirport {

    @JsonProperty("LocationCode")
    private String LocationCode;
    @JsonProperty("TerminalID")
    private String TerminalID;
    @JsonProperty("content")
    private String content;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The LocationCode
     */
    @JsonProperty("LocationCode")
    public String getLocationCode() {
        return LocationCode;
    }

    /**
     * 
     * @param LocationCode
     *     The LocationCode
     */
    @JsonProperty("LocationCode")
    public void setLocationCode(String LocationCode) {
        this.LocationCode = LocationCode;
    }

    public DepartureAirport withLocationCode(String LocationCode) {
        this.LocationCode = LocationCode;
        return this;
    }

    /**
     * 
     * @return
     *     The TerminalID
     */
    @JsonProperty("TerminalID")
    public String getTerminalID() {
        return TerminalID;
    }

    /**
     * 
     * @param TerminalID
     *     The TerminalID
     */
    @JsonProperty("TerminalID")
    public void setTerminalID(String TerminalID) {
        this.TerminalID = TerminalID;
    }

    public DepartureAirport withTerminalID(String TerminalID) {
        this.TerminalID = TerminalID;
        return this;
    }

    /**
     * 
     * @return
     *     The content
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    public DepartureAirport withContent(String content) {
        this.content = content;
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

    public DepartureAirport withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
