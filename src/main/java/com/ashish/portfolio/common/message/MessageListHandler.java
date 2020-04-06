package com.ashish.portfolio.common.message;

import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageListHandler {
  private List<MessageHandler> messageHandlerList;

  public MessageListHandler() {
    messageHandlerList = new ArrayList<>();
  }

  public MessageListHandler(Errors errors) {
    this.messageHandlerList =
        errors.getAllErrors().stream()
            .map(c -> new MessageHandler(c.getDefaultMessage(), MessageSeverity.SEVERITY_ERROR))
            .collect(Collectors.toList());
  }

  public List<MessageHandler> getMessageHandlerList() {
    return messageHandlerList;
  }

  public void setMessageHandlerList(MessageHandler messageHandler) {
    this.messageHandlerList.add(messageHandler);
  }

  public boolean getHasErrors() {
    if (this.messageHandlerList != null) {
      return !this.messageHandlerList.isEmpty();
    }
    return false;
  }
}
