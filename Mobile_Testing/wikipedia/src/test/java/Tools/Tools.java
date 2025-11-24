package Tools;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public class Tools {

        public void swipe(SWIPE_DIRECTION direction, AndroidDriver driver) {
                Dimension size = driver.manage().window().getSize();
                int y = size.getHeight();
                int x = size.getWidth();
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1);

                switch (direction) {
                        case LEFT:
                                swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                                                PointerInput.Origin.viewport(),
                                                (int) (x * 0.7), y / 2));
                                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                                swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
                                                PointerInput.Origin.viewport(),
                                                (int) (x * 0.3), y / 2));
                                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                                driver.perform(Arrays.asList(swipe));
                                break;
                        case RIGHT:
                                swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                                                PointerInput.Origin.viewport(),
                                                (int) (x * 0.3), y / 2));
                                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                                swipe.addAction(finger.createPointerMove(Duration.ofMillis(500),
                                                PointerInput.Origin.viewport(),
                                                (int) (x * 0.7), y / 2));
                                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                                driver.perform(Arrays.asList(swipe));
                                break;
                        case UP:
                                swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                                                PointerInput.Origin.viewport(),
                                                x / 2, (int) (y * 0.7)));
                                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                                swipe.addAction(finger.createPointerMove(Duration.ofMillis(200),
                                                PointerInput.Origin.viewport(),
                                                x / 2, (int) (y * 0.1)));
                                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

                                driver.perform(Arrays.asList(swipe));
                                break;
                }
        }

}
