package com.projet.feign.order;

import com.projet.common.conf.ServiceRouteConst;
import com.projet.common.model.request.order.OrderInfoRequest;
import com.projet.common.model.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *
 * @author cs12110 create at 2020-04-09 22:21
 * <p>
 * @since 1.0.0
 */
@FeignClient(ServiceRouteConst.ORDER_SERVICE_ID)
public interface OrderFeignService {

    /**
     * 创建订单
     *
     * @param orderInfoRequest 订单信息
     * @return BaseResponse
     */
    @RequestMapping(
            value = ServiceRouteConst.ORDER_API_PREFIX + "/create",
            method = RequestMethod.POST
    )
    BaseResponse create(@RequestBody OrderInfoRequest orderInfoRequest);
}
