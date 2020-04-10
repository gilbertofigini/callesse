package it.gilbertofigini.callesse;

import it.gilbertofigini.callesse.config.EsselungaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(EsselungaProperties.class)
public class CallesseApplication {

    static final Logger LOG = LoggerFactory.getLogger(CallesseApplication.class);

    public static void main(String[] args) {
        LOG.debug("start main");
        SpringApplication.run(CallesseApplication.class, args);
//        SpringApplication app = new SpringApplication(CallesseApplication.class);
//        Environment env = app.run(args).getEnvironment();
        LOG.debug("end main");
    }

    /*@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }*/

   /* @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        checkAppointment.checkAppointEsse();
        return args -> {



            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }*/

    /*private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isEmpty(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOG.warn("The host name could not be determined, using `localhost` as fallback");
        }
        LOG.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles());
    }*/



}
