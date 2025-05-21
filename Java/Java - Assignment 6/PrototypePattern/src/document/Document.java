package document;

import java.util.ArrayList;
import java.util.List;
import java.lang.Cloneable;

public class Document implements Cloneable {
    private String title;
    private String content;
    private List<Section> sections;

    public Document(String title, String content, List<Section> sections) {
        this.title = title;
        this.content = content;
        this.sections = sections;
    }

    @Override
    public Document clone() {
        List<Section> clonedSections = new ArrayList<>();
        for (Section section : sections) {
            clonedSections.add(section.clone());
        }
        return new Document(title, content, clonedSections);
    }

    public void print() {
        System.out.println("document.Document: " + title);
        System.out.println("Content: " + content);
        for (Section s : sections) {
            s.print();
        }
    }
}
