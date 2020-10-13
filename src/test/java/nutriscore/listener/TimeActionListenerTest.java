package nutriscore.listener;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Test class for TimeActionListener.
 */
public class TimeActionListenerTest {

	@Test
	public void requestRandomNumberTest() throws Exception {
		
		TimerActionListener listener = new TimerActionListener();
		int value = listener.requestRandomNumber();
		
		Assert.assertTrue(value >= 0);
		Assert.assertTrue(value <= 4);
		
	}
	
}
