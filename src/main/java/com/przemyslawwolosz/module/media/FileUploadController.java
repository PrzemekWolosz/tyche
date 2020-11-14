package com.przemyslawwolosz.module.media;

import org.springframework.web.bind.annotation.GetMapping;

public class FileUploadController {

    @GetMapping("/media")
    public String getMediaPage() {
        return "media/index.html";
    }
}
