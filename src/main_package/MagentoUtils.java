package main_package;

public class MagentoUtils {
	final public String BASE_URL = "https://magento.softwaretestingboard.com/";
	
	public static void holdScreen(long n) {
		try {
			Thread.sleep(n);
		} catch (Exception e) {
			
		}
	}
}
