package com.evil.inc.evale.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Grade extends AbstractEntity {
    private String title;
}
