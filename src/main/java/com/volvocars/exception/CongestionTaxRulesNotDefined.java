package com.volvocars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Congestion tax rules are not defined")
public class CongestionTaxRulesNotDefined extends Exception {
    static final long serialVersionUID = -3387516993334229948L;

    public CongestionTaxRulesNotDefined(String message) {
        super(message);
    }

}
