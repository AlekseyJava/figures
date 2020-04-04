package net.school.windows.managers;

import net.school.windows.v4.base.WindowException;
import net.school.windows.v4.base.Window;

public class NamedManager<T> extends Manager {
    private String name;

    public NamedManager(Window window, String name) throws WindowException {
        super(window);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
