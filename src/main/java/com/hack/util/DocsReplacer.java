package com.hack.util;

import com.hack.dto.Dtp;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lnurullina
 */
public class DocsReplacer {

    //    @Value("${filepath}")
    private String dir = "C:/Users/Liia/Downloads/";
    private String outDir = "C:/Users/Liia/Desktop/";

    static final String filePath = "Blan-Evroprotokola-pri-DTP.docx";

    public void replace(String outpath, Dtp dtp) throws IOException {
        String filepath = dir + filePath;
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
            if (sb.length() > 0 && (sb.toString().contains("$FULLDTPPLACE") ||
                    sb.toString().contains("$DATE")
                    || sb.toString().contains("$CC")
                    || sb.toString().contains("$VN")
                    || sb.toString().contains("$WITNESS"))) {
                // Remove all existing runs
                for (int i = numberOfRuns; i >= 0; i--) {
                    p.removeRun(i);
                }
                String text = sb.toString();
                text = text.replace("$FULLDTPPLACE", dtp.getFullDtpPlace());
                text = text.replace("$DATE", dtp.getDate());
                text = text.replace("$CC", String.valueOf(dtp.getCarCrashedCount()));
                text = text.replace("$VN", String.valueOf(dtp.getVictimsNumbers()));
                text = text.replace("$WITNESS", "WITNESS");

                // Add new run with updated text
                XWPFRun run = p.createRun();
                run.setText(text);
                p.addRun(run);
            }


        }


        doc.write(new FileOutputStream(outDir + outpath + ".docx"));
    }


}
