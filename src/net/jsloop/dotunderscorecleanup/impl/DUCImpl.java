package net.jsloop.dotunderscorecleanup.impl;

import net.jsloop.dotunderscorecleanup.DUC;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DUCImpl implements DUC {
    private final List<File> filesWithDU = new ArrayList<>();

    @Override
    public List<File> listAllDUCFiles(String path) {
        File root = new File(path);
        if (root.exists() && root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        listAllDUCFiles(file.getAbsolutePath());
                    } else if (file.getName().startsWith("._")) {
                        filesWithDU.add(file);
                    }
                }
            }
        }
        return filesWithDU;
    }

    @Override
    public boolean deleteAllDUCFiles(List<File> files) {
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
