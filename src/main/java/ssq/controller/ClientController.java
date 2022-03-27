package ssq.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import ssq.dao.TransactionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ssq.service.EnQueueService;

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


}
