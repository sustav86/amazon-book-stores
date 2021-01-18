package com.sustav;

import com.sustav.model.Job;
import com.sustav.repository.JobRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@AutoConfigureTestEntityManager
public class TestJobRepository {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private JobRepository jobRepository;

    @Test
    public void testEntityManager() {
        Job id = testEntityManager.getId(1, Job.class);
        System.out.println(id);
    }
}
