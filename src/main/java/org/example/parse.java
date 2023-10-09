package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class parse {
    public static void parser(String fileDirectory, ArrayList<String> result) throws FileNotFoundException {
        File text = new File(fileDirectory);
        Scanner scanner = new Scanner(text);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            result.add(line);
        }
    }
}
