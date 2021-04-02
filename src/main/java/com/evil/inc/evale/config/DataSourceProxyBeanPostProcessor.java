//package com.evil.inc.evale.config;
//
//import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;
//import net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel;
//import net.ttddyy.dsproxy.listener.logging.SystemOutQueryLoggingListener;
//import net.ttddyy.dsproxy.support.ProxyDataSource;
//import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
//import org.aopalliance.intercept.MethodInterceptor;
//import org.aopalliance.intercept.MethodInvocation;
//import org.hibernate.engine.jdbc.internal.FormatStyle;
//import org.hibernate.engine.jdbc.internal.Formatter;
//import org.springframework.aop.framework.ProxyFactory;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ReflectionUtils;
//
//import javax.sql.DataSource;
//import java.lang.reflect.Method;
//import java.util.concurrent.TimeUnit;
//
//@Component
//class DatasourceProxyBeanPostProcessor implements BeanPostProcessor {
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) {
//        if (bean instanceof DataSource && !(bean instanceof ProxyDataSource)) {
//            // Instead of directly returning a less specific datasource bean
//            // (e.g.: HikariDataSource -> DataSource), return a proxy object.
//            // See following links for why:
//            //   https://stackoverflow.com/questions/44237787/how-to-use-user-defined-database-proxy-in-datajpatest
//            //   https://gitter.im/spring-projects/spring-boot?at=5983602d2723db8d5e70a904
//            //   http://blog.arnoldgalovics.com/2017/06/26/configuring-a-datasource-proxy-in-spring-boot/
//            final ProxyFactory factory = new ProxyFactory(bean);
//            factory.setProxyTargetClass(true);
//            factory.addAdvice(new ProxyDataSourceInterceptor((DataSource) bean));
//            return factory.getProxy();
//        }
//        return bean;
//    }
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) {
//        return bean;
//    }
//
//    private static class ProxyDataSourceInterceptor implements MethodInterceptor {
//        private final DataSource dataSource;
//
//        public ProxyDataSourceInterceptor(final DataSource dataSource) {
//            this.dataSource = ProxyDataSourceBuilder
//                    .create(dataSource)
////                    .multiline()
//                    .countQuery()
////                    .traceMethods()
//                    .logQueryBySlf4j()
//                    .logSlowQueryBySlf4j(1, TimeUnit.MINUTES)
//                    .proxyResultSet()
//                    .name("DATASOURCE-PROXY")
//                    .build();
//        }
//
//        @Override
//        public Object invoke(final MethodInvocation invocation) throws Throwable {
//            final Method proxyMethod = ReflectionUtils.findMethod(this.dataSource.getClass(),
//                                                                  invocation.getMethod().getName());
//            if (proxyMethod != null) {
//                return proxyMethod.invoke(this.dataSource, invocation.getArguments());
//            }
//            return invocation.proceed();
//        }
//    }
//}
