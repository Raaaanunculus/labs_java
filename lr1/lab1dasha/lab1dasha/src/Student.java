import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    // Поля класса - информация о студенте
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    // Конструктор - создает нового студента со всеми данными
    public Student(int id, String lastName, String firstName, String middleName, 
                  LocalDate birthDate, String address, String phone, 
                  String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    // Геттеры - методы для получения значений полей
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getFaculty() { return faculty; }
    public int getCourse() { return course; }
    public String getGroup() { return group; }

    // Сеттеры - методы для изменения значений полей
    public void setId(int id) { this.id = id; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setFaculty(String faculty) { this.faculty = faculty; }
    public void setCourse(int course) { this.course = course; }
    public void setGroup(String group) { this.group = group; }

    // Метод для красивого вывода информации о студенте
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return String.format(
            "%-3d %-12s %-12s %-12s %-12s %-20s %-15s %-15s %-2d %-8s",
            id, 
            lastName, 
            firstName, 
            middleName,
            birthDate.format(formatter), // Форматируем дату в красивый вид
            address.length() > 20 ? address.substring(0, 17) + "..." : address, // Обрезаем длинный адрес
            phone,
            faculty,
            course,
            group
        );
    }
}