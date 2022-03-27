package ssq.service;

import ssq.entity.TransactionEntity;
import ssq.manager.TransacManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SealedObject;

@Service
public class DeQueueService {

    @Autowired
    private TransacManager transactionManager;

    @Autowired
    private EncryptionService encryptionService;

    public TransactionEntity consumeData(String dequeuedData){
        TransactionEntity transactionEntity = encryptionService.decryptData(dequeuedData);
        transactionManager.updateTransaction(transactionEntity);
        return transactionEntity;
    }


}
