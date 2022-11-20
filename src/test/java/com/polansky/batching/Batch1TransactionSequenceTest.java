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
class Batch1TransactionSequenceTest {

	Logger log = LoggerFactory.getLogger(Batch1TransactionSequenceTest.class);

	@Autowired
	TransactionalSaver transactionalSaver;

	@Test
	void saveUsers() {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		transactionalSaver.saveInTransaction(500);

		stopWatch.stop();
		log.info("took {} ms", stopWatch.getLastTaskTimeMillis());

		assertTrue(true);
	}

}
