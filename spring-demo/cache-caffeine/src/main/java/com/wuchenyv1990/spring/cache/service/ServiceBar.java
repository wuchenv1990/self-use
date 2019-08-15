package com.wuchenyv1990.spring.cache.service;

import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceBar {

    @Autowired
    @Qualifier("loadingCacheA")
    LoadingCache<String, String> loadingCacheA;

    public String getValue(String key) {
        return loadingCacheA.get(key);
    }

}
