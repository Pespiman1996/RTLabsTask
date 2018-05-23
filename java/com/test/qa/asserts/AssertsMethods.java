package com.test.qa.asserts;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertsMethods {

    @Step
    public static void assertStars(List<Double> starsList, double value) {
        boolean t = true;
        for(int i=0; i < starsList.size(); i++){
            if(starsList.get(i) < value) {
                t = false;
            }
        }
        Assert.assertEquals(t, true, "In search results, there are values that exceed the specified value.");
    }

    @Step
    public static void assertProgrammLanguageInSearchResult(List<String> starsList, String value) {
        boolean t = true;
        for(int i=0; i<starsList.size(); i++){
            if(!value.equals(starsList.get(i))) {
                t = false;
            }
        }
        Assert.assertEquals(t, true, "In search results, there are values that exceed the specified value.");
    }

    @Step
    public static void assertUserNameInSearchResult(List<String> userNameList, String value) {
        boolean t = true;
        for(int i=0; i < userNameList.size(); i++){
            if(!value.equals(userNameList.get(i))) {
                t = false;
            }
        }
        Assert.assertEquals(t, true, "In search results, there are values that exceed the specified value.");
    }

}
