package com.lens.blog.sms.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置文件
 */
@Configuration
public class RabbitMqConfig {

    public static final String LENS_BLOG = "lens.blog";
    public static final String LENS_EMAIL = "lens.email";
    public static final String LENS_SMS = "lens.sms";
    public static final String EXCHANGE_DIRECT = "exchange.direct";
    public static final String ROUTING_KEY_BLOG = "lens.blog";
    public static final String ROUTING_KEY_EMAIL = "lens.email";
    public static final String ROUTING_KEY_SMS = "lens.sms";

    /**
     * 声明交换机
     */
    @Bean(EXCHANGE_DIRECT)
    public Exchange EXCHANGE_DIRECT() {
        // 声明路由交换机，durable:在rabbitmq重启后，交换机还在
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT).durable(true).build();
    }

    /**
     * 声明Blog队列
     *
     * @return
     */
    @Bean(LENS_BLOG)
    public Queue LENS_BLOG() {
        return new Queue(LENS_BLOG);
    }

    /**
     * 声明Email队列
     *
     * @return
     */
    @Bean(LENS_EMAIL)
    public Queue LENS_EMAIL() {
        return new Queue(LENS_EMAIL);
    }

    /**
     * 声明SMS队列
     *
     * @return
     */
    @Bean(LENS_SMS)
    public Queue LENS_SMS() {
        return new Queue(LENS_SMS);
    }

    /**
     * lens.blog 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_BLOG(@Qualifier(LENS_BLOG) Queue queue, @Qualifier(EXCHANGE_DIRECT) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_BLOG).noargs();
    }

    /**
     * lens.mail 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(LENS_EMAIL) Queue queue, @Qualifier(EXCHANGE_DIRECT) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_EMAIL).noargs();
    }

    /**
     * lens.sms 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(LENS_SMS) Queue queue, @Qualifier(EXCHANGE_DIRECT) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_SMS).noargs();
    }


    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
