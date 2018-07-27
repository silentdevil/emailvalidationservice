package com.gofluent.emailvalidationservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class EmailObject {

    @Id
    private String id;
    private String email;
    private String errorCode;
    private String errorMessage;
    private EmailStatus emailStatus;


    public EmailObject() {}

    public EmailObject(String id, String email, String errorCode, String errorMessage, EmailStatus emailStatus) {
        this.id = id;
        this.email = email;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.emailStatus = emailStatus;
    }

    public EmailObject(String email) {
        this.email = email;
        this.emailStatus = EmailStatus.VALID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public EmailStatus getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(EmailStatus emailStatus) {
        this.emailStatus = emailStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailObject that = (EmailObject) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }
}

