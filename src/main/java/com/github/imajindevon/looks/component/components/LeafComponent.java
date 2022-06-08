package com.github.imajindevon.looks.component.components;

import com.github.imajindevon.looks.component.Component;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LeafComponent implements Component {
    private final String name;
    private final Map<String, Object> properties;

    /**
     * Create a new LeafComponent with the given name, and a new {@link HashMap} with an initial capacity of 0.
     *
     * @param name the name of the component
     */
    public LeafComponent(@NotNull String name) {
        this(name, new HashMap<>(0));
    }

    /**
     * Create a new LeafComponent with the given parameters.
     *
     * @param name       the name of the component
     * @param properties the properties of the component
     */
    public LeafComponent(@NotNull String name, @NotNull Map<String, Object> properties) {
        this.name = name;
        this.properties = properties;
    }

    @Override
    @NotNull
    public Map<String, Object> getProperties() {
        return this.properties;
    }

    @Override
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override
    public <T> void applyProperty(@NotNull String name, @NotNull T value) {
        this.properties.put(name, value);
    }
}
