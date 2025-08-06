import exceptions.MyException;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "src/main/resources/text.txt"))) {
            writer.write("Hello World!\n");
            writer.write("Hello World!\n");
            writer.write("Hello World!\n");
            writer.write("Hello World!\n");

        } catch (IOException e) {
            throw new MyException("Ошибка записи в файл",e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/main/resources/text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new MyException("Ошибка чтения файла", e);
        }
    }
}

