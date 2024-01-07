package org.example.files;

import java.io.*;
import java.net.URI;

public class Use {
    public static void main(String[] args) {
        // Create files
        File dir = new File("C://FolderName");

        File file1 = new File("C://OtherFolder", "file.txt");

        File file2 = new File(dir, "file.txt");

        // File with URI
//        URI uri = new URI("C://Folder/file.txt");
//        File file = new File(uri);
        // Uniform Resource Identifier (URI).
        // This can be useful when working with URIs, especially for web resources.

        // List of methods on uri
        // canRead(), canWrite(), createNewFile(), delete(), exists()
        // getName(), getAbsolutePath(), length(), list(), mkdir()

        // FileReader
        try {
            FileReader reader = new FileReader("input.txt");
            int data;
            while ((data = reader.read()) != -1) {
                char character = (char) data;
                System.out.print(character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileWriter
        try {
            FileWriter writer = new FileWriter("output.txt");
            // Creates a new file or overwrites an existing file
            String data = "This is the data to be written to the file.";
            writer.write(data);
            //writer.write(data);
            // Appends to an existing file
            writer.append("Hello");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // BufferedReader
        try {
            BufferedReader bufferedReader = new
                    BufferedReader(new FileReader("input.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
