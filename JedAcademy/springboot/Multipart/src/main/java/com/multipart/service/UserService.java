package com.multipart.service;

import com.multipart.dao.entity.UserEntity;
import com.multipart.dao.repository.UserRepository;
import com.multipart.dto.UserRequestDto;
import com.multipart.dto.UserResponseDto;
import com.multipart.exception.InvalidFileTypeException;
import com.multipart.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
  private static final String UPLOAD_DIR = "uploads/";

  // Yükləməyə icazə verilən fayl tiplərinin siyahısı
  private static final List<String> ALLOWED_TYPES = List.of(
          "image/jpeg",
          "image/jpg",
          "image/png",
          "image/webp"
  );

  //❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

  // User + şəkli birlikdə save edən metod  // YENİ
  public UserResponseDto saveUserWithImage(UserRequestDto requestDto,
                                           MultipartFile file) {

    // Request DTO → Entity çevrilir
    UserEntity user = userMapper.requestDtoToEntity(requestDto); // YENİ

    // Fayl diskə yazılır
    String imageName = saveFileWithUuid(file);

    // Fayl adı user entity-yə set olunur
    user.setImageName(imageName); // YENİ

    // User DB-yə save olunur
    UserEntity savedUser = userRepository.save(user); // YENİ

    // Entity → Response DTO çevrilir və frontend-ə qaytarılır
    return userMapper.entityToDto(savedUser); // YENİ
  }

  //❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

  // MultipartFile qəbul edib, faylı UUID ilə yadda saxlayan metod
  public String saveFileWithUuid(MultipartFile file) {
    try {
      if (file.isEmpty()) {
        throw new InvalidFileTypeException("File cannot be empty!");
      }

      String contentType = file.getContentType();
      if (contentType == null || !ALLOWED_TYPES.contains(contentType)) {
        throw new InvalidFileTypeException(
                "Only image files are allowed (jpeg, jpg, png, webp)!"
        );
      }

      String originalFilename = file.getOriginalFilename();
      String extension = "";

      if (originalFilename != null && originalFilename.contains(".")) {
        extension = originalFilename.substring(
                originalFilename.lastIndexOf(".")
        );
      }

      String uuidFileName = UUID.randomUUID() + extension;

      Path uploadPath = Paths.get(UPLOAD_DIR);
      Files.createDirectories(uploadPath);

      Path filePath = uploadPath.resolve(uuidFileName);
      Files.write(filePath, file.getBytes());

      return uuidFileName;

    } catch (IOException e) {
      throw new InvalidFileTypeException(
              "An error occurred while saving the file"
      );
    }
  }

  //❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️

  // Frontend üçün şəkli oxuyan metod  // YENİ
  public ResponseEntity<Resource> getImage(String fileName) {

    try {
      Path path = Paths.get(UPLOAD_DIR).resolve(fileName);
      Resource resource = new UrlResource(path.toUri());

      if (!resource.exists()) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.ok()
              .contentType(MediaType.IMAGE_JPEG) // brauzer özü handle edir
              .body(resource);

    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }
}