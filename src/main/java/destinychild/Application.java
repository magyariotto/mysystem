package destinychild;

        import com.github.saphyra.authservice.EnableAuthService;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAuthService
public class Application {
    public static void main(String[] arg) {
        SpringApplication.run(Application.class, arg);
    }
}