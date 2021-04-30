package learningtest.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/learningtest/junit/junitApplicationContext.xml")
public class SpringTest {
    @Autowired
    ApplicationContext context;
    @Autowired
    TestObject testObject;

    static TestObject storeTestObject = null;

    @Test
    public void isSingleTone1() {
        Object objectFromBean = context.getBean("testObject", TestObject.class);
        assertTrue(storeTestObject == null || storeTestObject == objectFromBean);
    }

    @Test
    public void isSingleTone2() {
        Object objectFromBean = context.getBean("testObject", TestObject.class);
        assertTrue(storeTestObject == null || storeTestObject == objectFromBean);
    }

    @Test
    public void isSingleTone3() {
        Object objectFromBean = context.getBean("testObject", TestObject.class);
        assertTrue(storeTestObject == null || storeTestObject == objectFromBean);
    }

    @Test
    public void autowired() {
        Object objectFromBean = context.getBean("testObject", TestObject.class);
        assertThat(testObject, is(objectFromBean));
    }

    @Test
    public void xmlProperty() {
        assertThat(testObject.getString(), is("success"));
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void NoSuchBeanDefinitionFailure() {
        context.getBean("", TestObject.class);
    }

    @Test
    public void ApplicationContextConstructor() {
        /*
            ContextConfiguration를 사용한 경우에만 애플리케이션 컨텍스트를 공유해서 사용한다.
            아래와 같이 ApplicationContext 구현 클래스를 사용할 경우 각각 독립된 ApplicationContext가 제공된다.
         */
        ApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("/learningtest/junit/junitApplicationContext.xml");
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestFactory.class);
        assertThat(genericXmlApplicationContext, is(not(annotationConfigApplicationContext)));
    }

}
