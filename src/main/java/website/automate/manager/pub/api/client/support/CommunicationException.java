package website.automate.manager.pub.api.client.support;

public class CommunicationException extends RuntimeException {

    private static final long serialVersionUID = 5338303168238688676L;
    
    public CommunicationException(String msg, Throwable e){
    	super(msg, e);
    }

}
