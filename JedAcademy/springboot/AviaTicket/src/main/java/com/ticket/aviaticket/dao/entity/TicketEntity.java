package com.ticket.aviaticket.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tickets")
public class TicketEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String ticketId;
  String title;
  Integer count;
  Double price;

  @ManyToMany(mappedBy = "tickets")
  List<CustomerEntity> customers;
}
