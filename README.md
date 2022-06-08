# looks
**looks** is a Java library to build frontend design through abstractation and object creation.

# Usage (as of v1.0)

```java
final class Main {
    private Main() {
    }

    public static void main(@NotNull String[] args) {
        ContainerComponent document = new ContainerComponent("html");
        document.applyProperty("lang", "en");
        
        document.addChild(new ParentComponent.Builder<>(
            new ContainerComponent("head"))
                              .addChild(ContainerComponent.construct("title", "This is a test!"))
                              .get());

        String html = HtmlSerializer.format(document);
    }
}
```