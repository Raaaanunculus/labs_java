import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс-репозиторий для управления коллекцией студентов
 * РЕФАКТОРИНГ: Добавлен для централизованного управления данными студентов
 */
public class StudentRepository {
   private final List<Student> students;
    
    public StudentRepository() {
        this.students = new ArrayList<>();
    }
    
    public StudentRepository(Student[] initialStudents) {
        this.students = new ArrayList<>();
        // РЕФАКТОРИНГ: Добавлена проверка на null
        if (initialStudents != null) {
            for (Student student : initialStudents) {
                if (student != null) {
                    this.students.add(student);
                }
            }
        }
    }
    
    /**
     * Добавление студента в коллекцию
     * РЕФАКТОРИНГ: Добавлена валидация данных
     */
    public boolean addStudent(Student student) {
        if (student == null) {
            System.out.println("Ошибка: Нельзя добавить пустого студента");
            return false;
        }
        
        // Проверяем уникальность ID
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Ошибка: Студент с ID " + student.getId() + " уже существует");
                return false;
            }
        }
        
        students.add(student);
        System.out.println("Студент " + student.getLastName() + " успешно добавлен");
        return true;
    }
    
    /**
     * Удаление студента по ID
     * РЕФАКТОРИНГ: Улучшена логика удаления с поиском по ID
     */
    public boolean removeStudent(int id) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }
        
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Студент с ID " + id + " успешно удален");
            return true;
        } else {
            System.out.println("Студент с ID " + id + " не найден");
            return false;
        }
    }
    
    /**
     * Получение всех студентов факультета
     * РЕФАКТОРИНГ: Используем Stream API для более читаемого кода
     */
    public List<Student> getStudentsByFaculty(String faculty) {
        return students.stream()
                .filter(student -> student.getFaculty().equalsIgnoreCase(faculty))
                .collect(Collectors.toList());
    }
    
    /**
     * Получение всех студентов
     * РЕФАКТОРИНГ: Возвращаем копию для защиты от внешних изменений
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
    
    /**
     * Получение количества студентов
     * РЕФАКТОРИНГ: Добавлен метод для получения размера коллекции
     */
    public int getStudentCount() {
        return students.size();
    }
}