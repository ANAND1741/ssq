package ssq.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ssq.dao.TransactionObject;

import javax.crypto.SealedObject;

@Service
public class EnQueueService {

    @Autowired
    EncryptionService encryptionService;

    @Autowired
    ExternalConnector externalConnector;

    public boolean enqueueInputData(TransactionObject transactionObject){
        String sealedObject = encryptionService.encryptData(transactionObject);
        HttpStatus httpStatus = externalConnector.pushData(sealedObject);
       return httpStatus.is2xxSuccessful();
    }

}
