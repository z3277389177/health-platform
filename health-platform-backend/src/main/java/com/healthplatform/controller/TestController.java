package com.healthplatform.controller;

import com.healthplatform.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口 — 用于 S3 前后端联调验证
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.ok("全球健康发展监测与分析平台运行中 🌍");
    }
}
