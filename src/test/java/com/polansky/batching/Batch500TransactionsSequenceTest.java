package com.polansky.batching;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StopWatch;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@ActiveProfiles("batch")
class Batch500TransactionsSequenceTest {

    Logger log = LoggerFactory.getLogger(Batch500TransactionsSequenceTest.class);

    @Autowired
    TransactionalSaver transactionalSaver;

    @Test
    void saveUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        for (int i = 1; i <= 500; i++) {
            transactionalSaver.saveInTransaction(1);
        }

        stopWatch.stop();
        log.info("took {} ms", stopWatch.getLastTaskTimeMillis());

        assertTrue(true);
    }

}
