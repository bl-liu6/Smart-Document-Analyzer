import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class Load {
    // Load and edit pdf using PDFBox
    public static void main(String[] args) throws IOException {
        File oldFile = new File("/Users/robert_liu/Documents/Coding/java/PDF/sample.pdf");
        // load existing pdf
        PDDocument document = PDDocument.load(oldFile);
        // add a new page to the pdf
        document.addPage(new PDPage());

        document.save("/Users/robert_liu/Documents/Coding/java/PDF/mypdf.pdf");
        System.out.println("PDF Edited");
        document.close();
    }
}
