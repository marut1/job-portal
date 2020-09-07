package com.tropogo.jobportal.exception;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The type Response message.
 * <p>
 *@JsonIgnoreProperties is used to either suppress serialization of properties (during
 *serialization), or ignore processing of JSON properties read (during deserialization). </p>
 *<p>
 *@ApiModelProperty Annotation adds and manipulates data of a models property.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMessage {
    private String message;

    /**
     * Instantiates a new Response message.
     */
    public ResponseMessage() {
        //Default Constructor
    }

    /**
     * Instantiates a new Response message.
     *
     * @param message the message
     */
    public ResponseMessage(String message) {
        this.message = message;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
