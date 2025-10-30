/**
 * Абстрактный класс, представляющий базовый хот-дог
 * Содержит общие свойства и методы для всех видов хот-догов
 */
public abstract class HotDog {
    // Название хот-дога
    protected String name;
    // Цена хот-дога в рублях
    protected double price;

    /**
     * Конструктор хот-дога
     * @param name название хот-дога
     * @param price цена хот-дога
     */
    public HotDog(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Получить название хот-дога
     * @return название хот-дога
     */
    public String getName() {
        return name;
    }

    /**
     * Получить цену хот-дога
     * @return цена хот-дога
     */
    public double getPrice() {
        return price;
    }

    /**
     * Преобразование хот-дога в строку для вывода
     * @return строковое представление хот-дога
     */
    @Override
    public String toString() {
        return String.format("%s - %.2f руб.", name, price);
    }
}