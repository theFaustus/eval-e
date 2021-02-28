package com.evil.inc.evale.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public enum JobPosition {
    JUNIOR, MEDIOR, SENIOR, ADMIN, HR
}
