package net.school.windows.v4.base;

public enum WindowErrorCode {

    WRONG_STATE("Ошибка передчи параметра"),    //При создании окна передается WindowState.DESTROYED или null.  При изменении состояния состояние устанавливается в null или окно, находящееся в WindowState.DESTROYED, переводится в иное состояние.
    WRONG_INDEX("Передан недопустимый индекс массива"),    //Передан недопустимый индекс для массива строк.
    EMPTY_ARRAY("Массив строк равен null"),  //Массив строк равен null.
    NULL_WINDOW("Попытка передачи null окна");

    private String errorString;

    WindowErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
