package com.demoqa.tests;


import com.demoqa.pages.RegistrationFormPageObject;
import static io.qameta.allure.Allure.step;
import org.junit.jupiter.api.Test;

public class TestForm extends TestBase {
    RegistrationFormPageObject registrationFormPageObject = new RegistrationFormPageObject();

    @Test
    void testForm() {
        step("Заполняем форму регистрации", ()-> {
            registrationFormPageObject.openPage().
                    setFirstName("Ivan").
                    setLastName("Ivanov").
                    setUserEmail("email@email.com").
                    setGender("Male").
                    setUserNumber("9374364782").
                    setBirthDate("29", "May", "1993").
                    setSubjectsInput("English").
                    setHobbies("Sports").
                    setUploadPicture("src/test/resources/selenide-logo-big.png").
                    setCurrentAddress("My Address Soviet Union").
                    setState("Haryana").
                    setCity("Karnal").
                    clickSubmit();
        });

        step("Проверяем форму", ()-> {
            registrationFormPageObject.checkResultTableVisible().
                    checkRegistrationSubmittingFormTests("Student Name", "Ivan Ivanov").
                    checkRegistrationSubmittingFormTests("Student Email", "email@email.com").
                    checkRegistrationSubmittingFormTests("Gender", "Male").
                    checkRegistrationSubmittingFormTests("Mobile", "9374364782").
                    checkRegistrationSubmittingFormTests("Date of Birth", "29 May,1993").
                    checkRegistrationSubmittingFormTests("Subjects", "English").
                    checkRegistrationSubmittingFormTests("Hobbies", "Sports").
                    checkRegistrationSubmittingFormTests("Picture", "selenide-logo-big.png").
                    checkRegistrationSubmittingFormTests("Address", "My Address Soviet Union").
                    checkRegistrationSubmittingFormTests("State and City", "Haryana Karnal");
        });

    }
}