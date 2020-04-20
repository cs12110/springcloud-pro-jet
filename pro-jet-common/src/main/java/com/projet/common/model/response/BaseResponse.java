package com.projet.common.model.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.projet.common.enums.CommonCodeEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * @author cs12110 create at 2020-04-09 22:40
 * <p>
 * @since 1.0.0
 */
@Data
public class BaseResponse<T> {

    private int code;

    private String message;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date time;

    private T data;

    private List<T> list;


    public static <T> BaseResponse success(T data) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(CommonCodeEnum.SUCCESS.getCode());
        baseResponse.setData(data);
        baseResponse.setTime(new Date());

        return baseResponse;
    }


    public static <T> BaseResponse failure(String message) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(CommonCodeEnum.FAILURE.getCode());
        baseResponse.setMessage(message);
        baseResponse.setTime(new Date());
        return baseResponse;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
