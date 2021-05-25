package com.example.others.gzip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class DecompressGZipFile {

    public static void main(String[] args) {
        File downloadFile = new File("./others/src/main/java/com/example/others/gzip/gzip_demo.json");
        try {
            String str = decompressGZipFileToStr(downloadFile);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String decompressGZipFileToStr(File downloadFile) throws IOException {
        GZIPInputStream gis = new GZIPInputStream(new FileInputStream(downloadFile));
        Reader reader = new InputStreamReader(gis, StandardCharsets.UTF_8);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        int length;
        while((length = reader.read(buffer)) > 0) {
            writer.write(buffer, 0, length);
        }
        return writer.toString();
    }
}
