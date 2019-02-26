package com.adric.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Making the application executable
 * 
 * Possible to package service as WAR, but its simpler to create
 * standalone app by packaging via JAR, driven by good ole' Java main() method.
 * 
 * Spring supports embedding Tomcat servlet containers as HTTP runtime,
 * instead of an external instance
 * 
 * @author Adric Saxon
 */
@SpringBootApplication
/**
 * Hooked up!
 * 
 * @SpringBootApplication is convenience annotation adding:
 * 
 * a. @Configuration tags class as a source of bean definitions for application context
 * b. @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath
 * 		settings, other beans, and various property settings
 * c. @EnableWebMvc for Spring MVC app addeed automatic because spring-webmvc is on classpath
 * 		this flags it as web app, and activates key behaviors like DispatcherServlet
 * d. @ComponentScan advises Spring to look for other components, configs, services in restservice
 * 		package, allowing it to find controllers
 *
 */
public class DemoApplication {
/**
 * This is Java Configuration
 * 
 * Notice main() method uses SpringApplication.run(), this launches the app
 * No XML, no web.xml, nothing of that sort, web app is 100% Java without
 * need to configure plubming or infrastructure
 * 
 * Build an executable JAR
 * 
 * Run app from cli with Maven, or build single exe JAR file containing
 * all necessary dependencies, classes, resources, etc. This makes
 * it easy to ship, version, and deploy service as app throughout
 * dev lifecycle, different envs, etc
 * 
 * Maven
 * 
 * Run with: {@code ./mvnw spring-boot:run}
 * 
 * Build with: {@code ./mvnw clean package} then 
 * 				{@code java -jar target/restservice-0.1.0.jar}
 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
