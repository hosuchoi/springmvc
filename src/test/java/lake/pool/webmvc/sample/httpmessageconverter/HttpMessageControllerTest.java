package lake.pool.webmvc.sample.httpmessageconverter;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HttpMessageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void messageTest() throws Exception {
        mockMvc.perform(get("/converterMessage")
                .content("hello"))
                .andDo(print())
                .andExpect(content().string("hello"));
    }

}