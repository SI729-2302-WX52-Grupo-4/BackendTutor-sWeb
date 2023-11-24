package pe.edu.upc.schedule.customer.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("learningMappingConfiguration")

public class MappingConfiguration {


    @Bean
    public UserMapper reservationMapper() {
        return new UserMapper();
    }

    @Bean
    public VideoConferenceMapper videoConferenceMapper() {

        return new VideoConferenceMapper();
    }

    @Bean
    public ProfesorMapper ProfesorMapper() {

        return new ProfesorMapper();
    }



}
