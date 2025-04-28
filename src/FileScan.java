import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScan {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Command-line argument is passed
            String fileName = args[0];
            System.out.println("Path provided: " + fileName); // Debugging line

            File file = new File(fileName);

            // If file doesn't exist, check "src" folder
            if (!file.exists()) {
                String srcPath = "src" + File.separator + fileName;
                file = new File(srcPath);
                System.out.println("Trying the 'src' path: " + file.getAbsolutePath()); // Debugging line
            }

            if (file.exists() && file.isFile()) {
                System.out.println("Scanning file: " + file.getAbsolutePath());
                try (Scanner scanner = new Scanner(file)) {
                    int lines = 0;
                    int words = 0;
                    int characters = 0;

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        lines++;
                        words += line.split("\\s+").length;
                        characters += line.length();
                    }

                    System.out.println("Lines: " + lines);
                    System.out.println("Words: " + words);
                    System.out.println("Characters: " + characters);
                } catch (FileNotFoundException e) {
                    System.out.println("Error reading the file: " + e.getMessage());
                }
            } else {
                System.out.println("File not found or is not a valid file.");
                System.out.println("Path provided: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No command-line argument provided. Please provide a valid file name.");
        }
    }
}

