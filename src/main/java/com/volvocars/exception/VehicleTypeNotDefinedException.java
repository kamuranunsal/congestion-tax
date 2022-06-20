package com.volvocars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find entity type.")
public class VehicleTypeNotDefinedException extends Exception {
    static final long serialVersionUID = -3387516993334229948L;

    public VehicleTypeNotDefinedException(String message) {
        super(message);
    }

}
