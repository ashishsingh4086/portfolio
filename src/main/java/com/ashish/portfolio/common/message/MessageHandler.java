package com.ashish.portfolio.common.message;

public class MessageHandler {
    private String message;
    private MessageSeverity severity;

    public MessageHandler(String message, MessageSeverity severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(MessageSeverity severity) {
        this.severity = severity;
    }

    public static MessageHandler getErrors(String message) {
        return new MessageHandler(message, MessageSeverity.SEVERITY_ERROR);
    }

}
