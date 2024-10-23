package exeptions;

public class DateFormEx extends AssertionError {
    public DateFormEx(String textBirhday) {
        super(String.format("Формат даты: %s неверный. Должен быть формат ДД.ММ.ГГГГ", textBirhday));
    }
}
