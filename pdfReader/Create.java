import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class Create {
    // Create pdf file using Apache PDFBox
    public static void main(String[] args) throws IOException {
        PDDocument document = new PDDocument();
        PDPage firstPage = new PDPage();
        document.addPage(firstPage);

        document.save("/Users/robert_liu/Documents/Coding/java/PDF/mypdf.pdf");
        System.out.println("PDF Created");
        document.close();
    }
}
