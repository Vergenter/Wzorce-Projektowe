package singleton;

import java.util.ArrayList;
import java.util.List;

public class Market {
    ClientSession session;
    List<Shop> shops= new ArrayList<Shop>();
    Market(){
        session=ClientSession.getInstance();
        shops.add(new FoodShop());
        shops.add(new CarShop());
    }
    boolean bidCar(int money){
        Boolean result=shops.get(1).getPayment(money);
        if(result){
            session.PurchaseList.add(shops.get(1).getBoughtItem());
        }
        return result;
    }
    boolean bidFood(int money){
        Boolean result=shops.get(0).getPayment(money);
        if(result){
            session.PurchaseList.add(shops.get(0).getBoughtItem());
        }
        return result;
    }

}
