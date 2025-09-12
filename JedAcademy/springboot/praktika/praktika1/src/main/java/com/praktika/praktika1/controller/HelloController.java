//package com.praktika.praktika1.controller;
//
//import com.praktika.praktika1.service.HelloService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/hello")
//public class HelloController {
//  public HelloService helloService;
//
//  public HelloController(HelloService helloService) {
//    this.helloService = helloService;
//  }
//
//  @GetMapping("/salamla")
//  public List<String> helloGonder() {
//    return helloService.helloGonder();
//  }
//
//  @PostMapping("/add-text")
//  public String addHelloText(@RequestParam("text") String text) {
//    return helloService.addSalamlaText(text);
//
//  }
//}
