package com.wuchenyv1990.client.ribbon.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.ZonePreferenceServerListFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * custom ribbon config, has not used here
 * 来自官网配置样例
 */
//@Configuration
//@RibbonClient(name = "ribbonClient", configuration = RibbonCliCfg.class) 要确保不被boot全局扫描的@Configuration
//@RibbonClients(defaultConfiguration = DefaultRibbonConfig.class) 为所有ribbon提供统一配置
public class RibbonCustomCfg {

    // 单个配置

//    @Configuration
    protected static class RibbonCliCfg {
        @Bean
        public ZonePreferenceServerListFilter serverListFilter() {
            ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
            filter.setZone("myTestZone");
            return filter;
        }

        @Bean
        public IPing ribbonPing() {
            return new PingUrl();
        }
    }

    // 全局配置

    public static class BazServiceList extends ConfigurationBasedServerList {
        public BazServiceList(IClientConfig config) {
            super.initWithNiwsConfig(config);
        }
    }

//    @Configuration
    class DefaultRibbonConfig {

        @Bean
        public IRule ribbonRule() {
            return new BestAvailableRule();
        }

        @Bean
        public IPing ribbonPing() {
            return new PingUrl();
        }

        @Bean
        public ServerList<Server> ribbonServerList(IClientConfig config) {
            return new RibbonCustomCfg.BazServiceList(config);
        }

        @Bean
        public ServerListSubsetFilter serverListFilter() {
            ServerListSubsetFilter filter = new ServerListSubsetFilter();
            return filter;
        }

    }

}
