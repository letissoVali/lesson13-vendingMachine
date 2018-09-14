package ru.valiullin.drinks;

/**
 * Типы холодных напитков
 */
public enum ColdDrinkType implements DrinkType{
    COCA("Кока-кола", 60),
    PEPSI("Пепси-кола", 60),
    SPRITE("Спрайт", 40),
    FANTA("Фанта", 45);

    private final String name;
    private final double price;

    ColdDrinkType(String name, int price) {
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
