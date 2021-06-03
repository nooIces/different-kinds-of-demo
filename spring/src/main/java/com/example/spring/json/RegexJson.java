package com.example.spring.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RegexJson {


    public static void main(String[] args) throws IOException {
        String path = "E:\\test";
        File file = new File(path);
        Set<String> urls = new HashSet<>();
        findByFolder(file, urls);
        print(urls);
    }

    private static void print(Set<String> urls) throws IOException {
        File output = new File("E:\\test\\output.txt");
        FileOutputStream outputStream = new FileOutputStream(output);
        outputStream.write("---------------this is download urls----------------\r\n".getBytes(UTF_8));
        for(String s : urls){
            if(isNeedIgnore(s)){
                continue;
            }
            outputStream.write((s + "\r\n").getBytes(UTF_8));
        }
        outputStream.write("\r\n".getBytes(UTF_8));
        outputStream.write("---------------this is ignore urls----------------\r\n".getBytes(UTF_8));
        for(String s : urls){
            if(!isNeedIgnore(s)){
                continue;
            }
            outputStream.write((s + "\r\n").getBytes(UTF_8));
        }
        outputStream.write("\r\n".getBytes(UTF_8));
        outputStream.close();
    }

    private static void findByFolder(File folder,Set<String> urls) throws IOException {
        for(File f : Objects.requireNonNull(folder.listFiles())) {
            if(f.isFile()) {
                findUrl(f, urls);
            }
            if(f.isDirectory()) {
                findByFolder(f, urls);
            }
        }
    }

    private static void findUrl(File f, Set<String> urls) throws IOException {

        String jsonDataContent = getString(f);
        Pattern totalPattern = Pattern.compile("https?://([\\w._-]+)(:[0-9]+)?[/|\\w|.|_|-]+(![\\w|.|_|-]+)?(\\?[\\w|.&_=-]+)?");
        Matcher m = totalPattern.matcher(jsonDataContent);
        while(m.find()) {
            urls.add(m.group());
        }

    }

    private static String getString(File file) throws IOException {
        try (Writer writer = new StringWriter(); InputStream is = new FileInputStream(file); Reader reader = new InputStreamReader(is, UTF_8)) {
            char[] buffer = new char[1024];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }
            return writer.toString();
        }
    }

    private static boolean isNeedIgnore(String url) {
        String ignoreRegex = "(https?://www.w3.org([/\\w|.|_|-|!]+)?(\\?[\\w|.&_=-]+)?)|(https?://([\\w._-]+)(:[0-9]+)?[/|\\w|.|_|-]+(![\\w|.|_|-]+)?.action(\\?[\\w|.&_=-]+)?)";
        return url.matches(ignoreRegex);
    }
}
