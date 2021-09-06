import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloTest {

	@Test
	void case01() {
		// Arrange เตรียม
		Hello hello = new Hello();
		// Act เรียก
		String actualResult = hello.sayHi("test");
		// Assert ตรวจสอบ
		assertEquals("Hello, test", actualResult);
	}

}
