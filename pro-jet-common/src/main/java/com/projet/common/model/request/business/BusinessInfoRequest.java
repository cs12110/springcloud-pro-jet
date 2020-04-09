package com.projet.common.model.request.business;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 *
 * @author cs12110 create at 2020-04-09 22:51
 * <p>
 * @since 1.0.0
 */
@Data
public class BusinessInfoRequest {

    private String businessId;

    private Date createTime;

    private String creator;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
