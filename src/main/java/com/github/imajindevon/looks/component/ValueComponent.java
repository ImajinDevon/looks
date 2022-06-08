package com.github.imajindevon.looks.component;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public abstract class ValueComponent implements Component {
    /**
     * Get the content of this component.
     * @return the content, or null
     */
    @NotNull
    public abstract String getContent();

    @Override
    @Contract("-> null")
    public Map<String, Object> getProperties() {
        return null;
    }

    /**
     * Throws an {@link UnsupportedOperationException} because this component only contains a value.
     */
    @Override
    @NotNull
    @Contract("-> fail")
    public String getName() {
        throw new UnsupportedOperationException("ValueComponent's cannot have a name");
    }

    @Override
    public <T> void applyProperty(@NotNull String name, @NotNull T value) {
        throw new UnsupportedOperationException("ValueComponent's cannot have properties");
    }
}
