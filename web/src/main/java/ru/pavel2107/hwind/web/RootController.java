package ru.pavel2107.hwind.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.Contended;

/**
 * Created by admin on 30.03.2016.
 */

@Controller
public class RootController {

    @RequestMapping( value="/", method = RequestMethod.GET)
    public String root(){
        return "index.html";
    }
}
