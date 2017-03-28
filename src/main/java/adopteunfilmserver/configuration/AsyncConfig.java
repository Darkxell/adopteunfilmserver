package adopteunfilmserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AsyncConfig
{

	// What do I do here? Nothing? Apparently. Long live Spring.
	// Srsly thought this is to enable Async methods such as UserController.calculateNextSuggestion(user)

}
