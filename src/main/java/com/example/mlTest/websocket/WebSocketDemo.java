package com.example.mlTest.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author miaoliang
 * @since 3/12/22 9:02 PM
 */
@Controller
public class WebSocketDemo {
    /**
     * 页面请求
     * @param cid
     * @return
     */
    @GetMapping("/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口
     * @param cid
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping("/send/")
    public String pushToWeb(String cid,String message) {
        try {
            WebSocketServer.sendInfo("miaoliang",cid);
        } catch (IOException e) {
            e.printStackTrace();
            return cid+"#"+e.getMessage();
        }
        return cid;
    }
}
