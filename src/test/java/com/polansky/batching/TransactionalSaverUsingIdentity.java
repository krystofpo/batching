package com.polansky.batching;

import com.polansky.batching.entity.AddressUsingIdentity;
import com.polansky.batching.entity.UserUsingIdentity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionalSaverUsingIdentity {

    Logger log = LoggerFactory.getLogger(Batch1TransactionIdentityTest.class);

    @Autowired
    UserUsingIdentityRepo userUsingIdentityRepo;

    @Transactional
    public void saveInTransaction(int iterationsCount) {
        log.info("after beginning of transaction");

        for (int i = 1; i <= iterationsCount; i++) {
            UserUsingIdentity user = new UserUsingIdentity();
            user.setAddresses(List.of(new AddressUsingIdentity(), new AddressUsingIdentity()));
            user = userUsingIdentityRepo.save(user);
            log.info("user id: " + user.getId());
        }

        log.info("before end of transaction");
    }

}
