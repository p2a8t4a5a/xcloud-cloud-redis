@SpringBootApplication
@EnableEurekaServer
@EnableHystrixDashboard
public class ApplicationRegistry {
 public static void main(String[] args) {
  new SpringApplicationBuilder(Application.class).web(true).run(args);
 }
}