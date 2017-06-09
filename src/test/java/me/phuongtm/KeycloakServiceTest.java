package me.phuongtm;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by phuongtran on 6/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KeycloakServiceTest {

    @Autowired
    private KeycloakService service;

    @Test
    public void shouldSuccessfulAddNewAccount() throws Exception {
        int result = service.createAccount("the_new_thang", "superman");
        Assert.assertEquals(201, result);
    }
}
