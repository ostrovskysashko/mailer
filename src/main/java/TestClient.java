
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;



public class TestClient {

    private HttpClient client = HttpClients.custom().build();

    private String getUrl() {
        return "https://www.mailinator.com/fetch_email?msgid=qc_1487_autotestde-1599733617-107002&zone=public";
    }

    public Response getMessage() {
        HttpUriRequest request = RequestBuilder.get()
                .setUri(getUrl())
                .setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .setHeader("X-Requested-With", "XMLHttpRequest")
                .setHeader("referef", "https://www.mailinator.com/v3/index.jsp?zone=public&query=qc_1487_autotestde")
                .setHeader("accept", "*/*")
                .addParameter("msgid", "qc_1487_autotestde-1599733617-107002")
                .addParameter("zone", "public")

                .build();

        return getResult(request);
    }



    private Response getResult(HttpUriRequest request) {
        try {
            HttpResponse response = client.execute(request);
            Response result = new Response(response);
            System.out.println("Result: " + result.getBody());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
