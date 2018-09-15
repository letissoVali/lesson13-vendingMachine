import ru.valiullin.VendingMachine;
import ru.valiullin.drinks.DrinkType;
import ru.valiullin.exceptions.HumanFactorException;
import ru.valiullin.exceptions.JamException;
import ru.valiullin.exceptions.OutOfStockException;

import java.util.Scanner;

public class Main {
    private static VendingMachine vm = new VendingMachine();

    public static void main(String[] args) {

        System.out.println("Наши напитки: ");
        for (String line : vm.getDrinkTypes()) {
            System.out.println(line);
        }

        Scanner scan = new Scanner(System.in);
        printHelp();
        while (scan.hasNext()) {
            String command = scan.next();
            switch (command) {
                case "add": {
                    int money = scan.nextInt();
                    processAddMoney(money);
                    break;
                }
                case "get": {
                    int key = scan.nextInt();
                    processGetDrink(key);
                    break;
                }
                case "end": {
                    processEnd();
                    return;
                }
                default:
                    System.out.println("Команда не определена");
            }
            scan.nextLine();
        }
    }

    /**
     * обработка добавления денег в автомат
     * @param money - сумма
     */
    private static void processAddMoney(int money) {
        // TODO: добавить обработку исключительной ситуации - замятия
        vm.addMoney(money);
        /*try {
            double jam = Math.random();
            if(jam < 0.3) {
                throw new JamException();
            } else {
                System.out.println("Текущий баланс: " + vm.addMoney(money));
            }
        } catch (JamException jamEx) {
            System.out.println(jamEx.getMessage() + " Заберите Ваши " + money + " у.е., они нам не нравятся!");
        }*/
    }

    /**
     * обработка получения напитка
     * @param key - код напитка в автомате
     */
    private static void processGetDrink(int key) {
        // TODO: обработать все возможные исключения
        try {
            DrinkType drinkType = vm.giveMeADrink(key);
            if (drinkType != null) {
                System.out.println("Ммм! " + drinkType.getName() + "!");
            } else {
                System.out.println("Напиток почему-то не получен...");
            }
        } catch (HumanFactorException humanFactorEx){
            System.out.println(humanFactorEx.getMessage());
        } catch (OutOfStockException outOfStockEx) {
            System.out.println(outOfStockEx.getMessage());
        }
    }

    /**
     * обработка получения сдачи
     */
    private static void processEnd() {
        System.out.println("Ваша сдача: " + vm.getChange());
    }

    /**
     * выводит подсказку по доступным командам
     */
    private static void printHelp() {
        System.out.println( "Введите 'add <количество>' для добавления купюр" );
        System.out.println( "Введите 'get <код напитка>' для получения напитка" );
        System.out.println( "Введите 'end' для получения сдачи" );
    }
}
