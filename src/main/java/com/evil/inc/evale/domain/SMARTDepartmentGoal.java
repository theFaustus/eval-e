package com.evil.inc.evale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@Table(name = "SMART_DEPARTMENT_GOALS")
public class SMARTDepartmentGoal extends AbstractEntity {
    //TODO provide field description
    @Lob
    private String specificField;
    @Lob
    private String measurableField;
    @Lob
    private String achievableField;
    @Lob
    private String relevantField;
    @Lob
    private String timeBoundField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Assessment assessment;

    public SMARTDepartmentGoal(String specificField, String measurableField, String achievableField,
                               String relevantField, String timeBoundField) {
        this.specificField = specificField;
        this.measurableField = measurableField;
        this.achievableField = achievableField;
        this.relevantField = relevantField;
        this.timeBoundField = timeBoundField;
    }

    @Override
    public String toString() {
        return "SMARTDepartmentGoal{" +
                "specificField='" + specificField + '\'' +
                ", measurableField='" + measurableField + '\'' +
                ", achievableField='" + achievableField + '\'' +
                ", relevantField='" + relevantField + '\'' +
                ", timeBoundField='" + timeBoundField + '\'' +
                ", assessment=" + assessment.getId() +
                '}';
    }
}
