package transformer;

import org.junit.Assert;
import org.junit.Test;

public class StringTransformerTest {

    @Test
    public void testTransformStringWithNotEmptyInput() {

        //Given
        StringTransformer transformer = new StringTransformer();
        String input = "Hello World!";

        //When
        String expected = "HeLlO WoRlD!";
        String result = transformer.transformString(input);

        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTransformStringWithEmptyInput() {

        //Given
        StringTransformer transformer = new StringTransformer();
        String input = " ";

        //When & Then
        Assert.assertThrows(IllegalArgumentException.class,
                () -> transformer.transformString(input));
    }
}