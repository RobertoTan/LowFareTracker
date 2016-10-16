
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
    "AirlineCode",
    "Type",
    "FailCode",
    "Info"
})
public class Message {

    @JsonProperty("AirlineCode")
    private String AirlineCode;
    @JsonProperty("Type")
    private String Type;
    @JsonProperty("FailCode")
    private Integer FailCode;
    @JsonProperty("Info")
    private String Info;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The AirlineCode
     */
    @JsonProperty("AirlineCode")
    public String getAirlineCode() {
        return AirlineCode;
    }

    /**
     * 
     * @param AirlineCode
     *     The AirlineCode
     */
    @JsonProperty("AirlineCode")
    public void setAirlineCode(String AirlineCode) {
        this.AirlineCode = AirlineCode;
    }

    public Message withAirlineCode(String AirlineCode) {
        this.AirlineCode = AirlineCode;
        return this;
    }

    /**
     * 
     * @return
     *     The Type
     */
    @JsonProperty("Type")
    public String getType() {
        return Type;
    }

    /**
     * 
     * @param Type
     *     The Type
     */
    @JsonProperty("Type")
    public void setType(String Type) {
        this.Type = Type;
    }

    public Message withType(String Type) {
        this.Type = Type;
        return this;
    }

    /**
     * 
     * @return
     *     The FailCode
     */
    @JsonProperty("FailCode")
    public Integer getFailCode() {
        return FailCode;
    }

    /**
     * 
     * @param FailCode
     *     The FailCode
     */
    @JsonProperty("FailCode")
    public void setFailCode(Integer FailCode) {
        this.FailCode = FailCode;
    }

    public Message withFailCode(Integer FailCode) {
        this.FailCode = FailCode;
        return this;
    }

    /**
     * 
     * @return
     *     The Info
     */
    @JsonProperty("Info")
    public String getInfo() {
        return Info;
    }

    /**
     * 
     * @param Info
     *     The Info
     */
    @JsonProperty("Info")
    public void setInfo(String Info) {
        this.Info = Info;
    }

    public Message withInfo(String Info) {
        this.Info = Info;
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

    public Message withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
