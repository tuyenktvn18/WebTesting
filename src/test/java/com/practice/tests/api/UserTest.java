package com.practice.tests.api;

import com.practice.api.UserRequest;
import com.practice.dataTest.DataObjectBuilder;
import com.practice.dataTest.api.models.UserCred;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {
    UserCred userCred = DataObjectBuilder.buildDataObjectBuilder("api\\data\\User.json", UserCred.class);

    @Test
    public void TC_001_Get_All_User(){
        Response response = UserRequest.getAllUsers();
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void TC_002_Post_User(){
        Response response = UserRequest.postUsers(userCred);
        response.then().log().all();
        userCred.setId(String.valueOf(response.body().jsonPath().getInt("id")));

        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test
    public void TC_003_Get_Specific_User(){
        Response response = UserRequest.getSpecificUsers("2");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void TC_004_Delete_User(){
        Response response = UserRequest.getSpecificUsers("2");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }

}
