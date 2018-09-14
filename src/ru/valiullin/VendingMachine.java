package ru.valiullin;

import ru.valiullin.drinks.ColdDrinkType;
import ru.valiullin.drinks.DrinkType;
import ru.valiullin.drinks.HotDrinkType;
import ru.valiullin.drinks.Product;
import ru.valiullin.exceptions.HumanFactorException;
import ru.valiullin.exceptions.KeyIsInvalidException;
import ru.valiullin.exceptions.NotEnoughMoneyException;

/**
 * Торговый автомат
 */
public class VendingMachine {
    private double money = 0;
    private Product[] drinks = new Product[]{
            new Product(ColdDrinkType.COCA, 1),
            new Product(ColdDrinkType.PEPSI, 1),
            new Product(ColdDrinkType.SPRITE, 1),
            new Product(ColdDrinkType.FANTA, 3),
            new Product(HotDrinkType.GREEN_TEA, 10),
            new Product(HotDrinkType.BLACK_TEA, 10),
            new Product(HotDrinkType.AMERICANO, 10),
            new Product(HotDrinkType.CAPPUCINO, 10)
    };

    /**
     * Добавление купюр в автомат
     *
     * @param money - сумма внесенных купюр
     * @return текущий остаток
     */
    //  TODO: Вывести из кода торгового аппарата и связанных с ним классов работу с консолью. (Необязательно, создам единый исходный шаблон позже)
    //  TODO: В случае выбора несуществующего товара выбрасывать соответствующую ошибку.
    //  TODO: В случае недостаточного количества средств тоже. Товар не выдавать!
    //  TODO: Инсценировать замятие купюры с некоторой вероятностью события. В обработчике ошибки выдать клиенту ровно столько денег, сколько было «замято»

    public double addMoney(double money) {
        this.money += money;
        return this.money;
    }

    /**
     * Получает из автомата выбранный напиток
     *
     * В методе есть проверка корректности кода напитка, проверка остатков данного продукта
     * и достаточно ли денег чтобы его купить. В случае ошибок выбрасывать соответствующее исключение
     *
     * @param key код продукта
     * @return напиток;
     */
    public DrinkType giveMeADrink(int key) throws HumanFactorException {
        if (!isKeyValid(key)) {
            // TODO: возвращать соответствующую ошибку
            throw new KeyIsInvalidException();
            // Неправильный код товара - товар не возвращается
            //return null;
        }

        Product selected = drinks[key];
        if (!isMoneyEnough(selected)) {
            // TODO: возвращать соответствующую ошибку
            throw new NotEnoughMoneyException();
            // Нехватает денег - товар не возвращается
            //return null;
        }

        DrinkType drink = selected.take();
        money -= drink.getPrice();
        return drink;
    }

    /**
     * Формирует список товаров
     *
     * @return строки с информацией о товаре
     */
    public String[] getDrinkTypes() {
        String[] result = new String[drinks.length];
        for (int i = 0; i < drinks.length; i++) {
            result[i] = String.format("%d - %12s: %6.2f руб", i, drinks[i].getName(),drinks[i].getPrice());
        }
        return result;
    }

    /**
     * Проверка что хватает денег на выбранный напиток
     *
     * @param selected - выбранный напиток
     * @return true если денег хватает, иначе - false
     */
    private boolean isMoneyEnough(Product selected) {
        return money >= selected.getPrice();
    }

    /**
     * Проверка что выбрали существующий тип напитка
     * Не проверяет остаток, только границы массива
     *
     * @param key номер напитка
     * @return true если есть напиток с таким номером, иначе false
     */
    private boolean isKeyValid(int key) {
        return key >=0 && key < drinks.length;
    }

    /**
     * Выдать сдачу.
     * Количество введеных купюр обнуляется
     *
     * @return остаток
     */
    public double getChange() {
        double money = this.money;
        this.money = 0;
        return money;
    }
}
