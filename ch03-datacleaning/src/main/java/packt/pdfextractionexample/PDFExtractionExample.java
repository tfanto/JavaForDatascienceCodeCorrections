package packt.pdfextractionexample;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import common.Helper;

public class PDFExtractionExample {

    public static void main(String[] args) {
        try {
        	String filename = Helper.getAbsolutePath("PDF_File.pdf");
            PDDocument document = PDDocument.load(new File(filename));
                PDFTextStripper Tstripper = new PDFTextStripper();
                String documentText = Tstripper.getText(document);
                System.out.println(documentText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
