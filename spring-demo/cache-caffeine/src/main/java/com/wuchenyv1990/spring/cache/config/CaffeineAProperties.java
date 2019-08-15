package com.wuchenyv1990.spring.cache.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cache.caffeine.a")
public class CaffeineAProperties {

    static final int UNSET_INT = -1;

    long maximumSize = UNSET_INT;
    long maximumWeight = UNSET_INT;
    int initialCapacity = UNSET_INT;

    long refreshNanos = UNSET_INT;
    long expireAfterWrite = UNSET_INT;
    long expireAfterAccess = UNSET_INT;

    public long getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(long maximumSize) {
        this.maximumSize = maximumSize;
    }

    public long getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(long maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public long getRefreshNanos() {
        return refreshNanos;
    }

    public void setRefreshNanos(long refreshNanos) {
        this.refreshNanos = refreshNanos;
    }

    public long getExpireAfterWrite() {
        return expireAfterWrite;
    }

    public void setExpireAfterWrite(long expireAfterWrite) {
        this.expireAfterWrite = expireAfterWrite;
    }

    public long getExpireAfterAccess() {
        return expireAfterAccess;
    }

    public void setExpireAfterAccess(long expireAfterAccess) {
        this.expireAfterAccess = expireAfterAccess;
    }
}
