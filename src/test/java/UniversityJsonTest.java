
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

    @Test
    public void testUniversityJsonSerialization() throws IOException {
        // Створення типового університету
        University oldUniversity = Run.createTypicalUniversity();

        // Створення JsonManager
        JsonManager jsonManager = new JsonManager();

        // Шлях до постійного файлу
        String filePath = "university.json";
        // Запис університету у файл
        jsonManager.writeUniversityToFile(oldUniversity, filePath);

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