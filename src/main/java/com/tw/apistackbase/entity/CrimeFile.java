package com.tw.apistackbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CrimeFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String objectiveDescription;
    private String subjectiveDescription;

    public CrimeFile(String objectiveDescription, String subjectiveDescription) {
        this.objectiveDescription = objectiveDescription;
        this.subjectiveDescription = subjectiveDescription;
    }

    public CrimeFile() {
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }

    public Long getId() {
        return id;
    }
}
