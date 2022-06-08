import com.github.imajindevon.looks.component.ParentComponent;
import com.github.imajindevon.looks.component.components.ContainerComponent;
import com.github.imajindevon.looks.serialization.HtmlSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

final class HtmlTest {
    @Test
    void simpleTest() {
        Path path = Path.of("src/test/resources/output/simpleTest.html");

        try (OutputStream outputStream = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ContainerComponent document = new ContainerComponent("html");

            document.applyProperty("lang", "en");

            document.addChild(
                new ParentComponent.Builder<>(new ContainerComponent("head"))
                    .addChild(ContainerComponent.newValue("title", "This is a test!"))
                    .get()
            );

            String html = HtmlSerializer.format(document);
            outputStream.write(html.getBytes(StandardCharsets.UTF_16));
        } catch (IOException exception) {
            exception.printStackTrace();
            Assertions.fail(exception);
        }
    }
}
