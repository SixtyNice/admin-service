package com.accenture.tveratc.bank.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLOBAL_SETTING")
public class GlobalSetting {

    @Id
    @Column(name = "CODE", unique = true)
    private String code;

    @Column(name = "VALUE", nullable = false)
    private String value;

    public GlobalSetting(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public GlobalSetting() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
