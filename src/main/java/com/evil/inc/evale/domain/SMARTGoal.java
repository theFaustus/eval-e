package com.evil.inc.evale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class SMARTGoal extends AbstractEntity {
    private String specificField;
    private String measurableField;
    private String achievableField;
    private String relevantField;
    private String timeBoundField;
}
