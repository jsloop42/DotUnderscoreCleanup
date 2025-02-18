package net.jsloop.dotunderscorecleanup.impl;

import net.jsloop.dotunderscorecleanup.DUC;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DUCImpl implements DUC {
    private final List<File> filesWithPattern = new ArrayList<>();

    @Override
    public List<File> listAllFilesStartingWith(String path, String prefix) {
        File root = new File(path);
        if (root.exists() && root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        listAllFilesStartingWith(file.getAbsolutePath(), prefix);
                    } else if (file.getName().startsWith(prefix)) {
                        filesWithPattern.add(file);
                    }
                }
            }
        }
        return filesWithPattern;
    }

    @Override
    public List<File> listAllDUCFiles(String path) {
        return listAllFilesStartingWith(path, "._");
    }

    @Override
    public boolean deleteAllFiles(List<File> files) {
        boolean status = true;
        boolean ret;
        for (File file : files) {
            ret = file.delete();
            if (!ret) {
                status = ret;
            }
        }
        return status;
    }
}
