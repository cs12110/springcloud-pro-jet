package com.projet.gateway.service;

import com.alibaba.fastjson.JSON;
import com.projet.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Collections;

/**
 * @author cs12110 create at 2020/4/10 11:12
 * @version 1.0.0
 */
@Slf4j
@Service
public class DynamicRouteService {

    @Resource
    private RouteDefinitionWriter routeDefinitionWriter;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 刷新路由
     * <p>
     * FilterDefinition参数参考: {@link  org.springframework.cloud.gateway.filter.factory.StripPrefixGatewayFilterFactory}
     * <p>
     * PredicateDefinition参数参考: {@link org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory}
     */
    public void refreshRoute() {
        log.info("Function[refreshRoute] start");
        long start = System.currentTimeMillis();
        try {
            // 定义router,可以自定义从redis,mysql加载
            RouteDefinition routeDefinition = createOrderRoute();

            log.info("Function[refreshRoute] add route:{}", JSON.toJSONString(routeDefinition, true));

            // 这个是什么玩意?
            routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();

            // 发送更新环境问题
            RefreshRoutesEvent refreshRoutesEvent = new RefreshRoutesEvent(this);
            applicationEventPublisher.publishEvent(refreshRoutesEvent);

        } catch (Exception e) {
            log.error("Function[refreshRoute]", e);
            throw new ServiceException("Can't refresh route");
        }

        long end = System.currentTimeMillis();

        log.info("Function[refreshRoute] done,spend:{} ms", (end - start));
    }


    /**
     * 创建pro-jet-order服务路由
     *
     * @return RouteDefinition
     */
    private RouteDefinition createOrderRoute() {
        RouteDefinition routeDefinition = new RouteDefinition();
        try {
            // 定义filter
            FilterDefinition filterDefinition = new FilterDefinition();
            filterDefinition.setName("StripPrefix");
            filterDefinition.addArg("parts", "1");

            // 定义predicate
            PredicateDefinition predicateDefinition = new PredicateDefinition();
            predicateDefinition.setName("Path");
            predicateDefinition.addArg("pattern", "/order/**");

            // 设置route
            routeDefinition.setId("por-jet-order-service");
            routeDefinition.setUri(new URI("lb://PRO-JET-ORDER"));

            routeDefinition.setFilters(Collections.singletonList(filterDefinition));
            routeDefinition.setPredicates(Collections.singletonList(predicateDefinition));
        } catch (Exception e) {
            log.error("Function[createOrderRoute]", e);
            throw new ServiceException("Can't create order route");
        }
        return routeDefinition;
    }

}
