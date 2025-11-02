import java.util.ArrayList;
import java.util.List;

/**
 * Класс-репозиторий для управления меню хот-догов
 * РЕФАКТОРИНГ: Добавлен для централизованного управления ассортиментом
 */
public class HotDogRepository {
    private final List<HotDog> availableHotDogs;
    private final List<HotDogPart> availableParts;
    
    public HotDogRepository() {
        this.availableHotDogs = new ArrayList<>();
        this.availableParts = new ArrayList<>();
        initializeMenu();
    }
    
    /**
     * Инициализация стандартного меню
     * РЕФАКТОРИНГ: Вынесена в отдельный метод
     */
    private void initializeMenu() {
        // Добавляем стандартные хот-доги
        availableHotDogs.add(new HunterDog());
        availableHotDogs.add(new MasterDog());
        availableHotDogs.add(new Berlinka());
        
        // Добавляем стандартные компоненты
        availableParts.add(new HotDogPart("Булка", 30.0, 80));
        availableParts.add(new HotDogPart("Сосиска", 80.0, 100));
        availableParts.add(new HotDogPart("Соус", 20.0, 30));
    }
    
    // === Методы для работы с хот-догами ===
    
    public List<HotDog> getAvailableHotDogs() {
        return new ArrayList<>(availableHotDogs);
    }
    
    public boolean addHotDog(HotDog hotDog) {
        if (hotDog == null) {
            System.out.println("Error: Cannot add null hot dog");
            return false;
        }
        availableHotDogs.add(hotDog);
        System.out.println("Hot dog " + hotDog.getName() + " added to menu");
        return true;
    }
    
    public HotDog findHotDogByName(String name) {
        for (HotDog hotDog : availableHotDogs) {
            if (hotDog.getName().equalsIgnoreCase(name)) {
                return hotDog;
            }
        }
        return null;
    }
    
    // === Методы для работы с компонентами ===
    
    public List<HotDogPart> getAvailableParts() {
        return new ArrayList<>(availableParts);
    }
    
    public boolean addPart(HotDogPart part) {
        if (part == null) {
            System.out.println("Error: Cannot add null part");
            return false;
        }
        availableParts.add(part);
        System.out.println("Part " + part.getName() + " added to menu");
        return true;
    }
    
    public HotDogPart findPartByName(String name) {
        for (HotDogPart part : availableParts) {
            if (part.getName().equalsIgnoreCase(name)) {
                return part;
            }
        }
        return null;
    }
    
    /**
     * Получение информации о меню
     * РЕФАКТОРИНГ: Добавлен метод для просмотра всего ассортимента
     */
    public void printMenu() {
        System.out.println("\n=== HOT DOG MENU ===");
        
        System.out.println("Hot Dogs:");
        for (HotDog hotDog : availableHotDogs) {
            System.out.println("  - " + hotDog);
        }
        
        System.out.println("\nParts:");
        for (HotDogPart part : availableParts) {
            System.out.println("  - " + part);
        }
    }
}