package enums;

import common.StringUtil;

public enum ResultEnum {

    OPERATE_SUCCESS("OPERATE_SUCCESS", "00010001", "�����ɹ�"),

    USER_REGISTER_FAILED("USER_REGISTER_FAILED","0001002","ע��ʧ��"),
    
    USER_REGISTER_FAILED_PHONE_SAME("USER_REGISTER_FAILED_PHONE_SAME", "00010003", "�û��ֻ����ظ�"),
    
    USER_LOGIN_FAILED("USER_LOGIN_FAILED","00010004","�û���¼ʧ��");

    private final String value;
    private final String code;
    private final String message;

    private ResultEnum(String value, String code, String message) {
        this.value = value;
        this.code = code;
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultEnum getByValue(String value) {
        if (StringUtil.isBlank(value)) {
            return null;
        }
        value = value.trim();

        for (ResultEnum type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public static ResultEnum getByCode(String code) {
        if (StringUtil.isBlank(code)) {
            return null;

        }
        code = code.trim();

        for (ResultEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }

        return null;
    }

    public static ResultEnum getByMessage(String message) {
        if (StringUtil.isBlank(message)) {
            return null;
        }

        message = message.trim();

        for (ResultEnum type : values()) {
            if (type.getMessage().equals(message)) {
                return type;
            }
        }
        return null;
    }
}
