package com.example.kanishsmpp;

import com.cloudhopper.smpp.type.SmppConnectionConfiguration;
import com.github.mikesafonov.smpp.api.SenderManager;
import com.github.mikesafonov.smpp.api.StrategySenderManager;
import com.github.mikesafonov.smpp.core.dto.Message;
import com.github.mikesafonov.smpp.core.dto.MessageResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class MTSender {


    @Autowired
    public  SenderManager senderManager;

    @PostConstruct
    public void sendSMS() {

        log.info("test mt ...............................................");
        MessageResponse messageResponse = senderManager
                .getClient()
                .send(Message.
                        simple("text")
                        .from("SC").to("msisdn").build());
        log.info("messageId: {}",messageResponse.getSmscMessageID());
    }

}
