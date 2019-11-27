import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {
    private Server server;
    private IReceiver receiver;
    private Client user;


    @BeforeEach
    public void prepareUserAndServer(){
        this.server= new Server();
        this.receiver=this.server;
        this.user= new Client("IP");
    }
    @Test
    public void serverReceivedMessage() {
        final String messageContent="expected";
        Message message=user.sendMessage(messageContent);
        receiver.ReceiveMessage(message);
        assertTrue(server.getLog().contains(message));
    }
    @Test
    public void decoratorInterceptValue() {
        int expectedUserMaleficence=1;
        MossadInterceptor interceptor=new MossadInterceptor(this.receiver);
        this.receiver=interceptor;
        Message message=user.sendMessage("antisemitism");
        receiver.ReceiveMessage(message);
        assertTrue(server.getLog().contains(message));
        assertEquals(expectedUserMaleficence,interceptor.UserMaleficence.get(this.user.Ip));
    }
    @Test
    public void nestedDecoratorInterceptValue() {
        int expectedUserMaleficence=1;
        MossadInterceptor mossadInterceptor=new MossadInterceptor(this.receiver);
        this.receiver=mossadInterceptor;
        CIAInterceptor ciaInterceptor=new CIAInterceptor(this.receiver);
        this.receiver=ciaInterceptor;

        Message message=user.sendMessage("antisemitismNigger");
        receiver.ReceiveMessage(message);
        assertTrue(server.getLog().contains(message));
        assertEquals(expectedUserMaleficence,mossadInterceptor.UserMaleficence.get(this.user.Ip));
        assertEquals(expectedUserMaleficence,ciaInterceptor.UserMaleficence.get(this.user.Ip));
    }
}


