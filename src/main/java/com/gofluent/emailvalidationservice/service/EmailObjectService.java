package com.gofluent.emailvalidationservice.service;

import com.gofluent.emailvalidationservice.domain.EmailStatus;

public interface EmailObjectService {
    EmailStatus save(String email);
    void update(String email, String errorCode, String errorMessage);
}
