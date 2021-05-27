package com.thanhtk.api.middle.config;

import com.thanhtk.api.middle.db.entity.ConfigurationEntity;
import com.thanhtk.api.middle.db.repo.ConfigurationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MiddleApiConfig {

    private static MiddleApiConfig instanceRef;
    private final ConfigurationRepository configurationRepository;

    public MiddleApiConfig(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
        initInstanceRef(this);
    }

    private static void initInstanceRef(MiddleApiConfig t) {
        instanceRef = t;
    }

    public static MiddleApiConfig getInstanceRef() {
        return instanceRef;
    }


    public String app;

    public String lazadaUrl;

    public String tikiUrl;

    public String shopeeUrl;

    @PostConstruct
    public void init(){
        List<ConfigurationEntity> configurationEntityList = configurationRepository.findAll();
        Map<String, String> configs = new HashMap<>();
        for (ConfigurationEntity cfg : configurationEntityList) {
            configs.put(cfg.getCfgKey(), cfg.getCfgValue());
        }
        this.app = configs.get("app");
        this.lazadaUrl = configs.get("lazadaUrl");
        this.tikiUrl = configs.get("tikiUrl");
        this.shopeeUrl = configs.get("shopeeUrl");

    }


}
