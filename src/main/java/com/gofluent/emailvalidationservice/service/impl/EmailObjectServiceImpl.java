package com.gofluent.emailvalidationservice.service.impl;

import com.gofluent.emailvalidationservice.domain.EmailObject;
import com.gofluent.emailvalidationservice.domain.EmailStatus;
import com.gofluent.emailvalidationservice.repository.EmailObjectRepository;
import com.gofluent.emailvalidationservice.service.EmailObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailObjectServiceImpl implements EmailObjectService {

    @Autowired
    EmailObjectRepository emailObjectRepository;

    @Override
    public EmailStatus save(String email) {
       EmailObject emailObject = emailObjectRepository.findByEmail(email);
       if(emailObject == null) {
           emailObjectRepository.save(new EmailObject(email));
           return EmailStatus.VALID;
       }
       return emailObject.getEmailStatus();
    }

    @Override
    public void update(String email, String errorCode, String errorMessage) {
        EmailObject emailObject = emailObjectRepository.findByEmail(email);
        emailObject.setErrorCode(errorCode);
        emailObject.setErrorMessage(errorMessage);
        emailObject.setEmailStatus(EmailStatus.INVALID);
        emailObjectRepository.save(emailObject);
    }

}
