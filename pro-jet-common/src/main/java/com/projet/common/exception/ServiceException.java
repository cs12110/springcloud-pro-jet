package com.projet.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author huanghuapeng create at 2020/4/10 18:59
 * @version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

}
