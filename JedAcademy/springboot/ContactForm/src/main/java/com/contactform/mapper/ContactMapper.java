package com.contactform.mapper;

import com.contactform.dao.entity.ContactEntity;
import com.contactform.dto.ContactRequestDto;
import com.contactform.dto.ContactResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactEntity toEntity(ContactRequestDto requestDto) {
        ContactEntity contactMessage = new ContactEntity();
        contactMessage.setFullName(requestDto.getFullName());
        contactMessage.setEmail(requestDto.getEmail());
        contactMessage.setSubject(requestDto.getSubject());
        contactMessage.setMessage(requestDto.getMessage());
        return contactMessage;
    }

    public ContactResponseDto toResponseDto(ContactEntity entity) {
        ContactResponseDto responseDto = new ContactResponseDto();
        responseDto.setId(entity.getId());
        responseDto.setFullName(entity.getFullName());
        responseDto.setSentAt(entity.getCreatedAt());
        responseDto.setStatus("Mesajınız qəbul edildi");
        return responseDto;
    }
}