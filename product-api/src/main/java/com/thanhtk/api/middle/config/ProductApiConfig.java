package com.thanhtk.api.middle.config;

import com.thanhtk.api.middle.db.entity.ConfigurationEntity;
import com.thanhtk.api.middle.db.repo.ConfigurationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductApiConfig {

    private static ProductApiConfig instanceRef;
    private final ConfigurationRepository configurationRepository;

    public ProductApiConfig(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
        initInstanceRef(this);
    }

    private static void initInstanceRef(ProductApiConfig t) {
        instanceRef = t;
    }

    public static ProductApiConfig getInstanceRef() {
        return instanceRef;
    }


    public String app;

    public String middleUrl;

    @PostConstruct
    public void init(){
        List<ConfigurationEntity> configurationEntityList = configurationRepository.findAll();
        Map<String, String> configs = new HashMap<>();
        for (ConfigurationEntity cfg : configurationEntityList) {
            configs.put(cfg.getCfgKey(), cfg.getCfgValue());
        }
        this.app = configs.get("app");
        this.middleUrl = configs.get("middleUrl");

    }


}
