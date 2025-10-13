package com.redis.order.page.redisorder.dto;

import com.redis.order.page.redisorder.util.PaymentMethodEnum;
import com.redis.order.page.redisorder.util.StatusEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDto {
  String customerName;
  String orderDate;
  Double totalPrice;
  StatusEnum status;
  PaymentMethodEnum paymentMethod;
}
