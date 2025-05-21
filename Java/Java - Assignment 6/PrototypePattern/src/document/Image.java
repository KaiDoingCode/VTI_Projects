package document;
import java.lang.Cloneable;

public class Image implements Cloneable {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public Image clone() {
        return new Image(this.url);
    }

    public void print() {
        System.out.println("    document.Image: " + url);
    }
}
