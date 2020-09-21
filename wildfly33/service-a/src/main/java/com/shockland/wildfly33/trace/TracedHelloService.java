package com.shockland.wildfly33.trace;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.opentracing.Traced;


@ApplicationScoped
@Traced
public class TracedHelloService {

    @Inject
    @ConfigProperty(name="app.hello", defaultValue = "Hello")
    private String hello;
    private final Random random = new Random();

    public String createHelloMessage(String name) {

        try {
            Thread.sleep(random.nextInt(200));
        } catch (InterruptedException e) {
        }

        if (random.nextInt(10) <= 3) {
            throw new IllegalStateException("Big problem in my application");
        }

        return hello + " " + name + "!";
    }

}