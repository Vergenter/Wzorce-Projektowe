public class Client {
    final String Ip;
    public Client(String Ip){
        this.Ip=Ip;
    }
    Message sendMessage(String content){
        return new Message(this.Ip,content);
    }
}
