package com.example.sharding;

import com.greenbon.account.domain.AccountAssociate;
import com.greenbon.account.service.AccountAssociateService;
import com.greenbon.main.ShardingApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
class GbShardingOsApplicationTests {
    @Autowired
    AccountAssociateService  accountAssociateService;

    @Test
    void contextLoads() {
        AccountAssociate byId = accountAssociateService.findById(1L);
        System.out.println(byId);
    }

}
