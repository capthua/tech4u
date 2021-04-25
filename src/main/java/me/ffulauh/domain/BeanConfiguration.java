package me.ffulauh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {

    @Bean(initMethod = "customInit",destroyMethod = "customDestroy")
    public MyTestBean myTestBean(){
        return new MyTestBean();
    }

}
