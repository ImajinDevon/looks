package com.github.imajindevon.looks.component.components;

import com.github.imajindevon.looks.component.ValueComponent;
import org.jetbrains.annotations.NotNull;

public class StringComponent extends ValueComponent {
    private final String content;

    /**
     * Create a new StringComponent with an empty string.
     */
    public StringComponent() {
        this("");
    }

    /**
     * Create a new StringComponent with the given value.
     *
     * @param content the value of this component
     * @param <T>  the type of the value
     */
    public <T> StringComponent(@NotNull T content) {
        this(content.toString());
    }

    /**
     * Create a new StringComponent with the given value.
     * @param content the value of this component
     */
    public StringComponent(@NotNull String content) {
        this.content = content;
    }

    @Override
    @NotNull
    public String getContent() {
        return this.content;
    }
}
