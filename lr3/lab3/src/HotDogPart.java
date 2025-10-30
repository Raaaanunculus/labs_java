/**
 * Класс, представляющий отдельный компонент хот-дога
 * Может продаваться отдельно от целых хот-догов
 */
public class HotDogPart {
    // Название компонента
    protected String name;
    // Цена компонента в рублях
    protected double price;
    // Вес компонента в граммах
    protected int weight;
    
    /**
     * Конструктор компонента хот-дога
     * @param name название компонента
     * @param price цена компонента
     * @param weight вес компонента в граммах
     */
    public HotDogPart(String name, double price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
    
    /**
     * Получить название компонента
     * @return название компонента
     */
    public String getName() {
        return name;
    }
    
    /**
     * Получить цену компонента
     * @return цена компонента
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Получить вес компонента
     * @return вес компонента в граммах
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * Преобразование компонента в строку для вывода
     * @return строковое представление компонента
     */
    @Override
    public String toString() {
        return String.format("%s (%dg) - %.2f руб.", name, weight, price);
    }
}