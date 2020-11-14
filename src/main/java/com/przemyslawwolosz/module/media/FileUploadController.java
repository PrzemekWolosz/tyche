package com.przemyslawwolosz.module.media;

import com.przemyslawwolosz.module.media.storage.FileSystemStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

    @Autowired
    private FileSystemStorage storage;

    @GetMapping("/media")
    public String getMediaPage(Model model) {
        model.addAttribute("files", storage.list());
        return "media/index.html";
    }

    @PostMapping("/media")
    public String saveFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) {
        storage.store(file);

        redirectAttributes.addFlashAttribute(
                "message",
                "You successfully uploaded " + file.getOriginalFilename()
        );
        return "redirect:/media";
    }
}
