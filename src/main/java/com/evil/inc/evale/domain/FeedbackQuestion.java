package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data

@NoArgsConstructor
@Entity
@Table(name = "FEEDBACK_QUESTIONS")
public class FeedbackQuestion extends AbstractEntity {
    @Lob
    @Type(type = "org.hibernate.type.TextType")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackQuestion that = (FeedbackQuestion) o;
        return this.id != null && that.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "FeedbackQuestion{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", feedbackAnswer=" + feedbackAnswer +
                ", feedback=" + feedback.getId() +
                '}';
    }
}
