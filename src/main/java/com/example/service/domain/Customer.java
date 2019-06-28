package com.example.service.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private long id;
    private String firstName;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
