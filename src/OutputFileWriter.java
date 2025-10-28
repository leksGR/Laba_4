import java.io. *;
import java.util.Iterator;
import java.util.Map;

/**
 * Класс для записи информации в файл
 */
public class OutputFileWriter {

    /** Статический экземпляр класса Репозиторий */
    public static Repository _repository = new Repository();

    /**
     * Метод сохраняет полный отчет в файл
     * @param filename имя файла
     * @return true - если запись успешна, false - в противном случае
     */
    public static boolean saveToFile(String filename) throws FileNotFoundException {
        FileOutputStream fos=new FileOutputStream(filename);
        try (PrintStream outputWriter = new PrintStream(fos)) {

            Iterator<Map.Entry<String, String>> iterator = _repository.getIterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                outputWriter.println(entry.getKey() + " = " + entry.getValue());
            }

            outputWriter.println();
            outputWriter.println("keys: " + String.join(" ", _repository.getKeys()));

            outputWriter.println();
            outputWriter.println("values: " + String.join(" ", _repository.getValues()));

            outputWriter.close();
            return true;
        }
    }
}
