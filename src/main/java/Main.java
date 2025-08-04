import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();


        Path path = Paths.get("C:\\JavaPractice\\StudyWeek3\\src\\main\\resources\\text.txt");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите текст: ");
            while (true) {
                String str = reader.readLine();
                if (str.equals("exit")) {
                    break;
                }
                sb.append(str).append("\n");
                System.out.println("Строка  записана \n" +
                        "Для окончания записи текста введите команду exit");
            }
            String text = sb.toString();

            Files.createFile(path);
            Files.write(path,text.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            List<String> list = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

//"C:\\JavaPractice\\StudyWeek3\\src\\main\\resources\\text.txt"
