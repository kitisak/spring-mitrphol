/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
@Component
public class Aware implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean, DisposableBean{

    @Override
    public void setBeanName(String string) {
        System.out.println("-------- name "+string);
    }

    @Override
    public void setBeanFactory(BeanFactory bf) throws BeansException {
        System.out.println("-------- BeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        System.out.println("-------- ApplicationContext");
    }

//    @Override
//    public Object postProcessBeforeInitialization(Object o, String string) throws BeansException {
//        System.out.println("-------- BeforeInit");
//        return o;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object o, String string) throws BeansException {
//        System.out.println("-------- AfterInit");
//        return o;
//    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-------- afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("-------- destroy");
    }
    
    public Aware(){
        System.out.println("-------- Construc");
    }
    
    @PostConstruct
    public void postConstruc(){
        System.out.println("-------- postConstruc");
    }
    
    @PreDestroy
    public void preDestroy(){
        System.out.println("-------- preDestroy");
    }
}
