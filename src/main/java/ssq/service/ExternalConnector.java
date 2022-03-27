package ssq.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class ExternalConnector {

    ExternalConnector(){
    }

    public HttpStatus pushData(String sealedObject) {
        return HttpStatus.OK;
    }

}
