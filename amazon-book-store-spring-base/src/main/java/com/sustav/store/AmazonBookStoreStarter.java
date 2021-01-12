package com.sustav.store;

import com.sustav.store.config.SpringConfig;
import com.sustav.store.model.Book;
import com.sustav.store.model.HelloWorld;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;

import java.util.Arrays;

/**
 * @author Anton Sustavov
 * @since 2020/10/26
 */
public class AmazonBookStoreStarter {

    private HelloWorld hello;

    public HelloWorld getHello() {
        return hello;
    }

    public void setHello(HelloWorld hello) {
        this.hello = hello;
    }

    public void runApp() {
        hello.sayHello();
    }

    public static void main(String[] args) {
//        simple spring config xml
//        BeanFactory beanFactory = getBeanFactory();
//        AmazonBookStoreStarter app = beanFactory.getBean("app", AmazonBookStoreStarter.class);
//        app.runApp();

//        simple spring config annotation
        final GenericApplicationContext annotatedBeanFactory = getAnnotatedBeanFactory();
        annotatedBeanFactory.refresh();
        final Book book = annotatedBeanFactory.getBean("book", Book.class);
        System.out.println(book);
        showContextBeans(annotatedBeanFactory);

//        java config spring app
//        final AnnotationConfigApplicationContext context
//                = new AnnotationConfigApplicationContext(SpringConfig.class);
//        final Book book = context.getBean("book", Book.class);
//        System.out.println(book);
    }

    public static BeanFactory getBeanFactory() {
        DefaultListableBeanFactory xbf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(xbf);
        final DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        reader.loadBeanDefinitions(defaultResourceLoader.getResource("beans.xml"));
        return xbf;
    }

    public static GenericApplicationContext getAnnotatedBeanFactory() {
        final GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
        final AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader
                = new AnnotatedBeanDefinitionReader(genericApplicationContext);
        annotatedBeanDefinitionReader.register(SpringConfig.class);
        return genericApplicationContext;
    }

    private static void showContextBeans(BeanDefinitionRegistry bdr) {
        final String[] beanDefinitionNames = bdr.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
    }
}
