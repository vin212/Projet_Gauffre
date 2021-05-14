package runner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AppRunnerTest {

	@Test
	public void testMain() {
		AppRunner.main(null);
	}
}