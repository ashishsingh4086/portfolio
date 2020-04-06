package com.ashish.portfolio.UserAuthentication.validator;

import com.ashish.portfolio.UserAuthentication.model.UserAuthenticationDTO;
import com.ashish.portfolio.common.message.MessageHandler;
import com.ashish.portfolio.common.message.MessageListHandler;
import org.springframework.validation.Errors;

public class AuthenticationValidator {
  public MessageListHandler validateAuthentication(UserAuthenticationDTO dto, Errors errors) {
    if (errors.hasErrors()) {
      return new MessageListHandler(errors);
    }
    String password = dto.getPassword();
    return this.isPasswordValid(password);
  }

  private MessageListHandler isPasswordValid(String password) {
    MessageListHandler messageListHandler = new MessageListHandler();
    if (password.length() < 8) {
      messageListHandler.setMessageHandlerList(
          MessageHandler.getErrors(
              "Invalid password.Your password has to be of at least 8 character long."));
    }
    return messageListHandler;
  }
}
