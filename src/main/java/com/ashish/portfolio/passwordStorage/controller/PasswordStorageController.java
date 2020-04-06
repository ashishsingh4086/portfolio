package com.ashish.portfolio.passwordStorage.controller;

import com.ashish.portfolio.common.message.MessageListHandler;
import com.ashish.portfolio.common.core.endpoint.EndPointResponse;
import com.ashish.portfolio.common.core.endpoint.ResponseResult;
import com.ashish.portfolio.passwordStorage.model.PasswordStorage;
import com.ashish.portfolio.passwordStorage.model.PasswordStorageDTO;
import com.ashish.portfolio.passwordStorage.repository.PasswordStorageRepository;
import com.ashish.portfolio.passwordStorage.validator.PasswordStorageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PasswordStorageController {
    private PasswordStorageRepository passwordStorageRepository;

    @Autowired
    public PasswordStorageController(PasswordStorageRepository passwordStorageRepository) {
        this.passwordStorageRepository = passwordStorageRepository;
    }

    @GetMapping("/password-storage")
    public EndPointResponse<?> getEntityByList() {
        List<PasswordStorage> passwordStorageList = passwordStorageRepository.findAll();
        return ResponseResult.ok(passwordStorageList);
    }


    @GetMapping("password-storage/{id}")
    public EndPointResponse<?> getEntityById(@PathVariable Long id) {
        PasswordStorage passwordStorage = passwordStorageRepository.findById(id);
        return ResponseResult.ok(passwordStorage);

    }


    @PostMapping("password-storage")
    public EndPointResponse<?> createEntity(@Valid @RequestBody PasswordStorageDTO passwordStorageDTO, Errors errors) {
        PasswordStorageValidator passwordStorageValidator = new PasswordStorageValidator();
        MessageListHandler messageListHandler = passwordStorageValidator.validatePasswordStorage(passwordStorageDTO, errors);
        if (messageListHandler.getHasErrors()) {
            return ResponseResult.ok(messageListHandler);
        }

        PasswordStorage passwordStorage = new PasswordStorage();
        passwordStorage.setUsername(passwordStorageDTO.getUsername());
        passwordStorage.setPassword(passwordStorageDTO.getPassword());
        passwordStorage.setQuestion1(passwordStorageDTO.getQuestion1());
        passwordStorage.setAnswer1(passwordStorageDTO.getAnswer1());
        passwordStorage.setQuestion1(passwordStorageDTO.getQuestion2());
        passwordStorage.setAnswer1(passwordStorageDTO.getAnswer2());
        passwordStorage.setQuestion1(passwordStorageDTO.getQuestion3());
        passwordStorage.setAnswer1(passwordStorageDTO.getAnswer3());
        passwordStorage.setQuestion1(passwordStorageDTO.getQuestion4());
        passwordStorage.setAnswer1(passwordStorageDTO.getAnswer4());
        passwordStorage.setQuestion1(passwordStorageDTO.getQuestion5());
        passwordStorage.setAnswer1(passwordStorageDTO.getAnswer5());
        this.passwordStorageRepository.save(passwordStorage);
        return ResponseResult.ok();
    }

    @PutMapping("/password-storage/{id}")
    public EndPointResponse<?> updateEntity(@RequestBody PasswordStorageDTO passwordStorageDTO, @PathVariable Long id) {
        PasswordStorage passwordStorage = passwordStorageRepository.findById(id);
        passwordStorageDTO.setUsername(passwordStorage.getUsername());
        this.passwordStorageRepository.save(passwordStorage);
        return ResponseResult.ok();
    }


}