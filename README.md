# macOS Resource Fork Cleaner

Deletes all files starting with `._` recursively for the given folder. `._` files are macOS resource fork files which 
are not relevant on other operating systems like Windows. Also supports deleting `.DS_Store` files. Tested using JDK 23.

## Running

In general:

```
java -jar DotUnderscoreCleanup.jar <path> <flag>
java -jar DotUnderscoreCleanup.jar <path> <prefix> <flag>
```

### List all `._` files without deleting

```
java -jar DotUnderscoreCleanup.jar <absolute-path> --list
java -jar DotUnderscoreCleanup.jar E:\Temp\Docs --list
```

### To delete all `._` files

```
java -jar DotUnderscoreCleanup.jar <absolute-path> --delete
java -jar DotUnderscoreCleanup.jar E:\Temp\Docs --delete
```

### List all files matching the given prefix string

```
java -jar DotUnderscoreCleanup.jar <absolute-path> <prefix> --list
java -jar DotUnderscoreCleanup.jar E:\Temp\Docs .DS_Store --list
```

### Delete all files matching the given prefix string

```
java -jar DotUnderscoreCleanup.jar <absolute-path> <prefix> --delete
java -jar DotUnderscoreCleanup.jar E:\Temp\Docs .DS_Store --delete
```
