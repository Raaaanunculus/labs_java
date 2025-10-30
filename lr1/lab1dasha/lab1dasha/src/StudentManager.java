import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private Student[] students;

    // Конструктор инициализирует поле students переданным массивом)
    public StudentManager(Student[] students) {
        this.students = students;
    }

    // Позволяет другим классам получить доступ к данным студентов, но не изменять их напрямую
    public Student[] getStudents() { return students; }
    
    // Сеттер для установки массива студентов
    public void setStudents(Student[] students) { this.students = students; }

    // Позволяет полностью заменить массив студентов на новый
    public Student[] getStudentsByFaculty(String faculty) {
        return Arrays.stream(students)
                .filter(student -> student.getFaculty().equalsIgnoreCase(faculty))
                .toArray(Student[]::new);
    }

    // Группировка студентов по факультетам и курсам
    public Map<String, Map<Integer, Student[]>> getStudentsByFacultyAndCourse() {
        Map<String, Map<Integer, Student[]>> result = new HashMap<>();
        
        for (Student student : students) {
            String faculty = student.getFaculty();
            int course = student.getCourse();
            
            // Создаем структуру если ее нет
            result.putIfAbsent(faculty, new HashMap<>());
            result.get(faculty).putIfAbsent(course, new Student[0]);
            
            // Добавляем студента в массив
            Student[] current = result.get(faculty).get(course);
            Student[] updated = Arrays.copyOf(current, current.length + 1);
            updated[current.length] = student;
            result.get(faculty).put(course, updated);
        }
        
        return result;
    }

    // Получить студентов родившихся после указанного года
    public Student[] getStudentsBornAfterYear(int year) {
        return Arrays.stream(students)
                .filter(student -> student.getBirthDate().getYear() > year)
                .toArray(Student[]::new);
    }

    // Получить студентов определенной группы
    public Student[] getStudentsByGroup(String group) {
        return Arrays.stream(students)
                .filter(student -> student.getGroup().equalsIgnoreCase(group))
                .toArray(Student[]::new);
    }

    // Получить студентов в алфавитном порядке
    public Student[] getStudentsInAlphabeticalOrder() {
        Student[] sortedStudents = students.clone();
        Arrays.sort(sortedStudents, Comparator.comparing(Student::getLastName)
                .thenComparing(Student::getFirstName)
                .thenComparing(Student::getMiddleName));
        return sortedStudents;
    }

    // Вывод списка студентов в табличном формате
    public static void printStudents(Student[] students, String title) {
        System.out.println("\n" + title + ":");
        System.out.println("=".repeat(120));
        // Заголовок таблицы
        System.out.printf("%-3s %-12s %-12s %-12s %-12s %-20s %-15s %-15s %-2s %-8s%n",
            "ID", "Фамилия", "Имя", "Отчество", "Дата рожд.", "Адрес", 
            "Телефон", "Факультет", "К", "Группа");
        System.out.println("-".repeat(120));
        
        // Если студентов нет - сообщение
        if (students.length == 0) {
            System.out.println("Нет студентов, соответствующих критерию.");
        } else {
            // Вывод каждого студента
            for (Student student : students) {
                System.out.println(student);
            }
        }
        System.out.println("=".repeat(120));
        System.out.println("Найдено студентов: " + students.length);
    }

    // Вывод студентов с группировкой по факультетам и курсам
    public void printStudentsByFacultyAndCourse() {
        Map<String, Map<Integer, Student[]>> data = getStudentsByFacultyAndCourse();
        
        System.out.println("\nСТУДЕНТЫ ПО ФАКУЛЬТЕТАМ И КУРСАМ:");
        System.out.println("=".repeat(120));
        
        // Перебор всех факультетов
        for (String faculty : data.keySet()) {
            System.out.println("\nФАКУЛЬТЕТ: " + faculty.toUpperCase());
            System.out.println("-".repeat(60));
            
            // Перебор всех курсов на факультете
            Map<Integer, Student[]> courses = data.get(faculty);
            for (Integer course : courses.keySet()) {
                System.out.println("КУРС " + course + ":");
                printStudents(courses.get(course), "");
            }
        }
    }
}