package com.sparrow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class Renderer {

    private String filePath = "";

    public Renderer(String file) {

        filePath = file;

    }

    public void renderTo(String path) throws IOException {

        Files.write(Paths.get("output/" + path), render().getBytes());

    }

    private String render() throws IOException {

        String content = new String(Files.readAllBytes(Paths.get("input/" + filePath)));

        return renderText(content);

    }

    private String renderText(String text) {

        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        Node doc = parser.parse(text);

        return renderer.render(doc);

    }

}