
/*
 * <p> Source File Name: SubmitOrder.java </p>
 * <p> Modify Date: Sat Mar 13 17:05:24 CST 2021 </p>
 */

package com.neux.garden.ec.runtime.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;

@Validated
public class SubmitOrderResult {

    
    @JsonProperty("IsRedirect")
    @Valid 
    private Boolean isRedirect = false;
            
    @JsonProperty("RedirectForm")
    @Valid 
    private String redirectForm = null;

    public Boolean getRedirect() {
        return isRedirect;
    }

    public void setRedirect(Boolean redirect) {
        isRedirect = redirect;
    }

    public String getRedirectForm() {
        return redirectForm;
    }

    public void setRedirectForm(String redirectForm) {
        this.redirectForm = redirectForm;
    }
}
