package com.instinctools.search.controller;
import com.instinctools.search.entity.Doc;
import com.instinctools.search.service.DocService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DocControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DocService service;

    private Doc testDoc = new Doc("4444", "testDoc", "hello world!");

    @Test
    public void shouldReturnDocsIdBySentence() throws Exception {
        addDocToDb();
        this.mockMvc.perform(get("/search?q=hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(testDoc.getId())));
    }

    @Before
    public void addDocToDb() {
        service.save(testDoc);
    }

    @After
    public void deleteFromDb() {
        service.delete(testDoc.getId());
    }

}