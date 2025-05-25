import application.ProxyImage;
import domain.Image;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("cat.png");
        Image image2 = new ProxyImage("dog.jpg");

        System.out.println("First call:");
        image1.display();
        System.out.println();

        System.out.println("Second call:");
        image1.display();
        System.out.println();

        System.out.println("Third call:");
        image2.display();
    }
}
