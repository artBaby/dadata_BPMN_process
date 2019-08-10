package com.artemii.dadata.camunda.Integration;

import com.artemii.dadata.camunda.Model.ResultAddress;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.redcom.lib.integration.api.client.dadata.DaDataException;

@Component
public class AddressRequest {

    private static AddressRequest instance;

    public static synchronized AddressRequest getInstance() {
        if (instance == null) {
            instance = new AddressRequest();
        }
        return instance;
    }

    public ResultAddress getAddressCoords(String requestAddress) throws DaDataException {
        RestTemplate restTemplate = new RestTemplate();
        ResultAddress resultAddress = restTemplate.getForObject("http://localhost:8010/searchAddress?inputAddress=" + requestAddress, ResultAddress.class);
        return resultAddress;
    }
}