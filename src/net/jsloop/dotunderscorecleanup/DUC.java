package net.jsloop.dotunderscorecleanup;

import java.io.File;
import java.util.List;

public interface DUC {
    /**
     * Lists all files starting with the given prefix recursively.
     * @param path The root directory.
     * @param prefix The string to match starting from the beginning
     * @return The list of files matching the pattern
     */
    List<File> listAllFilesStartingWith(String path, String prefix);

    /**
     * Gets a list of all resource fork dot underscore files.
     * @param path The root directory.
     * @return The list of resource fork files.
     */
    List<File> listAllDUCFiles(String path);

    /**
     * Deletes all given files.
     * @param files The list of files to delete.
     * @return True if all files are deleted successfully.
     */
    boolean deleteAllFiles(List<File> files);
}
