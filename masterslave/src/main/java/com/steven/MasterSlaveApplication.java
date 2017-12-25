package com.steven;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author donghongchen
 * @create 2017-12-07 10:19
 **/
@SpringBootApplication
@MapperScan("com.steven.dao")
//@EnableAutoConfiguration(exclude = {SpringBootConfiguration.class})
public class MasterSlaveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterSlaveApplication.class, args);
    }

    @Bean
    public IdGenerator getIdGenerator(){
        return new CommonSelfIdGenerator();
    }

}
