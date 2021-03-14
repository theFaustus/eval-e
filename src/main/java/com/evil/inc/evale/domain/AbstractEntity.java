package com.evil.inc.evale.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@Data
@MappedSuperclass
public class AbstractEntity {
    @Id
    @SequenceGenerator(name = "evale_sequence", sequenceName = "evale_sequence", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evale_sequence")
    protected long id;
}
