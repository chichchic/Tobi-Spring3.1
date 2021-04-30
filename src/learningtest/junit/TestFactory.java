package learningtest.junit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestFactory {
    @Bean
    public TestObject testObject() {
        TestObject testObject = new TestObject();
        testObject.setString("success");
        return testObject;
    }
}
