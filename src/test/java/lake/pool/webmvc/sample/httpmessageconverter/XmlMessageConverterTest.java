//package lake.pool.webmvc.sample.httpmessageconverter;
//
//
//import lake.pool.webmvc.sample.formatter.Person;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import javax.xml.bind.Marshaller;
//import javax.xml.transform.stream.StreamResult;
//
//import java.io.StringWriter;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class XmlMessageConverterTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    Marshaller marshaller;
//
//    @Test
//    public void xmlConverter() throws Exception{
//        Person person = new Person();
//        person.setId(2020l);
//        person.setName("lake");
//
//        StringWriter stringWriter = new StringWriter();
//        StreamResult streamResult = new StreamResult(stringWriter);
//        marshaller.marshal(person, streamResult);
//        String xmlString = stringWriter.toString();
//
//        mockMvc.perform(get("/xmlMessage")
//                    .content(xmlString)
//                    .contentType(MediaType.APPLICATION_XML)
//                    .contentType(MediaType.APPLICATION_XML))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(xpath("person/id").string("2020"))
//                .andExpect(xpath("person/name").string("lake"))
//                ;
//    }
//}