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
        String flag = "";
        if (args.length == 1) {
            System.out.println("arg: " + args[0]);
            path = args[0];
        } else if (args.length == 2) {
            path = args[0];
            flag = args[1];
        } else {
            System.out.println("DotUnderscoreCleanup by jsloop.\n" +
                    "Usage: java -jar DotUnderscoreCleanup.jar <path> <optional-flag>\n" +
                    "path: Absolute path to the folder root.\n" +
                    "optional-flag: --list To list all resource fork files.");
            System.exit(1);
        }
        DUC duc = new DUCImpl();
        List<File> files = duc.listAllDUCFiles(path);
        for (File file : files) {
            System.out.println("File: " + file.getName());
        }
        System.out.println("Files count: " + files.size());
        if (flag.equals("--list")) {
            System.exit(0);
        } else {
            if (!files.isEmpty()) {
                boolean status = duc.deleteAllDUCFiles(files);
                System.out.println("All files deleted: " + status);
            } else {
                System.out.println("No files to delete.");
            }
        }
    }
}
