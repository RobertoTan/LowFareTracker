
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
    "Messages",
    "BaggageInformationList"
})
public class TPAExtensions_ {

    @JsonProperty("Messages")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.Messages Messages;
    @JsonProperty("BaggageInformationList")
    private com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformationList BaggageInformationList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Messages
     */
    @JsonProperty("Messages")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.Messages getMessages() {
        return Messages;
    }

    /**
     * 
     * @param Messages
     *     The Messages
     */
    @JsonProperty("Messages")
    public void setMessages(com.sabre.api.sacs.domain.bargainfindermax_gen.Messages Messages) {
        this.Messages = Messages;
    }

    public TPAExtensions_ withMessages(com.sabre.api.sacs.domain.bargainfindermax_gen.Messages Messages) {
        this.Messages = Messages;
        return this;
    }

    /**
     * 
     * @return
     *     The BaggageInformationList
     */
    @JsonProperty("BaggageInformationList")
    public com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformationList getBaggageInformationList() {
        return BaggageInformationList;
    }

    /**
     * 
     * @param BaggageInformationList
     *     The BaggageInformationList
     */
    @JsonProperty("BaggageInformationList")
    public void setBaggageInformationList(com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformationList BaggageInformationList) {
        this.BaggageInformationList = BaggageInformationList;
    }

    public TPAExtensions_ withBaggageInformationList(com.sabre.api.sacs.domain.bargainfindermax_gen.BaggageInformationList BaggageInformationList) {
        this.BaggageInformationList = BaggageInformationList;
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

    public TPAExtensions_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
