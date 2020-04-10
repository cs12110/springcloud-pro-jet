package com.projet.gateway.ctrl;

import com.projet.common.model.response.BaseResponse;
import com.projet.gateway.service.DynamicRouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author huanghuapeng create at 2020/4/10 15:42
 * @version 1.0.0
 */
@Controller
@RequestMapping("/dynamic/")
public class DynamicRouteCtrl {

    @Resource
    private DynamicRouteService dynamicRouteService;

    @RequestMapping("/refresh")
    @ResponseBody
    public BaseResponse refresh() {
        dynamicRouteService.refreshRoute();
        return BaseResponse.success(Boolean.TRUE);
    }
}
