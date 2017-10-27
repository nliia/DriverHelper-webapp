package com.hack.controller;

import com.hack.util.DocsReplacer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lnurullina
 */
@Controller
public class MainController {

    @RequestMapping("/home")
    public String getHello(Model model) {
        model.addAttribute("var", SecurityContextHolder.getContext().getAuthentication().getCredentials());
        return "hello";
    }

    @RequestMapping("/upload/{filename}")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response,
                               @PathVariable("filename") String fileName) {
        //If user is not authorized - he should be thrown out from here itself

        //Authorized user will download the file
        //String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/");
        Path file = Paths.get("C:\\Users\\Liia\\Downloads\\", fileName + ".docx");

        if (!Files.exists(file)) {
            DocsReplacer docsReplacer = new DocsReplacer();
            try {
                docsReplacer.replace(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        response.setContentType("application/docx");
        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
        try {
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "redirect: /home";
    }
}
