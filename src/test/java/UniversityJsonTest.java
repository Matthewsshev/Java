
import org.example.controller.JsonManager;
import org.example.model.University;
import org.example.Run;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UniversityJsonTest {

    @TempDir
    Path tempDir; // Тимчасова директорія для тестів


    @Test
    public void testUniversityJsonSerialization() throws IOException {
        // Створення типового університету
        University oldUniversity = Run.createTypicalUniversity();

        // Створення JsonManager
        JsonManager jsonManager = new JsonManager();

        // Шлях до тимчасового файлу
        File tempFile = tempDir.resolve("university.json").toFile();
        String filePath = tempFile.getAbsolutePath();

        // Запис університету у файл
        jsonManager.writeUniversityToFile(oldUniversity, filePath);

        // Перевірка, що файл створено
        assertTrue(tempFile.exists(), "Файл JSON не був створений");

        // Зчитування університету з файлу
        University newUniversity = jsonManager.readUniversityFromFile(filePath);

        // Перевірка, що університети еквівалентні
        assertEquals(oldUniversity, newUniversity, "Відновлений університет не співпадає з оригінальним");

        // Додаткова перевірка для назви університету
        assertEquals(oldUniversity.getName(), newUniversity.getName(), "Назви університетів не співпадають");

        // Додаткова перевірка для кількості факультетів
        assertEquals(oldUniversity.getFaculties().size(), newUniversity.getFaculties().size(),
                "Кількість факультетів не співпадає");

        System.out.println("Тест пройдено успішно!");
    }
}