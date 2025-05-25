import application.*;
import domain.EmailSender;

public class Main {
    public static void main(String[] args) {
        EmailSender sender = new BasicEmailSender();

        // Apply decorators: Compression -> Encryption -> Signature
        sender = new CompressionDecorator(sender);
        sender = new EncryptionDecorator(sender);
        sender = new SignatureDecorator(sender);

        sender.send("Hello, this is a secure message.");
    }
}
