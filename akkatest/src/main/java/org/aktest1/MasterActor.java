package org.aktest1;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * Created by zgl on 17-10-11.
 */
public class MasterActor extends UntypedActor {
    ActorRef master;

    @Override
    public void preStart() throws Exception {
        final ActorRef master = getContext().actorOf(Props.create(WorkerActor.class), "workeractor");
        master.tell(Arrays.asList("https://www.baidu.com", "https://www.taobao.com",
                "http://www.csdn.com", "http://www.ctrip.com", "https://www.hao123.com"), getSelf());
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        JSONArray jsonArray = JSONArray.parseArray(message.toString());
        JSONObject jsonObject = JSON.parseObject(jsonArray.get(0).toString());
        System.out.println("一共" + jsonObject.get("totalpage") + "网页,共计" + jsonObject.get("totalbytes") + "个字节");
    }
}
