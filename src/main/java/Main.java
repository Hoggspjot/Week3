import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите название файла для записи: ");
            String nameFile = reader.readLine();
            Path path = getPathFile(nameFile);
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


            Files.write(path,text.getBytes(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        try {
//            List<String> list = Files.readAllLines(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    public static Path getPathFile(String name){
        Path path = Paths.get("C:\\JavaPractice\\StudyWeek3\\src\\main\\resources\\"+name+".txt");
        try {
            Files.createFile(path);
            System.out.println("Файл для записи "+name+"создан");
        } catch (IOException e) {
            if (e.getClass().getSimpleName().equals(name)) {
                System.out.println("Файл уже существует!");
            } else {
                throw new RuntimeException(e);
            }
        }
        return path;
    }

}




//"C:\\JavaPractice\\StudyWeek3\\src\\main\\resources\\text.txt"
