package lake.pool.webmvc.sample.formatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@RunWith(SpringRunner.class)
//@WebMvcTest // slice 테스트 ( mockmvc 포함되어있음 )
@SpringBootTest // pull 테스트
@AutoConfigureMockMvc // @SpringBootTest 풀테스트의 경우 mockmvc가 없어서 추가해줘야함
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {

        //일반적인 처리
//        this.mockMvc.perform(get("/hello"))
//                .andDo(print())
//                .andExpect(content().string("hello"));
        //PathValiable 처리
        this.mockMvc.perform(get("/hello/lake"))
                .andDo(print())
                .andExpect(content().string("hello lake"));
        //ReqeustParam 처리
        this.mockMvc.perform(get("/hello")
                .param("name","lake"))
                .andDo(print())
                .andExpect(content().string("hello lake"));
    }

}