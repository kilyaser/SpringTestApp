drop table if exists "springTestAppDB".questions cascade;

create table "springTestAppDB".questions (
    id              bigserial primary key,
    question        varchar(255),
    theme           varchar(50),
    explanation     text
);

drop table if exists "springTestAppDB".answers;
create table "springTestAppDB".answers (
    id              bigserial primary key,
    answer          varchar(70),
    question_id     bigint references "springTestAppDB".questions(id),
    correct_answer  boolean
);

insert into "springTestAppDB".questions (id, question, theme, explanation) values
(1, 'Which of the following are cross cutting concerns where Spring AOP can be useful?', 'AOP',
 'There are many valid AOP use cases. Other use cases include: performance monitoring, statistics, transactions, caching'),
(2, 'Which of the following operators can be used to combine multiple pointcut expressions?', 'AOP','You can combine pointcut
expressions by using &&, || and !. You can also refer to pointcut expressions by name' ),
(3, 'Which of the following are metrics provided by Spring Boot Actuator?', 'Boot Actuator', 'Some examples of metrics that can
be found in a Spring Boot application are: 1. Response time of HTTP requests. 2. Number of active connections in a database
connection pool. 3. Memory usage. 4. This can be for instance heap memory usage. 5. Garbage collection statistics.'),
(4, 'Which of the following are health indicators provided by Spring Boot Actuator by default?', 'Boot Actuator', 'DiskSpaceHealthIndicator - Verifies
that available disk space is above a certain threshold. ElasticsearchHealthIndicator - Verifies the availability of an Elasticsearch cluster.
ConnectionHealthIndicator and ApplicationHealthIndicator do not exist.'),
(5, 'Spring MVC Auto-configuration adds the following on top of Spring’s defaults.', 'Boot AutoConfig', 'The auto-configuration adds the
following features on top of Spring’s defaults: Inclusion of ContentNegotiatingViewResolver and BeanNameViewResolver beans.
Support for serving static resources, including support for WebJars. Automatic registration of Converter, GenericConverter, and Formatter beans.
Support for HttpMessageConverters. Automatic registration of MessageCodesResolver. Static index.html support. Custom Favicon support.
Automatic use of a ConfigurableWebBindingInitializer bean.'),
(6, 'In Spring Boot, what is the default type of ApplicationContext created if Spring MVC is not present?', 'Boot AutoConfig', 'A SpringApplication attempts to
create the right type of ApplicationContext on your behalf. The algorithm used to determine a WebApplicationType is the following:
If Spring MVC is present, an AnnotationConfigServletWebServerApplication Context is used If Spring MVC is not present and
Spring WebFlux is present, an AnnotationConfigReactiveWebServerApplication Spring Professional Practice Questions 28 Context is used
Otherwise, AnnotationConfigApplicationContext is used'),
(7, 'What is the name of the default property configuration file in Spring Boot?', 'Boot Intro', 'The default configuration file is
application.properties (or application.yml if YAML is used).'),
(8, 'Which of the following interfaces can be implemented for functionality which runs once per application startup?', 'Boot Intro', '“If you need to run some specific
code once the SpringApplication has started, you can implement the ApplicationRunner or CommandLineRunner interfaces. Both interfaces work in the same way and offer a
single run method, which is called just before SpringApplication.run() completes. The CommandLineRunner interfaces provides access to application arguments as a string array, whereas the ApplicationRunner uses the
ApplicationArguments interface'),
(9, 'Which of the following dependencies are included in the spring-boot-starter-test starter?', 'Boot Testing', 'The spring-boot-starter-test starter
adds the following test-scoped dependencies to the classpath: JUnit - Unit-testing framework. Spring Test and Spring Boot Test
AssertJ - Fluent assertions for Java. Hamcrest - Framework for writing matchers that are both powerful and easy to read.
Mockito - Mocking framework for Java. JSONassert - Tools for verifying JSON Spring Professional Practice Questions 55
representation of data. JsonPath - A Java DSL for reading JSON documents.'),
(10, 'How should configuration classes in src/test/java be annotated so that any declared beans are added to the ApplicationContext in tests?', 'Boot Testing', '@TestConfiguration can be used on
an inner class of a test to customize the primary configuration. When placed on a top-level class, @TestConfiguration indicates that classes in src/
test/java should not be picked up by scanning. You can then import that class.'),
(11, 'Which of the following are limitations of CGLIB Proxies?', 'Container', 'Spring AOP can also use CGLIB
proxies. This is necessary to proxy classes rather than interfaces. Limitations of CGLIB proxies are: Requires the class of the proxied object to be nonfinal.
Subclasses cannot be created from final classes. Requires methods in the proxied object to be nonfinal. Final methods cannot be overridden.
Does not support self-invocations. Spring Professional Practice Questions 69 Self-invocation is where one method of the object
invokes another method on the same object. Requires a third-party library. Not built into the Java language and thus require a
library. The CGLIB library has been Included into Spring, so when using the Spring framework, no additional library is required.'),
(12, 'Where can the @Lazy annotation be placed to cause Spring beans to be instantiated lazily?', 'Container', 'Methods annotated with the @Bean
annotation. Bean will be lazy or not as specified by the boolean parameter to the @Lazy annotation Spring Professional Practice Questions 70 (default value is true). Classes annotated with the @Configuration annotation.
All beans declared in the configuration class will be lazy or not as specified by the boolean parameter to the @Lazy annotation (default value
is true). Classes annotated with @Component or any related stereotype annotation. The bean created from the component class
will be lazy or not as specified by the boolean parameter to the @Lazy annotation (default value is true).');

insert into "springTestAppDB".answers (answer, question_id, correct_answer) values
('Security', 1, '1'), ('File access', 1, '0'), ('Parallelization', 1, '0'), ('Logging', 1, '1'),
('and', 2, '0'), ('or', 2, '0'), ('&&', 2, '1'), ('||', 2, '1'),
('HTTP Request response time', 3, '1'), ('Memory usage', 3, '1'), ('Garbage collection statistics', 3, '1'), ('Number of user sessions', 3, '0'),
('ConnectionHealthIndicator', 4, '0'), ('DiskSpaceHealthIndicator', 4, '1'), ('ApplicationHealthIndicator', 4, '0'), ('ElasticsearchHealthIndicator', 4, '1'),
('ContentNegotiatingViewResolver bean', 5, '1'), ('Use of ConfigurableWebBindingInitializer', 5, '1'), ('Favicon support', 5, '1'), ('Registration of MessageCodesResolver', 5, '1'),
('ClassPathXmlApplicationContext', 6, '0'), ('AnnotationConfigApplicationContext', 6, '1'), ('FileSystemXmlApplicationContext', 6, '0'), ('AnnotationConfigServletWebServerApplication
Context', 6, '0'),
('configuration.properties', 7, '0'), ('application.properties', 7, '1'), ('config.txt', 7, '0'), ('settings.properties', 7, '0'),
('ApplicationRunner', 8, '1'), ('SpringRunner', 8, '0'), ('CommandLineRunner', 8, '1'), ('StartupRunner', 8, '0'),
('Mockito', 9, '1'), ('JsonPath', 9, '1'), ('Cucumber', 9, '0'), ('TestNG', 9, '0'),
('@Configuration', 10, '0'), ('@TestConfiguration', 10, '1'), ('@ConfigurationProperties', 10, '0'), ('@TestContext ', 10, '0'),
('Requires a third-party library', 11, '1'), ('Requires the class to be non-final', 11, '1'), ('Requires the methods to be non-final', 11, '1'), ('Requires an interface to be declared', 11, '0'),
('Methods annotated with @Bean', 12, '1'), ('Classes annotated with @Configuration', 12, '1'), ('Classes annotated with @Component or another
stereotype annotation', 12, '1'), ('Test Classes', 12, '1');