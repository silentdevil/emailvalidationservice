package com.gofluent.emailvalidationservice.repository;

import com.gofluent.emailvalidationservice.domain.EmailObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailObjectRepository extends MongoRepository<EmailObject, String> {
    EmailObject findByEmail(String email);
}
