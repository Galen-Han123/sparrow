package com.sparrow;

import java.io.IOException;

public class JournalRenderer {

    public void render() {

        for (JournalEntry x : EntryCollection.getEntries()) {
            try {
                String str = x.getPath().getFileName().toString();
                str = str.substring(str.length() - 3);
                new Renderer(str, x.getTitle()).renderTo();
            } catch (IOException e) {}
        }

    }

    public void watch() {

        while (true) {
            FileWatcher.watch(250);
            render();
        }

    }

}
