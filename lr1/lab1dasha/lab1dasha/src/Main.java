import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
      
        // Создаем массив студентов с тестовыми данными
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

        // Создаем менеджер для работы со студентами
        StudentManager manager = new StudentManager(studentsArray);

        // Выводим всех студентов
        System.out.println("ВСЕ СТУДЕНТЫ:");
        System.out.println("=".repeat(120));
        System.out.printf("%-3s %-12s %-12s %-12s %-12s %-20s %-15s %-15s %-2s %-8s%n",
            "ID", "Фамилия", "Имя", "Отчество", "Дата рожд.", "Адрес", 
            "Телефон", "Факультет", "К", "Группа");
        System.out.println("-".repeat(120));
        for (Student student : studentsArray) {
            System.out.println(student);
        }
        System.out.println("=".repeat(120));

        // Получаем и выводим студентов факультета Информатика
        Student[] informaticsStudents = manager.getStudentsByFaculty("Информатика");
        StudentManager.printStudents(informaticsStudents, "СТУДЕНТЫ ФАКУЛЬТЕТА ИНФОРМАТИКА");
 
        // Выводим студентов с группировкой по факультетам и курсам
        manager.printStudentsByFacultyAndCourse();

        // Получаем и выводим студентов, родившихся после 2000 года
        Student[] bornAfter2000 = manager.getStudentsBornAfterYear(2000);
        StudentManager.printStudents(bornAfter2000, "СТУДЕНТЫ, РОДИВШИЕСЯ ПОСЛЕ 2000 ГОДА");

        // Получаем и выводим студентов группы ИВТ-301
        Student[] groupIVT301 = manager.getStudentsByGroup("ИВТ-301");
        StudentManager.printStudents(groupIVT301, "СТУДЕНТЫ ГРУППЫ ИВТ-301");

        // Получаем и выводим студентов в алфавитном порядке
        Student[] alphabetical = manager.getStudentsInAlphabeticalOrder();
        StudentManager.printStudents(alphabetical, "СТУДЕНТЫ В АЛФАВИТНОМ ПОРЯДКЕ");
    }
}