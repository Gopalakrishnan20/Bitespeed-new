package com.bitespeed.identityreconciliation.api.controller;

import com.bitespeed.identityreconciliation.api.entity.Contact;
import com.bitespeed.identityreconciliation.api.model.IdentityRequest;
import com.bitespeed.identityreconciliation.api.model.IdentityResponse;
import com.bitespeed.identityreconciliation.api.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IdentityController {
	
	@Autowired
    private IdentityService identityService;
    /**
     * Endpoint to perform identity reconciliation based on the provided JSON payload.
     * The request body should contain either an email or phoneNumber for identification.
     *
     * @param request The JSON request containing email or phoneNumber for identification.
     * @return ResponseEntity with IdentityResponse containing the consolidated contact details.
     */
    @PostMapping("/identify")
    public ResponseEntity<IdentityResponse> identifyContact(@RequestBody IdentityRequest request) {
        IdentityResponse response = identityService.identifyContact(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/xyz")
    public List<Contact> all(){
        return identityService.all();
    }
}

