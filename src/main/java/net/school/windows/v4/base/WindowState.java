package net.school.windows.v4.base;

public enum WindowState {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE"),
    DESTROYED("DESTROYED");

    private String stateString;

    WindowState(String stateString) {
        this.stateString = stateString;
    }

    public static WindowState fromString(String stateString) throws WindowException {
        try {
            return WindowState.valueOf(stateString);
        } catch (IllegalArgumentException ex) {
            throw new WindowException(WindowErrorCode.WRONG_STATE);
        }
    }
}
