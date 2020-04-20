package com.projet.business.ctrl;

import com.projet.common.model.request.business.BusinessInfoRequest;
import com.projet.common.model.request.order.OrderInfoRequest;
import com.projet.common.model.response.BaseResponse;
import com.projet.feign.order.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *
 * @author cs12110 create at 2020-04-09 22:08
 * <p>
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/")
public class BusinessCtrl {

    @Resource
    private OrderFeignService orderFeignService;

    @RequestMapping("/create")
    public BaseResponse create(@RequestBody BusinessInfoRequest businessInfoRequest) {

        log.info("Function[create] body:{}", businessInfoRequest);
        businessInfoRequest.setCreator("3307");


        OrderInfoRequest orderInfoRequest = new OrderInfoRequest();
        orderInfoRequest.setCreateTime(new Date());
        orderInfoRequest.setCreator("3306");
        orderInfoRequest.setOrderId("O" + System.currentTimeMillis());
        orderInfoRequest.setPrice(137L);

        BaseResponse baseResponse = orderFeignService.create(orderInfoRequest);
        log.info("Function[create] order result post:{}", baseResponse);

        BaseResponse display = orderFeignService.display(orderInfoRequest);
        log.info("Function[create] order result get:{}", display);


        return BaseResponse.success(businessInfoRequest);
    }


}
