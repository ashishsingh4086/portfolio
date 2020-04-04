package com.ashish.portfolio.common.message;

public enum MessageSeverity {
    SEVERITY_ERROR(Message.SEVERITY_ERROR_CODE),
    SEVERITY_WARNING(Message.SEVERITY_WARNING_CODE),
    SEVERITY_SUCCESS(Message.SEVERITY_SUCCESS_CODE),
    SEVERITY_INFO(Message.SEVERITY_INFO_CODE);

    private final int severityCode;

    MessageSeverity(int code) {
        this.severityCode = code;
    }

    public static MessageSeverity getSeverity(int code) {
        switch (code) {
            case Message.SEVERITY_ERROR_CODE:
                return SEVERITY_ERROR;
            case Message.SEVERITY_WARNING_CODE:
                return SEVERITY_WARNING;
            case Message.SEVERITY_SUCCESS_CODE:
                return SEVERITY_SUCCESS;
            case Message.SEVERITY_INFO_CODE:
                return SEVERITY_INFO;
            default:
                return null;
        }
    }
}
