package xyz.enhorse.codeeval;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 18/04/15.
 */
public class TestData {

    public static final String PATH = getFileFromURL();


    private TestData() {
    }


    private static String getFileFromURL() {
        URL url = TestData.class.getResource("/data/");
        File file;
        try {
            file = new File(url != null ? url.toURI() : URI.create(""));
        } catch (URISyntaxException e) {
            file = new File(url.getPath());
        }

        return file.getAbsolutePath() + File.separator;
    }
}
