package net.jsloop.dotunderscorecleanup;

import java.io.File;
import java.util.List;

public interface DUC {
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
    boolean deleteAllDUCFiles(List<File> files);
}
