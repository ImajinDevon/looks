package com.github.imajindevon.looks.serialization;

import com.github.imajindevon.looks.component.Component;
import com.github.imajindevon.looks.component.ParentComponent;
import com.github.imajindevon.looks.component.ValueComponent;
import com.github.imajindevon.looks.component.components.ContainerComponent;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public final class HtmlSerializer {
    private HtmlSerializer() {
    }

    private static void serializeComponent(@NotNull StringBuilder builder, @NotNull Component component) {
        if (component instanceof ValueComponent valueComponent) {
            builder.append(valueComponent.getContent());
            return;
        }

        builder.append("<%s".formatted(component.getName()));

        if (null != component.getProperties()) {
            for (Map.Entry<String, Object> entry : component.getProperties().entrySet()) {
                builder.append(" %s=\"%s\"".formatted(entry.getKey(), entry.getValue()));
            }
        }
        builder.append('>');

        if (component instanceof ParentComponent parent) {
            for (Component child : parent.getChildren()) {
                serializeComponent(builder, child);
            }
        }
        builder.append("</%s>".formatted(component.getName()));
    }

    /**
     * Format the provided component(s) into valid HTML.
     *
     * @param root the root component
     * @return the serialized contents
     */
    @NotNull
    public static String format(@NotNull ContainerComponent root) {
        StringBuilder builder = new StringBuilder("<!DOCTYPE html>");

        for (Component child : root.getChildren()) {
            serializeComponent(builder, child);
        }
        return builder.toString();
    }
}
