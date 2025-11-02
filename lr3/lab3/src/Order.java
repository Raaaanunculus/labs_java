import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий заказ в системе учета покупок
 * РЕФАКТОРИНГ: Интегрирован с HotDogRepository для работы с меню
 */
public class Order {
    private final List<HotDog> hotDogs;
    private final List<HotDogPart> parts;
    private final HotDogRepository repository; // РЕФАКТОРИНГ: Добавлена ссылка на репозиторий
    
    /**
     * РЕФАКТОРИНГ: Новый конструктор с репозиторием
     */
    public Order(HotDogRepository repository) {
        this.hotDogs = new ArrayList<>();
        this.parts = new ArrayList<>();
        this.repository = repository;
    }
    
    /**
     * РЕФАКТОРИНГ: Конструктор для обратной совместимости
     */
    public Order() {
        this.hotDogs = new ArrayList<>();
        this.parts = new ArrayList<>();
        this.repository = null;
    }
    
    /**
     * РЕФАКТОРИНГ: Добавить хот-дог по имени из меню
     */
    public boolean addHotDogByName(String hotDogName) {
        if (repository == null) {
            System.out.println("Error: Repository not initialized");
            return false;
        }
        
        HotDog hotDog = repository.findHotDogByName(hotDogName);
        if (hotDog != null) {
            hotDogs.add(hotDog);
            System.out.println("Hot dog '" + hotDogName + "' added to order");
            return true;
        } else {
            System.out.println("Error: Hot dog '" + hotDogName + "' not found in menu");
            return false;
        }
    }
    
    /**
     * РЕФАКТОРИНГ: Добавить компонент по имени из меню
     */
    public boolean addPartByName(String partName) {
        if (repository == null) {
            System.out.println("Error: Repository not initialized");
            return false;
        }
        
        HotDogPart part = repository.findPartByName(partName);
        if (part != null) {
            parts.add(part);
            System.out.println("Part '" + partName + "' added to order");
            return true;
        } else {
            System.out.println("Error: Part '" + partName + "' not found in menu");
            return false;
        }
    }
    
    // Старые методы сохранены для обратной совместимости
    public void addHotDog(HotDog hotDog) {
        if (hotDog != null) {
            hotDogs.add(hotDog);
        }
    }
    
    public void addPart(HotDogPart part) {
        if (part != null) {
            parts.add(part);
        }
    }
    
    public double getTotalPrice() {
        double total = 0;
        
        for (HotDog hotDog : hotDogs) {
            total += hotDog.getPrice();
        }
        
        for (HotDogPart part : parts) {
            total += part.getPrice();
        }
        
        return total;
    }
    
    public int getFullOrderCount() {
        return hotDogs.size();
    }
    
    public double getAverageOrderPrice() {
        int totalItems = hotDogs.size() + parts.size();
        if (totalItems == 0) return 0;
        return getTotalPrice() / totalItems;
    }
    
    /**
     * РЕФАКТОРИНГ: Геттеры для доступа к содержимому заказа
     */
    public List<HotDog> getHotDogs() {
        return new ArrayList<>(hotDogs);
    }
    
    public List<HotDogPart> getParts() {
        return new ArrayList<>(parts);
    }
    
    public int getTotalItems() {
        return hotDogs.size() + parts.size();
    }
    
    /**
     * РЕФАКТОРИНГ: Улучшенный вывод информации
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ORDER ===\n");
        
        if (!hotDogs.isEmpty()) {
            sb.append("Hot dogs:\n");
            for (HotDog hotDog : hotDogs) {
                sb.append("  - ").append(hotDog).append("\n");
            }
        }
        
        if (!parts.isEmpty()) {
            sb.append("Parts:\n");
            for (HotDogPart part : parts) {
                sb.append("  - ").append(part).append("\n");
            }
        }
        
        sb.append(String.format("Total: %.2f rub\n", getTotalPrice()));
        sb.append(String.format("Full orders: %d\n", getFullOrderCount()));
        sb.append(String.format("Total items: %d\n", getTotalItems()));
        sb.append(String.format("Average price: %.2f rub", getAverageOrderPrice()));
        
        return sb.toString();
    }
    
    /**
     * Главный метод демонстрационного приложения
     * РЕФАКТОРИНГ: Обновлен для работы с репозиторием
     */
    public static void main(String[] args) {
        // РЕФАКТОРИНГ: Создаем репозиторий
        HotDogRepository repository = new HotDogRepository();
        
        // Создаем заказ с привязкой к репозиторию
        Order order = new Order(repository);
        
        System.out.println("=== DEMONSTRATING REPOSITORY WORK ===");
        
        // РЕФАКТОРИНГ: Показываем меню
        repository.printMenu();
        
        // Добавляем товары по имени из меню
        order.addHotDogByName("Hunter Dog");
        order.addHotDogByName("Master Dog");
        order.addHotDogByName("Berlinka");
        
        // Добавляем компоненты по имени из меню
        order.addPartByName("Булка");
        order.addPartByName("Сосиска");
        order.addPartByName("Соус");
        
        // Пробуем добавить несуществующий товар
        order.addHotDogByName("Non-existent Hot Dog");
        order.addPartByName("Non-existent Part");
        
        // Выводим информацию о заказе
        System.out.println("\n" + order);
        
        // РЕФАКТОРИНГ: Демонстрация работы с меню
        System.out.println("\n=== MENU OPERATIONS ===");
        
        // Добавляем новый хот-дог в меню
        repository.addHotDog(new HotDog("Cheese Dog", 220.0) {});
        
        // Добавляем новый компонент в меню
        repository.addPart(new HotDogPart("Cheese", 45.0, 40));
        
        // Показываем обновленное меню
        repository.printMenu();
    }
}