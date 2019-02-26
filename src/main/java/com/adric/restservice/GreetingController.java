package com.adric.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * MVC vs RESTful controller
 * 
 * Key difference to note, rather than rely on view technology
 * to perform server-side rendering of data to HTML, RESTful web service
 * controller just populates and returns Greeting object directly
 * to HTTP response as JSON
 * 
 * New in Spring4, where every method returns domain object instead of view. 
 * It's shorthand for @Controller and @ResponseBody rolled together
 * 
 * Greeting object converted to JSON via Spring's HTTP message converter support,
 * e.g., no need to convert manually, Jackson 2 is on classpath, Spring's 'MappingJackson2HttpMessageConverter'
 * is auto chosen to convert Greeting instance to JSON
 * 
 * @author Adric Saxon
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * @RequestMapping info
     * 
     * Ensures HTTP requests to /greeting are mapped
     * to greeting() method
     * 
     * To narrow the HTTP operations, specify (method=GET),
     * because @RequestMapping maps all HTTP operations by default
     * 
     * 
     */
    @RequestMapping("/greeting")
    /**
     * @RequestParam info
     * 
     * Binds the value of query string parameter 'name' into the 'name' parameter
     * of the greeting() method. If 'name' is absent in request, the
     * defaultValue of "World" is used
     * 
     * Method body creates and returns new Greeting object with id and content attributes based on 
     * next value from the counter, and then formats given name by using the greeting template.
     * 
     * 
     */
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}