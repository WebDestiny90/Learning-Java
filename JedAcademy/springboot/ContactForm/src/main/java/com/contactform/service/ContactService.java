package com.contactform.service;

import com.contactform.dao.repository.ContactRepository;
import com.contactform.dto.ContactRequestDto;
import com.contactform.dto.ContactResponseDto;
import com.contactform.helper.ValidationUtil;
import com.contactform.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactResponseDto sendMessage(ContactRequestDto requestDto) {
        ValidationUtil.validateUser(requestDto);
        var messageEntity = contactRepository.save(contactMapper.toEntity(requestDto));
        return contactMapper.toResponseDto(messageEntity);
    }

    public List<ContactResponseDto> getAllMessages() {
        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toResponseDto)
                .toList();
    }
}