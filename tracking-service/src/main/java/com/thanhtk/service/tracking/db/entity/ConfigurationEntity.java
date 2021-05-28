package com.thanhtk.service.tracking.db.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "configuration", catalog = "")
public class ConfigurationEntity {
    private int id;
    private String cfgKey;
    private String cfgValue;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cfg_key")
    public String getCfgKey() {
        return cfgKey;
    }

    public void setCfgKey(String cfgKey) {
        this.cfgKey = cfgKey;
    }

    @Basic
    @Column(name = "cfg_value")
    public String getCfgValue() {
        return cfgValue;
    }

    public void setCfgValue(String cfgValue) {
        this.cfgValue = cfgValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigurationEntity that = (ConfigurationEntity) o;
        return id == that.id && Objects.equals(cfgKey, that.cfgKey) && Objects.equals(cfgValue, that.cfgValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cfgKey, cfgValue);
    }
}
