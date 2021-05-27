package com.thanhtk.service.tracking.endpoint;

import com.thanhtk.service.tracking.endpoint.request.ProductRequest;
import com.thanhtk.service.tracking.endpoint.response.ProductResponse;
import com.thanhtk.service.tracking.exception.HandledException;
import com.thanhtk.service.tracking.exception.InternalException;
import com.thanhtk.service.tracking.service.ServiceRef;
import com.thanhtk.service.tracking.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/products")
public class ProductEndpoint {

    @Autowired
    private ServiceRef serviceRef;

    @Autowired
    private ProductService productService;

    public Logger logger = LogManager.getLogger(ProductEndpoint.class);


    @GetMapping(value = "/{id}")
    public ProductResponse create(@PathVariable("id") String id) throws HandledException {

        try{
            ProductResponse productResponse = new ProductResponse();
            ProductRequest productRequest = new ProductRequest();
            productRequest.setId(id);
            return productResponse;
//        }catch (HandledException e){
//            logger.error("Handled error ", e);
//            throw e;
        }catch (Exception e){
            logger.error("Error ", e);
            throw new InternalException();
        }
    }


}
