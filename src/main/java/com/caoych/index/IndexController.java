package com.caoych.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caoych on 2016/12/10.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public  String index() {
        return "index";
    }
}
