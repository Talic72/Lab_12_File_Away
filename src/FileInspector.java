import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser(new File("src"));
        int product = chooser.showOpenDialog(null);

        if (product == JFileChooser.APPROVE_OPTION){
            File chosenOne = chooser.getSelectedFile();
            int lines = 0;
            int words = 0;
            int characters = 0;

            System.out.println("\n--- File Content ---");
            try (Scanner fileScanner = new Scanner(chosenOne)) {

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                    lines++;
                    String[] wordCount = line.trim().split("\\s+");

                    if (!line.trim().isEmpty()) {
                        words += wordCount.length;
                    }
                    characters += line.length();
                }

                // Summary
                System.out.println("\n_____File Content_____");
                System.out.println("File name: " + chosenOne.getName());
                System.out.println("Lines: " + lines);
                System.out.println("Words: " + words);
                System.out.println("Characters: " + characters);
            }
            catch (FileNotFoundException e) {
                System.out.println("Could not read the file: " + e.getMessage());
            }
        }
        else {
            System.out.println("No file selected.");
        }
    }
}