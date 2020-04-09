package com.projet.feign.business;

import com.projet.common.conf.ServiceRouteConst;
import com.projet.common.model.request.business.BusinessInfoRequest;
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
@FeignClient(ServiceRouteConst.BUSINESS_SERVICE_ID)
public interface BusinessFeignService {
    /**
     * create
     *
     * @param businessInfoRequest request
     * @return Object
     */
    @RequestMapping(
            value = ServiceRouteConst.BUSINESS_API_PREFIX + "/create",
            method = RequestMethod.POST
    )
    BaseResponse create(@RequestBody BusinessInfoRequest businessInfoRequest);
}
