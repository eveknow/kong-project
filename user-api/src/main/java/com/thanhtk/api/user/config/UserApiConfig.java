package com.thanhtk.api.user.config;

import com.thanhtk.api.user.db.entity.ConfigurationEntity;
import com.thanhtk.api.user.db.repo.ConfigurationRepository;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserApiConfig {

    private static UserApiConfig instanceRef;
    private final ConfigurationRepository configurationRepository;

    public UserApiConfig(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
        initInstanceRef(this);
    }

    private static void initInstanceRef(UserApiConfig t) {
        instanceRef = t;
    }

    public static UserApiConfig getInstanceRef() {
        return instanceRef;
    }


    public String app;

    public String kongAdminUrl;

    public String kongProxyUrl;

    @PostConstruct
    public void init(){
        List<ConfigurationEntity> configurationEntityList = configurationRepository.findAll();
        Map<String, String> configs = new HashMap<>();
        for (ConfigurationEntity cfg : configurationEntityList) {
            configs.put(cfg.getCfgKey(), cfg.getCfgValue());
        }
        this.app = configs.get("app");
        this.kongAdminUrl = configs.get("kongAdminUrl");
        this.kongProxyUrl = configs.get("kongProxyUrl");

    }


}
