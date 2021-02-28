package com.evil.inc.evale.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity{
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private String email;

    private List<Assessment> assessments = new ArrayList<>();
}
