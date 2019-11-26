public class CommaToDotSeparatorAdapter implements Stringifiable{
    private final Stringifiable stringifiable;
    CommaToDotSeparatorAdapter(Stringifiable stringifiable){
        this.stringifiable=stringifiable;
    }
    public String ToString() {
        return stringifiable.ToString().replace(',','.');
    }
}
