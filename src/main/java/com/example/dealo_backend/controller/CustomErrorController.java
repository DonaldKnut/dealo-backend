package com.example.dealo_backend.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Provide the path to your custom error page
        return "error"; // Assuming you have a template named "error.html"
    }

//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
}
