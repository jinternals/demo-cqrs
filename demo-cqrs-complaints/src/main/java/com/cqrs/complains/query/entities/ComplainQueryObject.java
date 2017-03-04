package com.cqrs.complains.query.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mradul on 03/03/17.
 */
@Entity
public class ComplainQueryObject {

    @Id
    private String complaintId;
    private String company;
    private String description;


    public ComplainQueryObject() {
    }

    public ComplainQueryObject(String complaintId, String company, String description) {
        this.complaintId = complaintId;
        this.company = company;
        this.description = description;
    }

    public String getComplaintId() {
        return complaintId;
    }


    public String getCompany() {
        return company;
    }


    public String getDescription() {
        return description;
    }


}
