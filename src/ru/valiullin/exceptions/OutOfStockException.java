package ru.valiullin.exceptions;

public class OutOfStockException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Товара нет! Товар закончился. Выбирите другой или позвоните для пополнения корзины!";
    }
}
