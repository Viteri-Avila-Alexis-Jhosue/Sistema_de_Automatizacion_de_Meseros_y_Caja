package ec.edu.espe.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class pdfController {
    public static void createPDF(String fileName, String textContent) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            document.add(new Paragraph(textContent));
            document.close();
            System.out.println("PDF guardado");
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
