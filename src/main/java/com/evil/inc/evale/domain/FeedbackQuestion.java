package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "FEEDBACK_QUESTIONS")
public class FeedbackQuestion extends AbstractEntity {
    private String text;
    @Enumerated(EnumType.STRING)
    private FeedbackAnswer feedbackAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Feedback feedback;

    public FeedbackQuestion(String text, FeedbackAnswer feedbackAnswer) {
        this.text = text;
        this.feedbackAnswer = feedbackAnswer;
    }

    @Override
    public String toString() {
        return "FeedbackQuestion{" +
                "text='" + text + '\'' +
                ", feedbackAnswer=" + feedbackAnswer +
                ", feedback=" + feedback.getId() +
                '}';
    }
}
