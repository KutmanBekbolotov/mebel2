import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DetailTest{
	
	@Test
	//test width

	public void TestPositiveWidth(){

		Detail detail = new Detail();
		detail.setWidth(-1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> detail.setWidth(-1));

	}

	@Test
	//test height

	public void TestPositiveHeight(){

		Detail detail = new Detail();
		detail.setHeight(-1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> detail.setHeight(-1));
	}

	@Test
	//test quantity

	public void TestPositiveQuantity(){

		Dettail detail = new Detail();
		detail.setQuantity(-1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> detail.setQuantity(-1));
	}
}