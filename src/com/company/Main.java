package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        try {
            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size =" + size);
            System.out.println("Last Modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size =  " + attrs.size());
            System.out.println("Last modified =  " + attrs.lastModifiedTime());
            System.out.println("Created = " + attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());

////            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
////            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//
//            Path sourceFile;
//            Path copyFile;
//
////            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
////            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
////            Path destination = FileSystems.getDefault().getPath("Examples",  "file1copy.txt");
////            Files.move(fileToMove, destination);
//
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1.txt");
//            Files.deleteIfExists(fileToDelete);

        } catch(IOException e) {
            e.printStackTrace();
        }

//        Path path = FileSystems.getDefault().getPath("workingdirectoryfile.txt");
//        printFile(path);

//        Path filePath = FileSystems.getDefault().getPath("files", "subdirectoryfile.txt");
////        printFile(filePath);
//        // write your code here
//
//        filePath = Paths.get("C:\\code\\bootcamp\\path\\files\\subdirectoryfile.txt");
//        printFile(filePath);
    }
    private static void printFile(Path path) {
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
