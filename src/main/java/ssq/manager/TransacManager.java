package ssq.manager;

import ssq.entity.TransactionEntity;
import ssq.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacManager {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionEntity updateTransaction(TransactionEntity transactionEntity){
        return transactionRepository.save(transactionEntity);

    }
}
