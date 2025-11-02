import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем массив студентов
        Student[] studentsArray = {
            new Student(1, "Иванов", "Иван", "Иванович", 
                       LocalDate.of(2000, 5, 15), "ул. Ленина, 15", "+79161234567",
                       "Информатика", 3, "ИВТ-301"),
            new Student(2, "Петров", "Петр", "Петрович", 
                       LocalDate.of(2001, 8, 22), "пр. Мира, 25", "+79169876543",
                       "Экономика", 2, "ЭК-202"),
            new Student(3, "Сидорова", "Анна", "Алексеевна", 
                       LocalDate.of(1999, 12, 3), "ул. Центральная, 10", "+79165554433",
                       "Информатика", 4, "ИВТ-401"),
            new Student(4, "Кузнецов", "Дмитрий", "Сергеевич", 
                       LocalDate.of(2002, 3, 18), "ул. Школьная, 5", "+79167778899",
                       "Экономика", 1, "ЭК-101"),
            new Student(5, "Смирнов", "Андрей", "Владимирович", 
                       LocalDate.of(2000, 7, 30), "ул. Садовая, 8", "+79163332211",
                       "Информатика", 3, "ИВТ-302"),
            new Student(6, "Алексеев", "Сергей", "Михайлович", 
                       LocalDate.of(2001, 1, 25), "пр. Победы, 12", "+79164445566",
                       "Юриспруденция", 2, "ЮР-201")
        };

        // СОЗДАЕМ РЕПОЗИТОРИЙ
        StudentRepository repository = new StudentRepository(studentsArray);

        // ДЕМОНСТРИРУЕМ РАБОТУ РЕПОЗИТОРИЯ
        System.out.println("=== ДЕМОНСТРАЦИЯ РЕПОЗИТОРИЯ СТУДЕНТОВ ===");
        
        // 1. Показываем всех студентов
        System.out.println("\n1. ВСЕ СТУДЕНТЫ (" + repository.getStudentCount() + "):");
        printStudents(repository.getAllStudents());
        
        // 2. Ищем студентов по факультету
        System.out.println("\n2. СТУДЕНТЫ ФАКУЛЬТЕТА ИНФОРМАТИКА:");
        List<Student> informaticsStudents = repository.getStudentsByFaculty("Информатика");
        printStudents(informaticsStudents);
        
        // 3. Добавляем нового студента
        System.out.println("\n3. ДОБАВЛЯЕМ НОВОГО СТУДЕНТА:");
        Student newStudent = new Student(7, "Новиков", "Алексей", "Викторович",
                LocalDate.of(2001, 6, 10), "ул. Новая, 15", "+79169998877",
                "Информатика", 2, "ИВТ-202");
        repository.addStudent(newStudent);
        
        // 4. Показываем обновленный список
        System.out.println("\n4. ОБНОВЛЕННЫЙ СПИСОК (" + repository.getStudentCount() + "):");
        printStudents(repository.getAllStudents());
        
        // 5. Пробуем добавить студента с существующим ID
        System.out.println("\n5. ПЫТАЕМСЯ ДОБАВИТЬ СТУДЕНТА С СУЩЕСТВУЮЩИМ ID:");
        Student duplicateStudent = new Student(1, "Дубов", "Дмитрий", "Сергеевич",
                LocalDate.of(2000, 1, 1), "ул. Тестовая, 1", "+79160000000",
                "Экономика", 1, "ЭК-101");
        repository.addStudent(duplicateStudent);
        
        // 6. Удаляем студента
        System.out.println("\n6. УДАЛЯЕМ СТУДЕНТА С ID 2:");
        repository.removeStudent(2);
        
        // 7. Финальный список
        System.out.println("\n7. ФИНАЛЬНЫЙ СПИСОК (" + repository.getStudentCount() + "):");
        printStudents(repository.getAllStudents());
    }
    
    // Метод для красивого вывода студентов
    public static void printStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Нет студентов");
            return;
        }
        
        System.out.println("=".repeat(120));
        System.out.printf("%-3s %-12s %-12s %-12s %-15s %-10s%n",
            "ID", "Фамилия", "Имя", "Факультет", "Группа", "Курс");
        System.out.println("-".repeat(120));
        
        for (Student student : students) {
            System.out.printf("%-3d %-12s %-12s %-12s %-15s %-10d%n",
                student.getId(),
                student.getLastName(),
                student.getFirstName(), 
                student.getFaculty(),
                student.getGroup(),
                student.getCourse());
        }
        System.out.println("=".repeat(120));
    }
}