package website.automate.manager.api.client;

import static java.util.Arrays.asList;

import java.util.List;

import website.automate.manager.api.client.model.Authentication;
import website.automate.manager.api.client.model.Box;
import website.automate.manager.api.client.support.RestTemplate;

public class BoxRetrievalRemoteService {

    private static final BoxRetrievalRemoteService INSTANCE = new BoxRetrievalRemoteService();

    public static BoxRetrievalRemoteService getInstance() {
        return INSTANCE;
    }

    private RestTemplate restTemplate = RestTemplate.getInstance();

    public List<Box> getBoxesByPrincipal(Authentication principal) {
        return asList(restTemplate.performGet(Box[].class, "/public/box", principal));
    }
}
