/**
 * Демонстрационный класс
 */
public class TextDemo {
    public static void main(String args[]) {
        // Создание текста
        Text story = new Text("Приключения в Java-мире");
        
        // Создание и добавление абзацев
        story.addParagraph(new Paragraph("Однажды в далекой-далекой галактике..."));
        story.addParagraph("программист изучал объектно-ориентированное программирование.");
        story.addParagraph("Он создавал классы, наследовал их и переопределял методы.");
        story.addParagraph("И жил он долго и счастливо, создавая качественный код!");
        
        System.out.println("========== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССОВ ==========\n");
        
        // Вызов методов из задания
        System.out.println("1. ОСНОВНЫЕ МЕТОДЫ:");
        story.printTitle();
        story.printText();
        
        // Демонстрация toString()
        System.out.println("\n2. МЕТОД TOSTRING():");
        System.out.println("   " + story.toString());
        
        // Демонстрация equals() и hashCode() - ИСПРАВЛЕННАЯ
        System.out.println("\n3. СРАВНЕНИЕ ОБЪЕКТОВ:");
        Text story2 = new Text("Приключения в Java-мире");
        story2.addParagraph("Однажды в далекой-далекой галактике...");
        story2.addParagraph("программист изучал объектно-ориентированное программирование.");
        story2.addParagraph("Он создавал классы, наследовал их и переопределял методы.");
        story2.addParagraph("И жил он долго и счастливо, создавая качественный код!");
        
        Text differentStory = new Text("Совсем другая история");
        differentStory.addParagraph("В некотором царстве, в некотором государстве...");
        
        System.out.println("    Сравнение одинаковых текстов: " + 
                          (story.equals(story2) ? "ОБЪЕКТЫ РАВНЫ" : "объекты разные"));
        System.out.println("    Сравнение разных текстов: " + 
                          (story.equals(differentStory) ? "объекты равны" : "ОБЪЕКТЫ РАЗНЫЕ"));
        
        System.out.println("\n4. ХЭШ-КОДЫ ОБЪЕКТОВ:");
        System.out.println("    История 1: " + story.hashCode());
        System.out.println("    История 2: " + story2.hashCode() + 
                         " (должен совпадать с Историей 1)");
        System.out.println("    Другая история: " + differentStory.hashCode() + 
                         " (должен отличаться от Истории 1)");
        
        // Демонстрация работы с отдельными абзацами
        System.out.println("\n5. РАБОТА С ОТДЕЛЬНЫМИ АБЗАЦАМИ:");
        if (story.getParagraphCount() > 0) {
            Paragraph firstParagraph = story.getParagraphs().get(0);
            System.out.println("    Первый абзац: " + firstParagraph.toString());
            System.out.println("    Содержимое: " + firstParagraph.getContent());
            
            // Изменим содержимое абзаца
            firstParagraph.setContent("Однажды в солнечный день...");
            System.out.println("    Новое содержимое: " + firstParagraph.getContent());
        }
        
        // Покажем обновленный текст
        System.out.println("\n6. ОБНОВЛЕННЫЙ ТЕКСТ:");
        story.printText();
        
        // Добавим еще один абзац
        System.out.println("\n7. ДОБАВЛЕНИЕ НОВОГО АБЗАЦА:");
        story.addParagraph("И все они жили долго и счастливо, программируя на Java!");
        story.printText();
        
        System.out.println("\n========== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ==========");
    }
}
