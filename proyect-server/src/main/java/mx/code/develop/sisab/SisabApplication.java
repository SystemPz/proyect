package mx.code.develop.sisab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        SisabApplication.class,
        Jsr310JpaConverters.class
})
public class SisabApplication {

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
    }

    public static void main(String[] args) {
        SpringApplication.run(SisabApplication.class, args);
    }

}
