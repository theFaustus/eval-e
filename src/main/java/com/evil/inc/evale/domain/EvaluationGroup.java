package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "EVALUATION_GROUPS")
public class EvaluationGroup extends AbstractEntity{
    private String title;
    private String description;

    private int groupOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Assessment assessment;

    @OneToMany(mappedBy = "evaluationGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluationField> evaluationFields = new ArrayList<>();

    public EvaluationGroup(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addEvaluationField(EvaluationField field){
        evaluationFields.add(field);
        field.setEvaluationGroup(this);
    }

    public void removeEvaluationField(EvaluationField field){
        evaluationFields.remove(field);
        field.setEvaluationGroup(null);
    }

    @Override
    public String toString() {
        return "EvaluationGroup{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assessment=" + assessment.getId() +
                ", evaluationFields=" + evaluationFields +
                '}';
    }
}
