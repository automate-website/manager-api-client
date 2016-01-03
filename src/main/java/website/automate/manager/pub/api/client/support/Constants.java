package website.automate.manager.pub.api.client.support;

public class Constants {

    private static final String 
        PROPERTY_NAME_BASE_URL = "website.automate.base-url",
        DEFAULT_BASE_URL = "https://automate.website";
    
    public static final String BUILDER_TITLE = "Automate Website Execution";
    
    private static String BASE_URL;
	
	public static String getAppBaseUrl(){
	    return createOrGetBaseURL() + "/app";
	}
	
	public static String getApiBaseUrl(){
	    return createOrGetBaseURL() + "/api";
	}
	
	public static void setBaseUrl(String baseUrl){
	    BASE_URL = baseUrl;
	}
	
	private static String createOrGetBaseURL(){
	    if(BASE_URL == null){
	        BASE_URL = System.getProperty(PROPERTY_NAME_BASE_URL, DEFAULT_BASE_URL);
	    }
	    return BASE_URL;
	}
}
