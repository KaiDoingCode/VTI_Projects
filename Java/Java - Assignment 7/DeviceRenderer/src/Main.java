import application.*;
import domain.Document;

public class Main {
    public static void main(String[] args) {
        Document pdf = new PDFDocument();
        Document word = new WordDocument();
        Document markdown = new MarkdownDocument();

        DeviceRenderer mobilePDF = new MobileRenderer(pdf);
        DeviceRenderer desktopWord = new DesktopRenderer(word);
        DeviceRenderer mobileMarkdown = new MobileRenderer(markdown);

        mobilePDF.display();
        System.out.println();

        desktopWord.display();
        System.out.println();

        mobileMarkdown.display();
    }
}
