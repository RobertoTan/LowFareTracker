
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
    "Message"
})
public class Messages {

    @JsonProperty("Message")
    private List<com.sabre.api.sacs.domain.bargainfindermax_gen.Message> Message = new ArrayList<com.sabre.api.sacs.domain.bargainfindermax_gen.Message>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Message
     */
    @JsonProperty("Message")
    public List<com.sabre.api.sacs.domain.bargainfindermax_gen.Message> getMessage() {
        return Message;
    }

    /**
     * 
     * @param Message
     *     The Message
     */
    @JsonProperty("Message")
    public void setMessage(List<com.sabre.api.sacs.domain.bargainfindermax_gen.Message> Message) {
        this.Message = Message;
    }

    public Messages withMessage(List<com.sabre.api.sacs.domain.bargainfindermax_gen.Message> Message) {
        this.Message = Message;
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

    public Messages withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
