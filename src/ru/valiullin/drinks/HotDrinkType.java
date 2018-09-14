package ru.valiullin.drinks;

/**
 * Типы горячих напитков
 */
public enum HotDrinkType implements DrinkType{
    GREEN_TEA("Зеленый чай", 25),
    BLACK_TEA("Черный чай", 25),
    AMERICANO("Американо", 40),
    CAPPUCINO("Капучино", 100);

    private final String name;
    private final double price;

    HotDrinkType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
