package shape;

import java.util.ArrayList;
import java.util.List;

public class Section implements Cloneable {
    private String title;
    private String text;
    private List<Image> images;

    public Section(String title, String text, List<Image> images) {
        this.title = title;
        this.text = text;
        this.images = images;
    }

    @Override
    public Section clone() {
        List<Image> clonedImages = new ArrayList<>();
        for (Image img : images) {
            clonedImages.add(img.clone());
        }
        return new Section(title, text, clonedImages);
    }

    public void print() {
        System.out.println("  shape.Section: " + title);
        System.out.println("  Text: " + text);
        for (Image img : images) {
            img.print();
        }
    }
}
