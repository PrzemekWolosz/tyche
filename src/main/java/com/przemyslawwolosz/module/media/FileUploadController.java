package com.przemyslawwolosz.module.media;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadController {

    @GetMapping("/media")
    public String getMediaPage() {
        return "media/index.html";
    }

}
