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
        System.out.println("Бригада 13: Медведев А., Толстоухов В.\n");
    }

    /**
     * Метод взаимодействия с пользователем
     */
    public void run() {
        getInformationMessage();
        menu();
        String choose = _sc.nextLine();
        while (!choose.isEmpty()) {
            try {
                switch (choose) {
                    case "1":
                        addNewKey();
                        break;
                    case "2":
                        showAllKeys();
                        break;
                    case "3":
                        uploadToFile();
                        break;
                    default:
                        System.out.println("Выбор не распознан!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            menu();
            choose = _sc.nextLine();
        }
        System.out.println("Вы вышли из программы!");
    }

    /**
     * Меню приложения
     */
    private void menu() {
        System.out.println("Выберите действие: ");
        System.out.println("1. Добавить новый ключ");
        System.out.println("2. Вывести содержимое коллекции");
        System.out.println("3. Сохранить содержимое коллекции в файл");
        System.out.println("Для выхода введите пустую строку...");
        System.out.print("Ваш выбор: ");
    }

    /**
     * Метод, инициализирующий добавление нового ключа в HashMap
     */
    private void addNewKey() {
        System.out.print("Введите значение ключа: ");
        String value = _sc.nextLine();
        String message = Key.putNewByValue(value);
        System.out.println(message);
        showAllKeys();
    }

    /**
     * Метод выводит все ключи HashMap
     */
    private void showAllKeys() {
        String message = Key.showAll();
        System.out.println(message);
    }

    /**
     * Метод, инициализирующие сохранение данных в файл
     */
    private void uploadToFile() {
        System.out.print("Введите название файла: ");
        String filename = _sc.nextLine();
        boolean success = OutputWriter.isFileExist(filename);

        if (success) {
            success = OutputWriter.saveToFile(filename);
            if (success) {
                System.out.println("Сохранено в файл " + filename);
            } else {
                System.out.println("Ошибка сохранения в файл " + filename);
            }
        } else {
            System.out.println("Ошибка! Данный файл не существует.\n" +
                    "Хотите создать файл и сохранить туда информация о ключах?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            System.out.print("Ваш выбор: ");
            String choose = _sc.nextLine();

            switch(choose) {
                case "1":
                    success = OutputWriter.saveToFile(filename);
                    if (success) {
                        System.out.println("Сохранено в файл " + filename);
                    } else {
                        System.out.println("Ошибка сохранения в файл " + filename);
                    }
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Выбор не распознан!");
                    break;
            }
        }
    }
}