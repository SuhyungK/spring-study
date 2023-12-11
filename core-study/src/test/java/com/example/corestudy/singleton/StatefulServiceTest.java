package com.example.corestudy.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void statefulServiceSingleton() {
        StatfulService statfulService1 = ac.getBean("statfulService", StatfulService.class);
        StatfulService statfulService2 = ac.getBean("statfulService", StatfulService.class);

        statfulService1.order("userA", 10000);
        statfulService2.order("userB", 20000);

        int price = statfulService1.getPrice();
        Assertions.assertThat(price)
                  .isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatfulService statfulService() {
            return new StatfulService();
        }
    }

}
