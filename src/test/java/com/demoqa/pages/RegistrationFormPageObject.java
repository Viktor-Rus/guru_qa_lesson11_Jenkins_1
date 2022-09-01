package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPageObject {

    private CalendarComponent calendarComponents = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    private static final String HEADER_FORM_REGISTRATION = "Student Registration Form";
    private SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            selectState =  $("#state input"),
            selectCity =  $("#city input"),
            summit =    $("#submit"),
            form = $(".practice-form-wrapper");



    public RegistrationFormPageObject openPage(){
        open("/automation-practice-form");
        form.shouldHave(text(HEADER_FORM_REGISTRATION));
        return this;
    }

    public RegistrationFormPageObject setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public RegistrationFormPageObject setLastName(String name) {
        lastName.setValue(name);
        return this;
    }

    public RegistrationFormPageObject setUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public RegistrationFormPageObject setGender(String gender) {
        $x("//label[text()='" + gender + "']").click();
        return this;
    }
    public RegistrationFormPageObject setUserNumber(String number) {
        userNumber.setValue(number);
        return this;
    }

    public RegistrationFormPageObject setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);
        return this;
    }



    public RegistrationFormPageObject setSubjectsInput(String subjects) {
        subjectsInput.setValue(subjects).sendKeys(Keys.ENTER);
        return this;
    }
    public RegistrationFormPageObject setHobbies(String hobbies) {
        $x("//label[text()='" + hobbies + "']").click();
        return this;
    }

    public RegistrationFormPageObject setUploadPicture(String pathPicture) {
        uploadPicture.uploadFile(new File(pathPicture));
        return this;
    }

    public RegistrationFormPageObject setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationFormPageObject setState(String state) {
        selectState.setValue(state).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationFormPageObject setCity(String city) {
        selectCity.setValue(city).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationFormPageObject clickSubmit() {
        summit.click();
        return this;
    }


    public RegistrationFormPageObject checkResultTableVisible() {
        resultTableComponent.checkVisible();

        return  this;
    }

    public RegistrationFormPageObject checkRegistrationSubmittingFormTests(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return  this;
    }

}