package com.thanhtk.service.tracking.config;

import com.thanhtk.service.tracking.db.entity.ConfigurationEntity;
import com.thanhtk.service.tracking.db.repo.ConfigurationRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrackingConfig {

    private static TrackingConfig instanceRef;
    private final ConfigurationRepository configurationRepository;

    public TrackingConfig(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
        initInstanceRef(this);
    }

    private static void initInstanceRef(TrackingConfig t) {
        instanceRef = t;
    }

    public static TrackingConfig getInstanceRef() {
        return instanceRef;
    }


    public String app;

    @PostConstruct
    public void init(){
        List<ConfigurationEntity> configurationEntityList = configurationRepository.findAll();
        Map<String, String> configs = new HashMap<>();
        for (ConfigurationEntity cfg : configurationEntityList) {
            configs.put(cfg.getCfgKey(), cfg.getCfgValue());
        }
        this.app = configs.get("app");

    }


}
