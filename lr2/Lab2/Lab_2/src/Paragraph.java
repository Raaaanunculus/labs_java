/**
 * Класс Абзац
 */
public class Paragraph {
    private String content; // Поле для хранения текстового содержимого абзаца
    
    public Paragraph() {
        this.content = "";
    }
    
    public Paragraph(String content) { //Конструктор с параметром - создает абзац с заданным содержимым
        this.content = content;
    }
    
    // Методы доступа
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    // Переопределение стандартных методов
    @Override
    public String toString() {
        return "Абзац{содержимое='" + content + "'}";
    }
     //сравниваем два абзаца на равенство
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Paragraph paragraph = (Paragraph) obj;
        return content.equals(paragraph.content);
    }
    
    @Override
    public int hashCode() {
        return content.hashCode(); //Возвращает хэш-код абзаца на основе его содержимого(Хэш-код - это целое число, которое представляет объект в сжатом виде.)
    }
}
