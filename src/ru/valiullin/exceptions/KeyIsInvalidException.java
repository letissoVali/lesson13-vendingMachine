package ru.valiullin.exceptions;

public class KeyIsInvalidException extends HumanFactorException {
    @Override
    public String getMessage() {
        return "Ошибка ввода номера товара! Такого товара нет! Выбирите товар из спика!";
    }
}
