package com.evil.inc.evale.service;

import com.evil.inc.evale.config.annotations.qualifier.AssessmentServiceType;
import com.evil.inc.evale.domain.Assessment;
import com.evil.inc.evale.domain.exception.AssessmentNotFoundException;
import com.evil.inc.evale.service.dto.AssessmentSummaryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.List;

import static com.evil.inc.evale.config.annotations.qualifier.AssessmentServiceType.Type.FAKE;

@Slf4j
@AssessmentServiceType(type = FAKE)
public class FakeAssessmentServiceImpl implements AssessmentService, InitializingBean, DisposableBean {

    private final TransactionTemplate transactionTemplate;
    private PlatformTransactionManager txManager;

    public FakeAssessmentServiceImpl(ApplicationArguments applicationArguments,
                                     PlatformTransactionManager txManager)  {
        log.debug("FakeAssessmentServiceImpl::FakeAssessmentServiceImpl");
        log.debug("ApplicationArguments::{}", applicationArguments.getNonOptionArgs());
        this.txManager = txManager;
        this.transactionTemplate = new TransactionTemplate(txManager);
    }

    @Override
    public void create(final Assessment assessment) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(final TransactionStatus status) {
                log.debug("FakeAssessmentServiceImpl::doInTransactionWithoutResult");
            }
        });
    }

    @Override
    public Assessment getById(final Long id) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // explicitly setting the transaction name is something that can be done only programmatically
        def.setName("SomeTxName");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = txManager.getTransaction(def);
        try {
            // put your business logic here
        }
        catch (AssessmentNotFoundException ex) {
            txManager.rollback(status);
            throw ex;
        }
        txManager.commit(status);
        return null;
    }

    @Override
    public List<AssessmentSummaryDto> getAll() {
        return null;
    }

    @PostConstruct
    public void postConstruct(){
        log.debug("FakeAssessmentServiceImpl::postConstruct");
    }

    @Override
    public void afterPropertiesSet(){
        log.debug("FakeAssessmentServiceImpl::afterPropertiesSet");
    }

    private void initMethod() {
        log.debug("FakeAssessmentServiceImpl::initMethod");
    }

    @PreDestroy
    public void preDestroy(){
        log.debug("FakeAssessmentServiceImpl::preDestroy");
    }

    @Override
    public void destroy() throws Exception {
        log.debug("FakeAssessmentServiceImpl::destroy");
    }

    private void destroyMethod() {
        log.debug("FakeAssessmentServiceImpl::destroyMethod");
    }

}
