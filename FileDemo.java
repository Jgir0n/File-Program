package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDemo {

    public static void createFile(String fileName) {
        File f = new File(fileName);
        if (f.exists()) {
            System.out.println("File already exists");
            return;
        }
        try {
            if (f.createNewFile()) {
                System.out.println("File created");
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, String data) {
        try (FileWriter myWriter = new FileWriter(fileName)) {
            myWriter.write(data);
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return data.toString();
    }

    public static String readFileByScanner(String fileName) {
        StringBuilder data = new StringBuilder();
        File text = new File(fileName);
        try (Scanner scnr = new Scanner(text)) {
            while (scnr.hasNextLine()) {
                data.append(scnr.nextLine()).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
        return data.toString();
    }

    public static void main(String[] args) {
        String fileName = "abc.txt";
        createFile(fileName);
        String text = "this the first line of the file.\n";
        writeFile(fileName, text);
        String data = readFile(fileName);
        if (data != null) {
            System.out.println("Data from the file:\n" + data);
        }
    }
}
