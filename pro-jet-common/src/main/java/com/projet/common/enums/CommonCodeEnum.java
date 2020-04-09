package com.projet.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 *
 * @author cs12110 create at 2020-04-09 22:41
 * <p>
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum CommonCodeEnum {

    /**
     * 成功:1
     */
    SUCCESS(1, "成功"),
    /**
     * 失败:0
     */
    FAILURE(0, "失败");

    private final int code;
    private final String desc;
}
