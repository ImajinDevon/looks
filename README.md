# looks
**looks** is a Java library to build frontend design through abstractation and object creation.

# Usage (as of v1.0)

```java
import com.github.imajindevon.looks.component.ParentComponent;
import com.github.imajindevon.looks.component.components.ContainerComponent;
import com.github.imajindevon.looks.serialization.HtmlSerializer;

public class Main {
    public static void main(String[] args) {
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