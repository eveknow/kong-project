package com.thanhtk.api.product.endpoint;

import com.thanhtk.api.product.client.middle.Product;
import com.thanhtk.api.product.client.rabbit.ProductEvent;
import com.thanhtk.api.product.client.rabbit.RabbitServiceImpl;
import com.thanhtk.api.product.endpoint.request.ProductRequest;
import com.thanhtk.api.product.endpoint.response.ProductResponse;
import com.thanhtk.api.product.exception.HandledException;
import com.thanhtk.api.product.exception.InternalException;
import com.thanhtk.api.product.log.LogAction;
import com.thanhtk.api.product.log.LogModel;
import com.thanhtk.api.product.log.LogUtil;
import com.thanhtk.api.product.service.ServiceRef;
import com.thanhtk.api.product.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@RestController()
@RequestMapping("/products")
public class ProductEndpoint {

    @Autowired
    private ServiceRef serviceRef;

    @Autowired
    private ProductService productService;

    public Logger logger = LogManager.getLogger(ProductEndpoint.class);

    @Autowired
    private RabbitServiceImpl rabbitService;


    @GetMapping(value = "/{id}")
    public ProductResponse create(@PathVariable("id") String id,
                                  @RequestHeader("x-consumer-username") String userName) throws HandledException {

        LogModel logModel = new LogModel(LogAction.PRODUCT_GET, id);
        Supplier<ProductResponse> supplier = () -> {
            ProductResponse productResponse = new ProductResponse();

            ProductEvent productEvent = new ProductEvent(userName, id);
            rabbitService.sendEvent(productEvent);

            ProductRequest productRequest = new ProductRequest();
            productRequest.setId(id);
            Product product = productService.get(productRequest);
            productResponse.setProduct(product);

            return productResponse;
        };
        return LogUtil.log(logModel, supplier);

    }


}
