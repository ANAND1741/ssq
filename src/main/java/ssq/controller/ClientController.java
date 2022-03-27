package ssq.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import ssq.dao.TransactionObject;
import ssq.entity.TransactionEntity;
import ssq.service.DeQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ssq.service.EnQueueService;

import javax.crypto.SealedObject;

@RestController
public class ClientController {

    @Autowired
    EnQueueService enQueueService;


    @Autowired
    DeQueueService deQueueService;

    @PostMapping("/enqueue")
    public ResponseEntity<String> pushData(RequestEntity<TransactionObject> enqueuedData) {
        boolean success = enQueueService.enqueueInputData(enqueuedData.getBody());
        if(success){
            return new ResponseEntity<>("Pushed successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Not able pushed successfully", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/dequeue")
    public ResponseEntity<TransactionEntity> consumeData(RequestEntity<String> dequeuedData) {
        TransactionEntity transactionEntity = deQueueService.consumeData(dequeuedData.getBody());
        if(transactionEntity != null){
            return new ResponseEntity<>(transactionEntity, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
