package ru.valiullin.exceptions;
import ru.valiullin.VendingMachine;

public class JamException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Купюра замялась! Возможно мятая купюра. Вставьте другую купюру.";
    }
}
