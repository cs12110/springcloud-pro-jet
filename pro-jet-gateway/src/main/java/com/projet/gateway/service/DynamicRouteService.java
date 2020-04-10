package com.projet.gateway.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cs12110 create at 2020/4/10 11:12
 * @version 1.0.0
 */
@Slf4j
@Service
public class DynamicRouteService {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    public void refreshRoute() {


    }

}
