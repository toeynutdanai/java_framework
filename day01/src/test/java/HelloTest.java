import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloTest {

	@Test
	void case01() {
		// Arrange �����
		Hello hello = new Hello();
		// Act ���¡
		String actualResult = hello.sayHi("test");
		// Assert ��Ǩ�ͺ
		assertEquals("Hello, test", actualResult);
	}

}
