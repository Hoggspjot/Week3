import exceptions.MyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    private static final String PATH = "src/main/resources/text.txt";


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while (true) {
                System.out.println("Введите текст\nДля завершения введите exit или нажмите Enter");
                if ((line = reader.readLine()) == null || line.equalsIgnoreCase("exit")) {
                    break;
                }
                sb.append(line + "\n");
            }
            writeFile(sb.toString());
            readFile();
        } catch (IOException e) {
            throw new MyException("Ошибка при вводе текста", e);
        }
    }

    public static void writeFile(String text) {
        Path path = Paths.get(PATH);
        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new MyException("Ошибка записи в файл",e);
        }
    }

    public static void readFile() {
        Path path = Paths.get(PATH);
        try {
            List<String> readList = Files.readAllLines(path);
            for (String str : readList) {
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new MyException("Ошибка чтения файла", e);
        }
    }
}

