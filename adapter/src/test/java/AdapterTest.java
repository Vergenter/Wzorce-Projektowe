import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AdapterTest {

    @Test
    public void StringToNumber(){
        final float expected=10.08f;
        StringNumber stringNumber= new StringNumber(String.valueOf(expected));
        try {
            float  result= StringNumberConverter.stringToNumber(stringNumber);
            assertEquals(expected, result);
        } catch (Exception e){
            fail();
        }

    }
    @Test
    public void StringWithCommaSeparatorToNumber(){
        final float expected=10.08f;
        final String stringWithCommaDecimalSeparator="10,08";
        StringNumber stringNumber= new StringNumber(stringWithCommaDecimalSeparator);
        try {
            float  result= StringNumberConverter.stringToNumber(stringNumber);
            fail();
        } catch (NumberFormatException e){
            return;
        } catch (Exception e){
            fail();
        }
    }
    @Test
    public void AdapterForStringWithCommaSeparatorToNumber() {
        final float expected=10.08f;
        final String stringWithCommaDecimalSeparator="10,08";
        StringNumber stringNumber= new StringNumber(stringWithCommaDecimalSeparator);
        CommaToDotSeparatorAdapter adapter= new CommaToDotSeparatorAdapter(stringNumber);
        try {
            float result= StringNumberConverter.stringToNumber(adapter);
            assertEquals(expected, result);
        } catch (NumberFormatException e){
            fail();
        } catch (Exception e){
            fail();
        }
    }
}
