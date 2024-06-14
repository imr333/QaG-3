import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {
    @BeforeAll
    static void beforeAll() {
        open("https://demoqa.com");
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void testForm() {
        open("/automation-practice-form");

        $("#firstName").setValue("Rory");
        $("#lastName").setValue("McDonald");
        $("#userEmail").setValue("333@gmail.com");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("Test 1");


    }

}
