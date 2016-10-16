
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
    "Type",
    "ShortText",
    "Code",
    "MessageClass",
    "content"
})
public class Warning {

    @JsonProperty("Type")
    private String Type;
    @JsonProperty("ShortText")
    private String ShortText;
    @JsonProperty("Code")
    private String Code;
    @JsonProperty("MessageClass")
    private String MessageClass;
    @JsonProperty("content")
    private String content;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Warning withType(String Type) {
        this.Type = Type;
        return this;
    }

    /**
     * 
     * @return
     *     The ShortText
     */
    @JsonProperty("ShortText")
    public String getShortText() {
        return ShortText;
    }

    /**
     * 
     * @param ShortText
     *     The ShortText
     */
    @JsonProperty("ShortText")
    public void setShortText(String ShortText) {
        this.ShortText = ShortText;
    }

    public Warning withShortText(String ShortText) {
        this.ShortText = ShortText;
        return this;
    }

    /**
     * 
     * @return
     *     The Code
     */
    @JsonProperty("Code")
    public String getCode() {
        return Code;
    }

    /**
     * 
     * @param Code
     *     The Code
     */
    @JsonProperty("Code")
    public void setCode(String Code) {
        this.Code = Code;
    }

    public Warning withCode(String Code) {
        this.Code = Code;
        return this;
    }

    /**
     * 
     * @return
     *     The MessageClass
     */
    @JsonProperty("MessageClass")
    public String getMessageClass() {
        return MessageClass;
    }

    /**
     * 
     * @param MessageClass
     *     The MessageClass
     */
    @JsonProperty("MessageClass")
    public void setMessageClass(String MessageClass) {
        this.MessageClass = MessageClass;
    }

    public Warning withMessageClass(String MessageClass) {
        this.MessageClass = MessageClass;
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

    public Warning withContent(String content) {
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

    public Warning withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
