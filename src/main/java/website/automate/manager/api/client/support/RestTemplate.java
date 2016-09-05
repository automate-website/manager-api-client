package website.automate.manager.api.client.support;

import static java.text.MessageFormat.format;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import website.automate.manager.api.client.model.Authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RestTemplate {

	private static final RestTemplate INSTANCE = new RestTemplate();
	
	public static RestTemplate getInstance(){
		return INSTANCE;
	}
	
	public RestTemplate(){
		init();
	}
	
	private void init(){
		Unirest.setObjectMapper(new ObjectMapper() {
		    private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = createJacksonObjectMapper();

		    private com.fasterxml.jackson.databind.ObjectMapper createJacksonObjectMapper(){
		    	com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
		    	jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		    	return jacksonObjectMapper;
		    }
		    
		    public <T> T readValue(String value, Class<T> valueType) {
		        try {
		            return jacksonObjectMapper.readValue(value, valueType);
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
		    }

		    public String writeValue(Object value) {
		        try {
		            return jacksonObjectMapper.writeValueAsString(value);
		        } catch (JsonProcessingException e) {
		            throw new RuntimeException(e);
		        }
		    }
		});
		
		// SSL bypass hack
		Unirest.setHttpClient(createHttpClientWithDisabledSSLCheck());
	}
	
	private CloseableHttpClient createHttpClientWithDisabledSSLCheck(){
	    SSLContext sslcontext = null;
        try {
            sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null, new TrustStrategy(){

                        @Override
                        public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                            return true;
                        }
                        
                    })
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("SSL Context can not be created.", e);
        }

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
        return HttpClients.custom()
                         .setSSLSocketFactory(sslsf)
                         .build();
	}
	
	public <T> T performGet(Class<T> clazz, String url, Authentication principal){
		String requestUrl = Constants.getApiBaseUrl() + url;
		HttpResponse<T> response;
        try {
	        response = Unirest
	        		.get(requestUrl)
	        		.basicAuth(principal.getUsername(), principal.getPassword()).asObject(clazz);
        } catch (UnirestException e) {
	        throw new CommunicationException(format("Can not retrieve data from {0}", requestUrl), e);
        }
		return response.getBody();
	}
	
	public <T> T performPost(Class<T> clazz, String url, Authentication principal, Object body){
		String requestUrl = Constants.getApiBaseUrl() + url;
		HttpResponse<T> response;
        try {
	        response = Unirest
	        		.post(requestUrl)
	        		.basicAuth(principal.getUsername(), principal.getPassword())
	        		.header("Content-Type", "application/json")
	        		.body(body)
	        		.asObject(clazz);
        } catch (UnirestException e) {
	        throw new CommunicationException(format("Can not retrieve data from {0}", requestUrl), e);
        }
		return response.getBody();
	}
}
