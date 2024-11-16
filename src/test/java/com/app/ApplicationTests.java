                                                                                                                                                                                                 package com.app;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MyApplicationTests {

    @Autowired
    private MockMvc mockMvc;  // MockMvc is used for testing web controllers

    @Test
    public void contextLoads() {
        // This will simply check if the application context loads correctly.
        // If the context doesn't load, the test will fail.
    }


}
