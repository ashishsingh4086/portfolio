package com.ashish.portfolio.passwordStorage.validator;

import com.ashish.portfolio.common.message.MessageListHandler;
import com.ashish.portfolio.passwordStorage.model.PasswordStorageDTO;
import org.springframework.validation.Errors;

public class PasswordStorageValidator {
    public MessageListHandler validatePasswordStorage(PasswordStorageDTO dto, Errors errors) {
        return new MessageListHandler(errors);
    }
}
