package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "EVALUATION_FIELDS")
public class EvaluationField extends AbstractEntity{
    private String name;
    private Long value;
    private String description;

    private int fieldOrder;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private EvaluationGroup evaluationGroup;

    public EvaluationField(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //TODO equals and hashcode

    @Override
    public String toString() {
        return "EvaluationField{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                ", evaluationGroup=" + evaluationGroup.getId() +
                '}';
    }
}
