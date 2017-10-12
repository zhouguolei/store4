package org.aktest1;

import akka.actor.UntypedActor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

/**
 * Created by zgl on 17-10-11.
 */
public class WorkerActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Throwable {
        List<String> list = (List<String>) message;
        int pagelength = 0;
        HttpGet httpGet;
        CloseableHttpResponse response = null;
        CloseableHttpClient client = HttpClients.createDefault();
        for (int i = 0; i < list.size(); i++) {
            String url = list.get(i);
            httpGet = new HttpGet(url);
            String body = "";
            try {
                response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    body = EntityUtils.toString(entity, "utf-8");
                }
                EntityUtils.consume(entity);
                response.close();
                pagelength += body.getBytes().length;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Message message1 = new Message(list.size(), pagelength);
        JSONArray jsonArray = new JSONArray();
        String json;
        json = JSON.toJSONString(message1);
        jsonArray.add(json);
        getSender().tell(jsonArray, getSelf());
    }
}
