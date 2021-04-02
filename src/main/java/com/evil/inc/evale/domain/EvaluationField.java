package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data

@NoArgsConstructor
@Entity
@Table(name = "EVALUATION_FIELDS")
public class EvaluationField extends AbstractEntity{
    @Column(length = 1000)
    private String name;
    private long value;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationField that = (EvaluationField) o;
        return this.id != null && that.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "EvaluationField{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", description='" + description + '\'' +
                ", comment='" + comment + '\'' +
                ", evaluationGroup=" + (evaluationGroup != null ? evaluationGroup.getId() : "n/a") +
                '}';
    }
}
