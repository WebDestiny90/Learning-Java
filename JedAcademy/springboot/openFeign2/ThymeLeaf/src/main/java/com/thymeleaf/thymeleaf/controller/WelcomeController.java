package com.thymeleaf.thymeleaf.controller;

import com.thymeleaf.thymeleaf.dao.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WelcomeController {
  private final CustomerRepository customerRepository;
  @GetMapping
  public String welcome(Model model) {
    var customer = customerRepository.findAll();
    model.addAttribute("customers", customer);


//    if (customer != null) {
//      model.addAttribute("message", "Greeting" + " - " + customer.getFirstName());
//    }else {
//      throw new RuntimeException("Customer not found by id: " + id);
//    }
//    var orders = List.of("Phone", "Notebook", "PlayStation");
//    model.addAttribute("orders", orders);
//    boolean isAdmin = (id == 1);
//    model.addAttribute("isAdmin", isAdmin);
//    String role = (id == 1) ? "ADMIN" : "USER";
//    model.addAttribute("role", role);

    return "table";
  }
}
