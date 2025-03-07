package com.pagecounter;

import com.pagecounter.controller.WelcomeController;
import com.pagecounter.service.PageCounter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PageCounter pageCounter;

    // Verify response on GET request to the base URL
    @Test
    void welcomePageIncrementsCounter() throws Exception {
        when(pageCounter.getPageCount()).thenReturn(5);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("pageCount", 5));

        // Verify that the increment method was called once and the getPageCount method was called once
        verify(pageCounter, times(1)).increment();
        verify(pageCounter, times(1)).getPageCount();
    }
}