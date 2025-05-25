package application;

import domain.Document;

public class MarkdownDocument implements Document {
    @Override
    public String getContent() {
        return "This is a Markdown document.";
    }

    @Override
    public String getType() {
        return "Markdown";
    }
}

