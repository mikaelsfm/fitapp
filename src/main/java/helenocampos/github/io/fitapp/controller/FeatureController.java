import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeatureController {
    @Autowired
    private FeatureFlagService featureFlagService;
    @GetMapping("/example")
    public String exampleFeature(Model model) {

        boolean isNewFeatureEnabled =
        featureFlagService.isFeatureEnabled("tutorial-flag");
        if (isNewFeatureEnabled) {
            model.addAttribute("message", "A nova funcionalidade está ativada!");
        } else {
            model.addAttribute("message", "A funcionalidade padrão está em uso.");
        }
        return "featureExample";
    }
}