package com.projet.order.ctrl;

import com.projet.common.model.request.business.BusinessInfoRequest;
import com.projet.common.model.request.order.OrderInfoRequest;
import com.projet.common.model.response.BaseResponse;
import com.projet.feign.business.BusinessFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *
 * @author cs12110 create at 2020-04-09 22:15
 * <p>
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/")
public class OrderCtrl {

    @Resource
    private BusinessFeignService businessFeignService;

    @RequestMapping("/create")
    public Object create(@RequestBody OrderInfoRequest orderInfoRequest) {

        log.info("Function[create] request info:{}", orderInfoRequest);

        orderInfoRequest.setPrice(orderInfoRequest.getPrice() - 100);
        return BaseResponse.success(orderInfoRequest);
    }

    @RequestMapping("/call/business")
    public BaseResponse callBusinessService() {
        BusinessInfoRequest businessInfoRequest = new BusinessInfoRequest();
        businessInfoRequest.setBusinessId("B" + System.currentTimeMillis());
        businessInfoRequest.setCreateTime(new Date());
        businessInfoRequest.setCreator("cs12110");

        return businessFeignService.create(businessInfoRequest);
    }
}
