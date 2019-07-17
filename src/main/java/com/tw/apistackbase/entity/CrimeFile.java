package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class CrimeFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String objectiveDescription;
    private String subjectiveDescription;

    @OneToOne(cascade = CascadeType.ALL)
    private Case theCase;

    public CrimeFile(String objectiveDescription, String subjectiveDescription) {
        this.objectiveDescription = objectiveDescription;
        this.subjectiveDescription = subjectiveDescription;
    }

    public CrimeFile() {
    }

    public CrimeFile(String objectiveDescription, String subjectiveDescription, Case theCase) {
        this.objectiveDescription = objectiveDescription;
        this.subjectiveDescription = subjectiveDescription;
        this.theCase = theCase;
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

    public Case getCase() {
        return theCase;
    }

    public void setCase(Case theCase) {
        this.theCase = theCase;
    }


}
