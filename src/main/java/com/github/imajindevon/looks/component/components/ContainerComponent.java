package com.github.imajindevon.looks.component.components;

import com.github.imajindevon.looks.component.Component;
import com.github.imajindevon.looks.component.ParentComponent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainerComponent implements ParentComponent {
    private final List<Component> children;
    private final Map<String, Object> properties;

    private final String name;

    /**
     * Create a new ContainerComponent with {@code children} as an ArrayList with an initial capacity of 5, and
     * {@code properties} parameter as a {@link HashMap} with an initial capacity of 0.
     *
     * @param name the name of the section
     */
    public ContainerComponent(@NotNull String name) {
        this(name, new ArrayList<>(5), new HashMap<>(0));
    }

    /**
     * Create a new ContainerComponent with the given parameters.
     *
     * @param name       the name of the section
     * @param children   the children components
     * @param properties the properties of the section
     */
    public ContainerComponent(
        @NotNull String name, @NotNull List<Component> children, @NotNull Map<String, Object> properties
    ) {
        this.name = name;
        this.children = children;
        this.properties = properties;
    }

    @Override
    public void addChild(@NotNull Component child) {
        this.children.add(child);
    }

    @Override
    @NotNull
    public List<Component> getChildren() {
        return this.children;
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

    /**
     * Create a new ContainerComponent that contains a value component.
     * (e.g) {@code <a>hello</a>}
     *
     * @param name the name
     * @param value the value
     *
     * @return the new ContainerComponent
     */
    @Contract("_, _, -> new")
    public static ContainerComponent construct(@NotNull String name, @NotNull Object value) {
        return new ParentComponent.Builder<>(new ContainerComponent(name))
                   .addChild(new StringComponent(value))
                   .get();
    }
}