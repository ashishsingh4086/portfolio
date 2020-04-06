package com.ashish.portfolio.UserAuthentication.controller;

import com.ashish.portfolio.UserAuthentication.model.UserAuthentication;
import com.ashish.portfolio.UserAuthentication.model.UserAuthenticationDTO;
import com.ashish.portfolio.UserAuthentication.repository.UserAuthenticationRepository;
import com.ashish.portfolio.UserAuthentication.validator.AuthenticationValidator;
import com.ashish.portfolio.common.core.endpoint.EndPointResponse;
import com.ashish.portfolio.common.core.endpoint.ResponseResult;
import com.ashish.portfolio.common.message.MessageListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserAuthenticationController {
  private UserAuthenticationRepository authenticationRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserAuthenticationController(UserAuthenticationRepository authenticationRepository) {
    this.authenticationRepository = authenticationRepository;
    this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
  }

  @GetMapping("/private/authentication/all")
  public EndPointResponse<?> getEntityByList() {
    List<UserAuthentication> userAuthenticationList = authenticationRepository.findAll();
    return ResponseResult.ok(userAuthenticationList);
  }

  @GetMapping("/private/authentication/{id}")
  public EndPointResponse<?> getEntityById(@PathVariable Long id) {
    Optional<UserAuthentication> userAuthentication = authenticationRepository.findById(id);
    return ResponseResult.ok(userAuthentication);
  }

  @PostMapping("/authentication")
  public EndPointResponse<?> createEntity(
      @Valid @RequestBody UserAuthenticationDTO dto, Errors errors) {
    AuthenticationValidator validator = new AuthenticationValidator();
    MessageListHandler messageListHandler = validator.validateAuthentication(dto, errors);
    if (messageListHandler.getHasErrors()) {
      return ResponseResult.ok(messageListHandler);
    }
    UserAuthentication userAuthentication = new UserAuthentication();
    userAuthentication.setUsername(dto.getUsername());
    userAuthentication.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
    this.authenticationRepository.save(userAuthentication);
    return ResponseResult.ok();
  }

  public EndPointResponse<?> updateEntity(Object Class, Long id) {
    return null;
  }

  @GetMapping("/")
  public String home() {
    return ("<h1>Welcome </h1>");
  }

  @GetMapping("/user")
  public String user() {
    return ("<h1>Welcome </h1>");
  }

  @GetMapping("/admin")
  public String admin() {
    return ("<h1>Welcome </h1>");
  }
}
