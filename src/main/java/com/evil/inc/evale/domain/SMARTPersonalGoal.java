package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

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
@Table(name = "SMART_PERSONAL_GOALS")
public class SMARTPersonalGoal extends AbstractEntity {
    //TODO provide field description
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String specificField;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String measurableField;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String achievableField;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String relevantField;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String timeBoundField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Assessment assessment;

    public SMARTPersonalGoal(String specificField, String measurableField, String achievableField,
                             String relevantField, String timeBoundField) {
        this.specificField = specificField;
        this.measurableField = measurableField;
        this.achievableField = achievableField;
        this.relevantField = relevantField;
        this.timeBoundField = timeBoundField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SMARTPersonalGoal that = (SMARTPersonalGoal) o;
        return that.id == this.id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "SMARTPersonalGoal{" +
                "id=" + id +
                ", specificField='" + specificField + '\'' +
                ", measurableField='" + measurableField + '\'' +
                ", achievableField='" + achievableField + '\'' +
                ", relevantField='" + relevantField + '\'' +
                ", timeBoundField='" + timeBoundField + '\'' +
                ", assessment=" + assessment.getId() +
                '}';
    }
}
