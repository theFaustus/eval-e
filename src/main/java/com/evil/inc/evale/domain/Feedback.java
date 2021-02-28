package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "FEEDBACKS")
public class Feedback extends AbstractEntity{
    @OneToMany(mappedBy = "feedback", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeedbackQuestion> questions = new ArrayList<>();
    private boolean isAnonymous;
    private String comment;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Assessment assessment;

    public Feedback(boolean isAnonymous, String comment, User author) {
        this.isAnonymous = isAnonymous;
        this.comment = comment;
        this.author = author;
    }

    public void addQuestion(FeedbackQuestion question){
        questions.add(question);
        question.setFeedback(this);
    }

    public void removeQuestion(FeedbackQuestion question){
        questions.remove(question);
        question.setFeedback(null);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "questions=" + questions +
                ", isAnonymous=" + isAnonymous +
                ", comment='" + comment + '\'' +
                ", author=" + author.getUsername() +
                ", assessment=" + assessment.getId() +
                '}';
    }
}
