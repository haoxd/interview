package com.bread.coalquality.spring.commandLineRunner;

import com.bread.coalquality.mvc.convert.UserConvertMapper;
import com.bread.coalquality.mvc.dto.UserDTO;
import com.bread.coalquality.mvc.entity.User;
import com.bread.coalquality.spring.factoryBean.TestFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 这个接口也只有一个方法：run(String... args)，触发时机为整个项目启动完毕后，自动执行。如果有多个CommandLineRunner，可以利用@Order来进行排序。
 *
 * 使用场景：用户扩展此接口，进行启动项目之后一些业务的预处理。
 *
 * */
@Component
@Slf4j
public class TestCommandLineRunner implements CommandLineRunner,Ordered,ApplicationContextAware {

    @Override
    public void run(String... args) throws Exception {
        log.info("start do commandLineRunner...");
        // 模拟任务执行时长
        //TimeUnit.MINUTES.sleep(1);

        // 模拟运行过程中出错
        //int i = 1 / 0;

        log.info("do commandLineRunner end");


        UserDTO dto = UserConvertMapper.INSTANCE.dto(User.builder().id(1L).passWord("1").userName("2").build());

        System.out.println(dto.toString());

        User entity = UserConvertMapper.INSTANCE.entity(dto);

        System.out.println(entity.toString());
    }

    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE+1;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TestFactoryBean bean = applicationContext.getBean(TestFactoryBean.class);
        try {
            TestFactoryBean.TestFactoryInnerBean object = bean.getObject();
            log.info(object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}