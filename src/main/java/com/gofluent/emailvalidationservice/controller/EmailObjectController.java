package com.gofluent.emailvalidationservice.controller;

import com.gofluent.emailvalidationservice.service.EmailObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Map;

@Controller
@RequestMapping("/emailvalidation")
public class EmailObjectController {

    @Autowired
    EmailObjectService emailObjectService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam Map<String, String> xmlString) {
        System.out.println(xmlString.get("email"));
        return new ResponseEntity<>(emailObjectService.save(xmlString.get("email")).toString(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestParam Map<String, String> xmlString) {
        emailObjectService.update(xmlString.get("email"),xmlString.get("errorCode"),xmlString.get("errorMessage"));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
