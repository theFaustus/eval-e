package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "EVALUATION_FIELDS")
public class EvaluationField extends AbstractEntity{
    @Column(length = 1000)
    private String name;
    private Long value;
    @Lob
    private String description;

    private int fieldOrder;

    @Lob
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
                ", evaluationGroup=" + (evaluationGroup != null ? evaluationGroup.getId() : "n/a") +
                '}';
    }
}
