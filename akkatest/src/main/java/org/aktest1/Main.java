package org.aktest1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
/**
 * Created by zgl on 17-10-11.
 */
public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("test");
        ActorRef a = system.actorOf(Props.create(MasterActor.class),"masteractor");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
    }


}
