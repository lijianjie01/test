package com.test.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class JavaConfig {

    @Bean("food")
//    @Conditional(RiceCondition.class)
    @Profile("southPeople")
    Rice rice() {
        return new Rice();
    }

    @Bean("food")
//    @Conditional(NoodlesCondition.class)
    @Profile("northPeople")
    Noodles noodles() {
        return new Noodles();
    }
}
