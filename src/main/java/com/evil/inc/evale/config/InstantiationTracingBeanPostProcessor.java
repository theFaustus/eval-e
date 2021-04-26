package com.evil.inc.evale.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    // simply return the instantiated bean as-is
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if(beanName.equals("fakeAssessmentServiceImpl")){
            log.debug("InstantiationTracingBeanPostProcessor::postProcessBeforeInitialization");
//            log.debug("InstantiationTracingBeanPostProcessor::postProcessBeforeInitialization {}, {}", bean, beanName);
        }
        return bean; // we could potentially return any object reference here...
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {

        if(beanName.equals("fakeAssessmentServiceImpl")){
            log.debug("InstantiationTracingBeanPostProcessor::postProcessAfterInitialization");
//            log.debug("InstantiationTracingBeanPostProcessor::postProcessAfterInitialization {}, {}", bean, beanName);
        }
//        log.info("Bean '" + beanName + "' created. ");
        return bean;
    }
}