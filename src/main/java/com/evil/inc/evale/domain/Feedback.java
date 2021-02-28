package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Feedback extends AbstractEntity{
    private List<FeedbackQuestion> questions;
    private boolean isAnonymous;
    private String comment;

    private User author;

}
