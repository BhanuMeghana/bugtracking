package com.example.bugtracker;

import com.example.bugtracker.model.Bug;
import com.example.bugtracker.repository.BugRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BugControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BugRepository bugRepository;

    @BeforeEach
    public void setup() {
        Bug bug = new Bug();
        bug.setTitle("Test Bug");
        bug.setDescription("This is a test bug");
        bug.setStatus("Open");
        bug.setPriority("High");
        bug.setSeverity("Major");
        bugRepository.save(bug);
    }

    @Test
    public void testGetBugs() throws Exception {
        mockMvc.perform(get("/api/bugs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
