package com.multipart.service;

import com.multipart.dao.repository.UserRepository;
import com.multipart.exception.InvalidFileTypeException;
import com.multipart.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  // Yüklənən faylların saxlanılacağı qovluğun adı
  // "uploads/" – layihənin kök qovluğunda yaradılacaq
  private static final String UPLOAD_DIR = "uploads/";

  // Yükləməyə icazə verilən fayl tiplərinin siyahısı
  // MIME type formatında saxlanılır (content-type yoxlaması üçün)
  private static final List<String> ALLOWED_TYPES = List.of(

          // JPEG formatlı şəkillər üçün (ən çox istifadə olunan format)
          "image/jpeg",

          // JPG formatı üçün (praktikada jpeg ilə eynidir)
          "image/jpg",

          // PNG formatlı şəkillər üçün (şəffaflıq dəstəyi var)
          "image/png",

          // WEBP formatlı şəkillər üçün (daha az ölçü, yüksək keyfiyyət)
          "image/webp"
  );

        //❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

  // MultipartFile qəbul edib, faylı UUID ilə yadda saxlayan metod
  public String saveFileWithUuid(MultipartFile file) {
    try {
      // Əgər fayl boşdursa (ümumiyyətlə göndərilməyibsə)
      if (file.isEmpty()) {
        // Xəta atırıq
        throw new InvalidFileTypeException("File cannot be empty!");
      }

      // Faylın MIME tipini götürürük (məs: image/png, image/jpeg)
      String contentType = file.getContentType();

      // Əgər contentType null-dursa və ya icazə verilən tiplər siyahısında yoxdursa
      if (contentType == null || !ALLOWED_TYPES.contains(contentType)) {
        // Xəta atırıq – yalnız şəkillərə icazə var
        throw new InvalidFileTypeException(
                "Only image files are allowed (jpeg, jpg, png, webp)!"
        );
      }

      // Faylın orijinal adını götürürük (məs: photo.png)
      String originalFilename = file.getOriginalFilename();

      // Fayl uzantısı üçün boş dəyişən yaradırıq
      String extension = "";

      // Əgər orijinal ad null deyilsə və içində nöqtə varsa
      if (originalFilename != null && originalFilename.contains(".")) {
        // Faylın uzantısını götürürük (.png, .jpg və s.)
        extension = originalFilename.substring(
                originalFilename.lastIndexOf(".")
        );
      }

      // UUID yaradıb üzərinə fayl uzantısını əlavə edirik
      // Məs: 550e8400-e29b-41d4-a716-446655440000.png
      String uuidFileName = UUID.randomUUID() + extension;

      // Faylların saxlanacağı qovluğun yolunu yaradırıq
      Path uploadPath = Paths.get(UPLOAD_DIR);

      // Əgər bu qovluq mövcud deyilsə
      if (!Files.exists(uploadPath)) {
        // Qovluqları avtomatik yaradırıq
        Files.createDirectories(uploadPath);
      }

      // Tam fayl yolunu yaradırıq (qovluq + fayl adı)
      Path filePath = uploadPath.resolve(uuidFileName);

      // Faylı byte formatında diskə yazırıq
      Files.write(filePath, file.getBytes());

      // Yadda saxlanılan faylın adını geri qaytarırıq
      return uuidFileName;

    } catch (IOException e) {
      // IO xətası baş verərsə öz custom exception-umuzu atırıq
      throw new InvalidFileTypeException(
              "An error occurred while saving the file:"
      );
    }
  }
}

//❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️