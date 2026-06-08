package com.healthplatform.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未登录或Token已过期"),
    FORBIDDEN(403, "权限不足"),
    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器内部错误"),

    USER_NOT_FOUND(1001, "用户不存在"),
    USER_PASSWORD_ERROR(1002, "密码错误"),
    USER_DISABLED(1003, "账号已被禁用"),
    USER_ALREADY_EXISTS(1004, "用户名已存在"),

    DATA_IMPORT_FAIL(2001, "数据导入失败"),
    DATA_FILE_EMPTY(2002, "上传文件为空"),

    AI_SERVICE_ERROR(3001, "AI服务调用失败");

    private final int code;
    private final String message;
}
