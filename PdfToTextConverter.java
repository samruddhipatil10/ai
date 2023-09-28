import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfToTextConverter {

    public static void main(String[] args) {
        String pdfFilePath = "C:/Users/psamr/Downloads/Strategies_for_Imbalanced_Data_compressed.pdf";
        String textFilePath = "C:/prachi/Text File/pdf.txt";
        convertPdfToText(pdfFilePath, textFilePath);
    }

    public static void convertPdfToText(String pdfFilePath, String textFilePath) {
        try {
            PdfReader reader = new PdfReader(pdfFilePath);
            StringBuilder textContent = new StringBuilder();

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                textContent.append(PdfTextExtractor.getTextFromPage(reader, i));
                textContent.append("\n");
            }

            File outputFile = new File(textFilePath);
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(textContent.toString().getBytes("UTF-8"));
            }

            System.out.println("PDF to text conversion completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
