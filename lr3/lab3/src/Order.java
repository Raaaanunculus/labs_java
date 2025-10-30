import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий заказ в системе учета покупок
 * Содержит коллекции хот-догов и компонентов, а также методы для работы с заказом
 */
public class Order {
    // Список целых хот-догов в заказе (неизменяемая ссылка)
    private final List<HotDog> hotDogs;
    // Список отдельных компонентов в заказе (неизменяемая ссылка)
    private final List<HotDogPart> parts;
    
    /**
     * Конструктор заказа
     * Инициализирует пустые списки для хот-догов и компонентов
     */
    public Order() {
        this.hotDogs = new ArrayList<>();
        this.parts = new ArrayList<>();
    }
    
    /**
     * Добавить хот-дог в заказ
     * @param hotDog объект хот-дога для добавления
     */
    public void addHotDog(HotDog hotDog) {
        hotDogs.add(hotDog);
    }
    
    /**
     * Добавить компонент в заказ
     * @param part объект компонента для добавления
     */
    public void addPart(HotDogPart part) {
        parts.add(part);
    }
    
    /**
     * Рассчитать общую стоимость заказа
     * Суммирует цены всех хот-догов и компонентов
     * @return общая стоимость заказа в рублях
     */
    public double getTotalPrice() {
        double total = 0;
        
        // Суммируем цены всех хот-догов
        for (HotDog hotDog : hotDogs) {
            total += hotDog.getPrice();
        }
        
        // Суммируем цены всех компонентов
        for (HotDogPart part : parts) {
            total += part.getPrice();
        }
        
        return total;
    }
    
    /**
     * Получить количество полных заказов (целых хот-догов)
     * @return количество целых хот-догов в заказе
     */
    public int getFullOrderCount() {
        return hotDogs.size();
    }
    
    /**
     * Рассчитать среднюю стоимость одного элемента заказа
     * Делит общую стоимость на общее количество элементов
     * @return средняя стоимость элемента заказа в рублях
     */
    public double getAverageOrderPrice() {
        int totalItems = hotDogs.size() + parts.size();
        if (totalItems == 0) return 0; // Защита от деления на ноль
        return getTotalPrice() / totalItems;
    }
    
    // === Фабричные методы для создания компонентов ===
    
    /**
     * Создать объект булки для хот-дога
     * @return объект булки с фиксированными параметрами
     */
    public HotDogPart createBun() {
        return new HotDogPart("Булка", 30.0, 80);
    }
    
    /**
     * Создать объект сосиски для хот-дога
     * @return объект сосиски с фиксированными параметрами
     */
    public HotDogPart createSausage() {
        return new HotDogPart("Сосиска", 80.0, 100);
    }
    
    /**
     * Создать объект соуса для хот-дога
     * @return объект соуса с фиксированными параметрами
     */
    public HotDogPart createSauce() {
        return new HotDogPart("Соус", 20.0, 30);
    }
    
    /**
     * Преобразование заказа в строку для вывода
     * Форматирует информацию о заказе в читаемом виде
     * @return строковое представление заказа
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ЗАКАЗ ===\n");
        
        // Вывод списка хот-догов, если они есть
        if (!hotDogs.isEmpty()) {
            sb.append("Хот-доги:\n");
            for (HotDog hotDog : hotDogs) {
                sb.append("  - ").append(hotDog).append("\n");
            }
        }
        
        // Вывод списка компонентов, если они есть
        if (!parts.isEmpty()) {
            sb.append("Компоненты:\n");
            for (HotDogPart part : parts) {
                sb.append("  - ").append(part).append("\n");
            }
        }
        
        // Вывод итоговой информации
        sb.append(String.format("Итого: %.2f руб.\n", getTotalPrice()));
        sb.append(String.format("Полных заказов: %d\n", getFullOrderCount()));
        sb.append(String.format("Средняя стоимость: %.2f руб.", getAverageOrderPrice()));
        
        return sb.toString();
    }
    
    /**
     * Главный метод демонстрационного приложения
     * Создает заказ, добавляет товары и выводит результаты
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создаем новый заказ
        Order order = new Order();
        
        // Продаем каждый вид хот-дога 
        order.addHotDog(new HunterDog());
        order.addHotDog(new MasterDog());
        order.addHotDog(new Berlinka());
        
        // Продаем компоненты отдельно 
        order.addPart(order.createBun());
        order.addPart(order.createSausage());
        order.addPart(order.createSauce());
        order.addPart(order.createBun()); // Еще одна булка
        
        // Выводим полную информацию о заказе
        System.out.println(order);
        
        // Выводим отдельную статистику 
        System.out.println("\n=== СТАТИСТИКА ===");
        System.out.printf("Общая сумма всех заказов: %.2f руб.\n", order.getTotalPrice());
        System.out.printf("Количество полных заказов: %d\n", order.getFullOrderCount());
        System.out.printf("Средняя стоимость заказов: %.2f руб.\n", order.getAverageOrderPrice());
    }
}