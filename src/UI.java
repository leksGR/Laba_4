/**
 * Класс взаимодействия с пользователем
 */
public class UI {

    /**
     * Конструктор по умолчанию
     */
    UI() {}

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

        System.out.println("Список ключей:");
        String keys = OutputWriter._repository.getKeysAsString();
        System.out.println(keys);

        try {
            boolean success = OutputWriter.saveToFile("keys_report.txt");

            if (success) {
                System.out.println("Сохранено в файл keys_report.txt");
            } else {
                System.out.println("Ошибка при сохранении в файл");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}