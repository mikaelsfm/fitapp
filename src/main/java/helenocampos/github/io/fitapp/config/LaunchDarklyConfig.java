import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.server.LDClient;
import com.launchdarkly.sdk.server.LDConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchDarklyConfig {
    @Value("${launchdarkly.sdk-key}")
    private String sdkKey;

    // Configuração do LDClient
    @Bean
    public LDClient ldClient() {
        LDConfig config = new LDConfig.Builder().build();
        return new LDClient(sdkKey, config);
    }
    
    // Criação do contexto padrão
    @Bean
    public LDContext ldContext() {
        return LDContext.builder("user-padrao")
        .name("padrao") // Nome do contexto
        .build();
    }
}