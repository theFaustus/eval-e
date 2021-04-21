package com.evil.inc.evale.config;

import com.evil.inc.evale.service.mapper.AssessmentMapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class InstantiationTracingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(
            final ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        for (final String beanDefinitionName : configurableListableBeanFactory.getBeanDefinitionNames()) {
            System.out.println("Found bean definitions : " + beanDefinitionName);
        }

    }
}