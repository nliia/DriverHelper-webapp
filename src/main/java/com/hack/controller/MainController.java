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
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
        List<Dtp> list = dtpService.getDtps();
        for (Dtp dtp : list) {
            dtp.setDateD(new Date(dtp.getDate()));
        }
       model.addAttribute("dtpList", list);
        return "hello";
    }

    @RequestMapping("/archived")
    public String getArchived(Model model) {
        List<Dtp> list = dtpService.getArchivedDtps();
        for (Dtp dtp : list) {
            dtp.setDateD(new Date(dtp.getDate()));
        }
        model.addAttribute("dtpList", list);
        return "archived";
    }

    @RequestMapping(value = "/close_dtp/{id}", method = RequestMethod.POST)
    public String close(Model model, @PathVariable("id") Long id) {
        dtpService.closeDtp(id);
        return "redirect: /home";
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
