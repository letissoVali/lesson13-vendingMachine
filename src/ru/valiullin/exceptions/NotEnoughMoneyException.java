package ru.valiullin.exceptions;

public class NotEnoughMoneyException extends HumanFactorException {
    @Override
    public String getMessage() {
        return "Не достаточно денег. Вставьте дополнительные купюры.";
    }
}
