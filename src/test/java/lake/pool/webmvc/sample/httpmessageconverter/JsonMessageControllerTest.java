package lake.pool.webmvc.sample.httpmessageconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lake.pool.webmvc.sample.formatter.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JsonMessageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void jsonmessageTest() throws Exception {
        Person person = new Person();
        person.setId(2020l);
        person.setName("lake");

        String jsonString = objectMapper.writeValueAsString(person);

        mockMvc.perform(get("/jsonMessageConverter")
                    .content(jsonString)
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2020))
                .andExpect(jsonPath("$.name").value("lake"));
    }

}