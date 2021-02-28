package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FeedbackQuestion extends AbstractEntity {
    private String text;
    private Answer answer;
}
