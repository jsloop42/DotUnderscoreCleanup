package net.jsloop.dotunderscorecleanup;

import net.jsloop.dotunderscorecleanup.impl.DUCImpl;

import java.io.File;
import java.util.List;

/**
 * macOS resource fork cleaner
 * Mon 17 Feb 25
 * @author jsloop
 */
public class DotUnderscoreCleanup {
    public static void main(String[] args) {
        String path = "";
        if (args.length == 1) {
            System.out.println("arg: " + args[0]);
            path = args[0];
        } else {
            System.out.println("Usage: java -jar DotUnderscoreCleanup.jar <path>");
            System.exit(1);
        }
        DUC duc = new DUCImpl();
        List<File> files = duc.listAllDUCFiles(path);
        System.out.println("Files count: " + files.size());
        for (File file : files) {
            System.out.println("File: " + file.getName());
        }
        if (!files.isEmpty()) {
            boolean status = duc.deleteAllDUCFiles(files);
            System.out.println("All files deleted: " + status);
        } else {
            System.out.println("No files to delete.");
        }
    }
}
