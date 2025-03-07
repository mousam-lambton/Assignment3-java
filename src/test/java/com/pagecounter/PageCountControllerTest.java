package com.pagecounter;
import com.pagecounter.controller.PageCountController;
import com.pagecounter.service.PageCounter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = PageCountController.class)
class PageCountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PageCounter pageCounter;

    @Test
    void currentCountEndpoint() throws Exception {
        // Mock the behavior of the PageCounter bean
        when(pageCounter.getPageCount()).thenReturn(3);

        // Perform the GET request and verify the response
        mockMvc.perform(get("/currentcount"))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }
}