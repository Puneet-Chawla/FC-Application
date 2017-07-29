package com.example.student.fc;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Student on 6/23/2017.
 */

public class AddCompany {
public String company_name, job_location,apply_url,experience,company_website,last_date,qualification,salary,job_role;

    public AddCompany() {
    }

    public AddCompany(String apply_url, String company_name, String company_website, String experience, String job_location, String job_role, String last_date, String qualification, String salary) {
        this.apply_url = apply_url;
        this.company_name = company_name;
        this.company_website = company_website;
        this.experience = experience;
        this.job_location = job_location;
        this.job_role = job_role;
        this.last_date = last_date;
        this.qualification = qualification;
        this.salary = salary;
    }

    public String getApply_url() {
        return apply_url;
    }

    public void setApply_url(String apply_url) {
        this.apply_url = apply_url;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public String getLast_date() {
        return last_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

