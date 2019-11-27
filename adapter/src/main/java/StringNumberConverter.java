public class StringNumberConverter {
    public static float stringToNumber(Stringifiable potentialNumber) throws NumberFormatException{
        return Float.parseFloat(potentialNumber.ToString());
    }
}
