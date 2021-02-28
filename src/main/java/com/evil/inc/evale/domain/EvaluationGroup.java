package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class EvaluationGroup extends AbstractEntity{
    private String title;
    private String description;

    private List<EvaluationField> evaluationFields = new ArrayList<>();
}
