package com.multipart.controller;

import com.multipart.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  //❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

  // HTTP POST sorğularını /upload endpoint-inə yönləndirir
  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)  { // Request-dən "file" adlı parametri götürür (multipart/form-data)

    // Göndərilən faylı service qatına ötürürük və
    // UUID ilə yadda saxlanılmış fayl adını alırıq
    String savedFileName = userService.saveFileWithUuid(file);

    // Əgər geri qayıdan fayl adı boşdursa
    // HTTP 204 No Content cavabı qaytarılır
    return savedFileName.isEmpty() ? ResponseEntity.noContent().build()
            // Əks halda HTTP 200 OK və uğur mesajı qaytarılır
            : ResponseEntity.ok("File uploaded successfully: " + savedFileName);
  }

}
//❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️