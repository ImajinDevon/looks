package com.github.imajindevon.looks.component;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ParentComponent extends Component {
    /**
     * Add a child component to this component.
     *
     * @param child the child component
     */
    void addChild(@NotNull Component child);

    /**
     * Get the children components of this component.
     *
     * @return the components
     */
    @NotNull
    List<Component> getChildren();

    class Builder<T extends ParentComponent> extends Component.Builder<T> {
        /**
         * @param component the component instance
         */
        public Builder(@NotNull T component) {
            super(component);
        }

        /**
         * Add a child component to this container.
         *
         * @param child the child component
         * @return this
         */
        @Contract("_ -> this")
        public Builder<T> addChild(@NotNull Component child) {
            super.get().addChild(child);
            return this;
        }
    }
}
