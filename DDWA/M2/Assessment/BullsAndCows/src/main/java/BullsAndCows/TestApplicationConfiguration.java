/*
Created by: Margaret Donin
Date created: 09/23/20
Date revised:
*/

package BullsAndCows;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        value = CommandLineRunner.class))
@EnableAutoConfiguration
public class TestApplicationConfiguration {

}
