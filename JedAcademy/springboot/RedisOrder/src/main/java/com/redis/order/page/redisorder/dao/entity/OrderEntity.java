package com.redis.order.page.redisorder.dao.entity;

import com.redis.order.page.redisorder.util.PaymentMethodEnum;
import com.redis.order.page.redisorder.util.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String customerName;
  String orderDate;
  Double totalPrice;
  @Enumerated(EnumType.STRING)
  StatusEnum status;
  @Enumerated(EnumType.STRING)
  PaymentMethodEnum paymentMethod;
}
