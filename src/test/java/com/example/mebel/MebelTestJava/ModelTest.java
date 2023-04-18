import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ModelTest{

	@Test
	//Test model object
	
	public void TestConstructor(){

		int expectedWidth = 10;
        int expectedHeight = 20;
        LocalDate expectedDate = LocalDate.now();

        Model model = new Model(expectedWidth, expectedHeight, expectedDate);

        Assertions.assertEquals(expectedWidth, model.getWidth());
        Assertions.assertEquals(expectedHeight, model.getHeight());
        Assertions.assertEquals(expectedDate, model.getLocalDate());
	}

	@Test
	//Test to string works correct

    public void testToString() {

        int width = 10;
        int height = 20;
        LocalDate date = LocalDate.now();
        String expectedString = "Model(id=null, width=" 
        							   + width + ", height=" 
        							   + height + ", quantity=0, description=null, name=null, localDate=" 
        							   + date + ")";

        Model model = new Model(width, height, date);

        Assertions.assertEquals(expectedString, model.toString());
}