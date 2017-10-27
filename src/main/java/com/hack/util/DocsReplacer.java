package com.hack.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lnurullina
 */
public class DocsReplacer {
    static String filePath = "C:\\Users\\Liia\\Downloads\\Blan-Evroprotokola-pri-DTP.docx";

    public void replace(String outpath) throws IOException {
        String filepath = filePath;
        File file = new File(filepath);
        XWPFDocument doc = new XWPFDocument(new FileInputStream(file));
        for (XWPFParagraph p : doc.getParagraphs()) {

            int numberOfRuns = p.getRuns().size();

            // Collate text of all runs
            StringBuilder sb = new StringBuilder();
            for (XWPFRun r : p.getRuns()) {
                int pos = r.getTextPosition();
                if (r.getText(pos) != null) {
                    sb.append(r.getText(pos));
                }
            }

            // Continue if there is text and contains "test"
            if (sb.length() > 0 && sb.toString().contains("VAR")) {
                // Remove all existing runs
                for (int i = numberOfRuns; i >= 0; i--) {
                    p.removeRun(i);
                }
                String text = sb.toString().replace("VAR", "CAT");
                // Add new run with updated text
                XWPFRun run = p.createRun();
                run.setText(text);
                p.addRun(run);
            }
        }
        doc.write(new FileOutputStream("C:\\Users\\Liia\\Downloads\\" + outpath + ".docx"));
    }


}
