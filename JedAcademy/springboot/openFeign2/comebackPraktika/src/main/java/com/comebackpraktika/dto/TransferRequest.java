package com.comebackpraktika.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransferRequest {
   Long senderId;
   Long receiverId;
   Double amount;
}