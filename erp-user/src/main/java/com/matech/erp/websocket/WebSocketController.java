package com.matech.erp.websocket;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/ws")
public class WebSocketController {

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/wsocket");
        mav.addObject("cid", cid);
        return mav;
    }

    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public ResponseEntity pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(cid+"#"+e.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}