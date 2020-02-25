package com.test.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
//        acac.getEnvironment().getSystemProperties().put("people", "northPeople");
        acac.getEnvironment().addActiveProfile("southPeople");
        acac.register(JavaConfig.class);
        acac.refresh();
        Food food = (Food) acac.getBean("food");
        System.out.println(food.showName());
    }
}
