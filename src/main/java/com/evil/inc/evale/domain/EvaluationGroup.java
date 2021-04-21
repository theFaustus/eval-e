package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data

@NoArgsConstructor
@Entity
@Table(name = "EVALUATION_GROUPS")
public class EvaluationGroup extends AbstractEntity{
    @Column(length = 1000)
    private String title;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationGroup that = (EvaluationGroup) o;
        return this.id != null && that.id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "EvaluationGroup{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assessment=" + (assessment != null ? assessment.getId() : "n/a") +
                ", evaluationFields=" + evaluationFields +
                '}';
    }


}
