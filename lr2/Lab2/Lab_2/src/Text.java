import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс Текст
 */
public class Text {
    private String title;
    private final List<Paragraph> paragraphs;
    
    public Text(String title) {
        this.title = title;
        this.paragraphs = new ArrayList<>(); //Инициализация пустого списка абзацев
    }
    
    /**
     * Метод для дополнения текста новым абзацем
     */
    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
    }
    
    /**
     * Метод для дополнения текста строкой (создает новый абзац)
     */
    public void addParagraph(String content) {
        paragraphs.add(new Paragraph(content));
    }
    
    /**
     * Вывести текст на консоль
     */
    public void printText() {
        System.out.println("=== " + title + " ===");
        for (int i = 0; i < paragraphs.size(); i++) {
            System.out.println((i + 1) + ". " + paragraphs.get(i).getContent());
        }
    }
    
    /**
     * Вывести заголовок текста на консоль
     */
    public void printTitle() {
        System.out.println("Заголовок текста: " + title);
    }
    
    // Переопределение стандартных методов
    @Override//аннотация в Java, которая указывает компилятору, что следующий метод переопределяет метод из родительского класса или реализует метод из интерфейса.
    public String toString() {
        return "Текст{заголовок='" + title + "', количествоАбзацев=" + paragraphs.size() + "}";
    }
    
    @Override
    public boolean equals(Object obj) { //проверяет, одинаковы ли два объекта Text.
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Text text = (Text) obj;
        return Objects.equals(title, text.title) && 
               Objects.equals(paragraphs, text.paragraphs);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(title, paragraphs);
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public List<Paragraph> getParagraphs() {
        return new ArrayList<>(paragraphs); // возвращаем копию для безопасности
    }
    
    public int getParagraphCount() {
        return paragraphs.size();
    }
}
