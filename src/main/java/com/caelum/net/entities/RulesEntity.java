package com.caelum.net.entities;

import jakarta.persistence.Entity;

@Entity
public class RulesEntity {
    private Long id;
    private double ruleNumber;
    private String ruleContent;
}
