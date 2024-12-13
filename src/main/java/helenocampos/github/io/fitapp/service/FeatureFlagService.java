import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.server.LDClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureFlagService {
    @Autowired
    private LDClient ldClient;

    @Autowired
    private LDContext ldContext;
    public boolean isFeatureEnabled(String featureKey) {
        return ldClient.boolVariation(featureKey, ldContext, false); // Retorna false por padrão se a flag não existir
    }
}