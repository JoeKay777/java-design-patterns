package com.copy.readme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Description: 复制README-zh.md
 * @author: qkh
 * @date: 2024年04月07日 16:11
 */
public class CopyReadmeZh {

    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        File rootDir = new File(rootPath);
        Map<String, String> zhFileMap = zhFileMap();
        Stream.of(rootDir.listFiles()).filter(subDir -> !subDir.getName().contains(".")).forEach(subDir -> {
            String sourcePath = zhFileMap.get(subDir.getName());
            if (sourcePath == null) {
                System.out.println("not found zh file:" + subDir.getName());
                return;
            }
            try {
                Files.copy(Paths.get(sourcePath), Paths.get(subDir.getAbsolutePath() + File.separator + "README-zh.md"), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("copy success:" + subDir.getName());
            } catch (IOException e) {
                System.out.println("copy failed:");
                e.printStackTrace();
            }
        });
    }

    private static Map<String, String> zhFileMap() {
        String rootPath = System.getProperty("user.dir");
        File rootDir = new File(rootPath, "localization/zh");
        Map<String, String> zhFileMap = new HashMap<>();
        Stream.of(rootDir.listFiles()).forEach(subDir -> {
            zhFileMap.put(subDir.getName(), new File(subDir, "README.md").getAbsolutePath());
        });
        return zhFileMap;
    }
}
