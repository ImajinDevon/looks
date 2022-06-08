package com.github.imajindevon.looks.component;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public interface Component {
    /**
     * Get the properties of this component.
     *
     * @return the properties, or null
     */
    @Nullable
    Map<String, Object> getProperties();

    /**
     * Get the name of this component.
     *
     * @return the name
     */
    @NotNull
    String getName();

    /**
     * Apply a property to this component.
     *
     * @param name  the property name
     * @param value the value
     * @param <T>   the type of the value
     */
    <T> void applyProperty(@NotNull String name, @NotNull T value);

    class Builder<T extends Component> {
        private final T component;

        /**
         * @param component the component instance
         */
        public Builder(@NotNull T component) {
            this.component = component;
        }

        /**
         * Apply a property to this component.
         *
         * @param name  the property name
         * @param value the value
         * @return this
         */
        @Contract("_, _ -> this")
        public Builder<T> withProperty(@NotNull String name, @NotNull Object value) {
            this.component.applyProperty(name, value);
            return this;
        }

        /**
         * Get the inner component.
         *
         * @return the component
         */
        @NotNull
        public T get() {
            return this.component;
        }
    }
}
