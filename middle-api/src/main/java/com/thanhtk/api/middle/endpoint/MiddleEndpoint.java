package com.thanhtk.api.middle.endpoint;

import com.thanhtk.api.middle.endpoint.request.ProductRequest;
import com.thanhtk.api.middle.endpoint.response.ProductResponse;
import com.thanhtk.api.middle.exception.HandledException;
import com.thanhtk.api.middle.exception.InternalException;
import com.thanhtk.api.middle.service.ServiceRef;
import com.thanhtk.api.middle.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/products")
public class MiddleEndpoint {

    @Autowired
    private ServiceRef serviceRef;

    @Autowired
    private ProductService productService;

    public Logger logger = LogManager.getLogger(MiddleEndpoint.class);


    @GetMapping(value = "/{id}")
    public ProductResponse create(@PathVariable("id") String id) throws HandledException {

        try{
            ProductRequest productRequest = new ProductRequest();
            productRequest.setId(id);
            ProductResponse userResponse = productService.get(productRequest);
            return userResponse;
        }catch (HandledException e){
            logger.error("Handled error ", e);
            throw e;
        }catch (Exception e){
            logger.error("Error ", e);
            throw new InternalException();
        }
    }


}
