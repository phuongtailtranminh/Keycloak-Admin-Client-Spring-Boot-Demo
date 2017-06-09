package me.phuongtm;

import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by phuongtran on 6/9/17.
 * More info: http://programtalk.com/java-api-usage-examples/org.keycloak.admin.client.resource.UserResource/
 */
public class KeyCloakUtil {

    public static String getCreatedId(Response response) {
        URI location = response.getLocation();
        if (!response.getStatusInfo().equals(Response.Status.CREATED)) {
            Response.StatusType statusInfo = response.getStatusInfo();
            throw new RuntimeException("Create method returned status " +
                    statusInfo.getReasonPhrase() + " (Code: " + statusInfo.getStatusCode() + "); expected status: Created (201)");
        }
        if (location == null) {
            return null;
        }
        String path = location.getPath();
        return path.substring(path.lastIndexOf('/') + 1);
    }

}
