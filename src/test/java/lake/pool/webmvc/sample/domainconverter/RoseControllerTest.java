package lake.pool.webmvc.sample.domainconverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RoseRepository roseRepository;

    @Test
    public void rose() throws Exception {
        Rose rose = new Rose();
        rose.setName("lake");
        Rose savedRose = roseRepository.save(rose);

        this.mockMvc.perform(get("/rose")
                .param("id", savedRose.getId().toString()))  // .param()의 파라미터값은 무조건 String만 들어감
                .andDo(print())
                .andExpect(content().string("hello lake"));

        this.mockMvc.perform(get("/rose/"+ savedRose.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                ;

    }
}