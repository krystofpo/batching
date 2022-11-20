package com.polansky.batching;

import com.polansky.batching.entity.Address;
import com.polansky.batching.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionalSaver {

    Logger log = LoggerFactory.getLogger(TransactionalSaver.class);

    @Autowired
    UserRepo userRepo;

    @Transactional
    public void saveInTransaction(int iterationCount) {
        log.info("after beginning of transaction");

        for (int i = 1; i <= iterationCount; i++) {
            User user = new User();
            user.setAddresses(List.of(new Address(), new Address()));
            user = userRepo.save(user);
            log.info("user id: " + user.getId());
        }
        log.info("before end of transaction");
    }

}
