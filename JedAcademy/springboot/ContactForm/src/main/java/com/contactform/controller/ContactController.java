package com.contactform.controller;

import com.contactform.dto.ContactRequestDto;
import com.contactform.dto.ContactResponseDto;
import com.contactform.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/formsend")
    public ResponseEntity<ContactResponseDto> sendContactMessage(@Valid @RequestBody ContactRequestDto requestDto) {
        var response = contactService.sendMessage(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContactResponseDto>> getAllMessages() {
        return ResponseEntity.ok(contactService.getAllMessages());
    }


}