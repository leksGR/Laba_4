import java.util.Scanner;

/**
 * Класс взаимодействия с пользователем
 */
public class UI {

    /** Объект класса Scanner для считывания пользовательских данных */
    private final Scanner _sc;

    /**
     * Конструктор по умолчанию
     */
    UI() {
        _sc = new Scanner(System.in);
    }

    /**
     * Выводит информационное сообщение
     */
    private void getInformationMessage() {
        System.out.println("Лабораторная работа №4");
        System.out.println("Бригада 13: Медведев А., Толстоухов В.");
    }

    /**
     * Метод взаимодействия с пользователем
     */
    public void run() {
        getInformationMessage();

        /*System.out.println("Список ключей:");
        String keys = OutputWriter._repository.getKeysAsString();
        System.out.println(keys);*/

        try {
            boolean success = OutputWriter.saveToFile("keys_report.txt");

            if (success) {
                System.out.println("Сохранено в файл keys_report.txt");
            } else {
                System.out.println("Ошибка при сохранении в файл");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void menu() {
        System.out.println("Выберите действие: ");
        System.out.println("1. Добавить пару ключ-значение");
        System.out.println("2. Вывести содержимое репозитория");
        System.out.println("3. Сохранить содержимое репозитория в файл");
        System.out.println("Ваш выбор: ");
        int choose = Integer.parseInt(_sc.nextLine());
    }
}