package com.wuchenyv1990.rabbitmq.rec;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;

import java.io.IOException;

public class Common {

    public static void ack(Channel channel, long tag, Logger log) {
        try {
            channel.basicAck(tag,false);
        } catch (IOException e) {
            log.error("Ack msg failed.", e);
        }

    }

}
