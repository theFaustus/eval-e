package com.evil.inc.evale.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private JobPosition jobPosition;

    @OneToMany(mappedBy = "assessedUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assessment> assessments = new ArrayList<>();

    public User(String firstName, String lastName, String username, String password, String email,
                JobPosition jobPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.jobPosition = jobPosition;
    }

    public void addAssessment(Assessment assessment){
        assessments.add(assessment);
        assessment.setAssessedUser(this);
    }

}
