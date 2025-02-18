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
    private static final DUC duc = new DUCImpl();

    private static void listFileNames(List<File> files) {
        for (File file : files) {
            System.out.println("File: " + file.getName());
        }
        System.out.println("Files count: " + files.size());
    }

    private static void listFilePaths(List<File> files) {
        for (File file : files) {
            System.out.println("File: " + file.getAbsolutePath());
        }
        System.out.println("Files count: " + files.size());
    }

    private static void deleteFiles(List<File> files) {
        if (!files.isEmpty()) {
            boolean status = duc.deleteAllFiles(files);
            System.out.println("All files deleted: " + status);
        } else {
            System.out.println("No files to delete.");
        }
    }

    public static void main(String[] args) {
        String path = "";
        String flag = "";
        String pattern = "";
        if (args.length == 2) {  // list flag
            path = args[0];
            flag = args[1];
        } else if (args.length == 3) {  // .DSStore flag
            path = args[0];
            pattern = args[1];
            flag = args[2];
        } else {
            System.out.println("DotUnderscoreCleanup by jsloop.\n" +
                    "Usage: java -jar DotUnderscoreCleanup.jar <path> <flag>\n" +
                    "Usage: java -jar DotUnderscoreCleanup.jar <path> <prefix> <flag>\n" +
                    "path: Absolute path to the folder root.\n" +
                    "prefix: Beginning of the string to match.\n" +
                    "flag: --list To list all resource fork files.\n" +
                    "flag: --delete Delete matched files.");
            System.exit(1);
        }
        List<File> files;
        if (!pattern.isEmpty()) {
            files = duc.listAllFilesStartingWith(path, pattern);
            if (flag.equals("--list")) {
                listFilePaths(files);
            } else if (flag.equals("--delete")) {  // delete
                listFilePaths(files);
                deleteFiles(files);
            }
            System.exit(0);
        }
        files = duc.listAllDUCFiles(path);
        if (flag.equals("--list")) {
            listFileNames(files);
        } else if (flag.equals("--delete")) {
            listFileNames(files);
            deleteFiles(files);
        }
    }
}
