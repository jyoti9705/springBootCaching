package com.example.cache.libraryapplication.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
        return  new ConcurrentCustomizer();
    }

    private class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(false);
            cacheManager.setStoreByValue(true);
        }
    }
}
