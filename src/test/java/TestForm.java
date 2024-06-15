import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager"; //необходимо для того, чтобы пофиксить ошибку таймаута

    }

    @Test
    void testForm() {
        //указание абсолютного пути, чтобы браузер открылся на весь экран
        open("/automation-practice-form");

        //удаление баннера с рекламой
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()"); //удаление рекламы с помощью кода JS на стороне браузера

        //заполнение обычных полей
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Rory");
        $("#lastName").setValue("McDonald");
        $("#userEmail").setValue("333@gmail.com");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("Test 1");

        //заполнение чекбоксов
        $("#genterWrapper").$(byText("Male")).click(); //выбор пола по тексту "Male" (предварительно обозначен блок с выбором пола "genterWrapper")
        $("#hobbies-checkbox-1").parent().click(); //выбор варианта хобби с ссылкой на родителя
        $("label[for=hobbies-checkbox-3]").click(); //выбор варианта хобби с вводом селектора ("label" добавлен специально для читаемости)

        //выбор даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January"); //выбор месяца с помощью selectOption()
        $(".react-datepicker__year-select").selectOption("1900"); //выбор года с помощью selectOption()
        $(".react-datepicker__day--010").click();

        //выбор предметов
        $("#subjectsInput").setValue("Math").pressEnter().setValue("Economics").pressEnter(); //после ввода каждого из предметов - нажимается Enter

        //выбор штата и города
        $("#state").click();
        $("#stateCity-wrapper"). $(byText("NCR")).click(); //поиск по тексту "NCR" (название блока указано лишь для читабельности)
        $("#city").click();
        $("#stateCity-wrapper"). $(byText("Noida")).click(); //поиск по тексту "Noida" (название блока указано лишь для читабельности)

        //загрузка изображения
//        $("#uploadPicture").uploadFromClasspath(("src/test/resources/img/test.png")); //более упрощенный метод для установки файла (
//        $("#uploadPicture").uploadFile(new File("src/test/resources/test.png")); //вариант загрузки файла через uploadFile (необходио создать объект с типом "File")

        //кнопка "submit"
        $("#submit").scrollTo(); //скролл до кнопки "Submit"
        $("#submit").click();

        //таблица с результатами заполнения
        $(".modal-content").shouldBe(appear); //проверка на отображение таблицы с результатами заполнения
        $(".modal-content").shouldHave(text("Thanks for submitting the form")); //проверка названия таблицы результатов
        $(".modal-body").shouldHave(text("333@gmail.com")).shouldHave(text("Rory McDonald")); //проверка заполненных данных
        $("#closeLargeModal").click(); //закрыть таблицу результатов
    }
}
