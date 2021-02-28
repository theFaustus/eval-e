package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EvaluationField extends AbstractEntity{
    private String name;
    private Long value;
    private String comment;
}
