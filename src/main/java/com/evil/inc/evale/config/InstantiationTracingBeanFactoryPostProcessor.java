package com.evil.inc.evale.config;

import com.evil.inc.evale.service.mapper.AssessmentMapperImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Slf4j
public class InstantiationTracingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(
            final ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        log.debug("InstantiationTracingBeanFactoryPostProcessor::postProcessBeanFactory");
//        log.debug("InstantiationTracingBeanFactoryPostProcessor::postProcessBeanFactory {}", configurableListableBeanFactory.getBeanDefinition("fakeAssessmentServiceImpl"));
//        for (final String beanDefinitionName : configurableListableBeanFactory.getBeanDefinitionNames()) {
//            log.info("Found bean definitions : " + beanDefinitionName);
//        }

    }
}