package com.hack.controller;

import com.hack.dto.Dtp;
import com.hack.service.impl.DtpServiceImpl;
import com.hack.util.DocsReplacer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lnurullina
 */
@Controller
public class MainController {
    @Autowired
    DtpServiceImpl dtpService;

    @RequestMapping("/home")
    public String getHello(Model model) {
        model.addAttribute("var", SecurityContextHolder.getContext().getAuthentication().getCredentials());
        model.addAttribute("dtpList", dtpService.getFinishedDtps());
        return "hello";
    }

    @RequestMapping("/upload/{filename}")
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response,
                               @PathVariable("filename") String fileName) {
        //If user is not authorized - he should be thrown out from here itself
        //Authorized user will download the file
        File file = new File("C:\\Users\\Liia\\Desktop\\", fileName + ".docx");
        Dtp dtp = dtpService.getDtp(Long.valueOf(fileName));
        if (!file.exists()) {
            DocsReplacer docsReplacer = new DocsReplacer();
            try {
                docsReplacer.replace(fileName, dtp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        response.setContentType("application/docx");
        response.addHeader("Content-Disposition", "attachment; filename=" + fileName + ".docx");
        try {
            InputStream in = new FileInputStream(file);
            FileCopyUtils.copy(in, response.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "redirect: /home";
    }
}
