package com.tw.apistackbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String caseName;
    private Long happenTime;

    public Case(String caseName, Long happenTime) {
        this.caseName = caseName;
        this.happenTime = happenTime;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Long getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Long happenTime) {
        this.happenTime = happenTime;
    }

    public Long getId() {
        return id;
    }
}
