package com.user.fileupload.fileupload.service;

import com.user.fileupload.fileupload.dao.repository.UserRepository;
import com.user.fileupload.fileupload.dto.UserRequestDto;
import com.user.fileupload.fileupload.dto.UserResponseDto;
import com.user.fileupload.fileupload.exception.InvalidFileTypeException;
import com.user.fileupload.fileupload.mapper.UserMapper;
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
  private static final String UPLOAD_DIR = "uploads/";
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private static final List<String> ALLOWED_TYPES = List.of(
          "image/jpeg",
          "image/jpg",
          "image/png",
          "image/webp"
  );

  public Long addUser(UserRequestDto requestDtoDto) {
    var addUser = userRepository.save(userMapper.requestDtoToEntity(requestDtoDto));
    return addUser.getId();
  }

  public UserResponseDto getUserById(Long id) {
    return userMapper.entityToDto(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" + id)));
  }

  public List<UserResponseDto> getAllUsers() {
    return userMapper.entityListToDtoList(userRepository.findAll());
  }

  public String saveFileWithUuid(MultipartFile file) {
    try {
      if (file.isEmpty()) {
        throw new InvalidFileTypeException("File cannot be empty!");
      }

      String contentType = file.getContentType();
      if (contentType == null || !ALLOWED_TYPES.contains(contentType)) {
        throw new InvalidFileTypeException("Only image files are allowed (jpeg, jpg, png, webp)!");
      }

      String originalFilename = file.getOriginalFilename();
      String extension = "";
      if (originalFilename != null && originalFilename.contains(".")) {
        extension = originalFilename.substring(originalFilename.lastIndexOf("."));
      }

      String uuidFileName = UUID.randomUUID() + extension;

      Path uploadPath = Paths.get(UPLOAD_DIR);
      if (!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
      }

      Path filePath = uploadPath.resolve(uuidFileName);
      Files.write(filePath, file.getBytes());

      return uuidFileName;

    } catch (IOException e) {
      throw new InvalidFileTypeException("An error occurred while saving the file:");
    }
  }
}
