package com.artemii.dadata.camunda;

import com.artemii.dadata.camunda.Integration.AddressRequest;
import com.artemii.dadata.camunda.Model.ResultAddress;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("translateAddressService")
public class TranslateAddressService implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(AddressRequest.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String requestAddress = (String) delegateExecution.getVariable("address");
        logger.info("address value from the form: " + requestAddress);

        ResultAddress resultAddress = AddressRequest.getInstance().getAddressCoords(requestAddress);
        logger.info(resultAddress.toString());

        delegateExecution.setVariable("latitude", resultAddress.getLatitude().toString());
        delegateExecution.setVariable("longitude", resultAddress.getLongitude().toString());
    }
}
