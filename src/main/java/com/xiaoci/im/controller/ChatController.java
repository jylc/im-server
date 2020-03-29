package com.xiaoci.im.controller;

import com.xiaoci.im.domain.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    /**
     * 暂时全部发送到公共频道
     *
     * @return result
     */
    @PostMapping("/send")
    public AjaxResult sendMessage() {
        return AjaxResult.success("success");
    }
}
