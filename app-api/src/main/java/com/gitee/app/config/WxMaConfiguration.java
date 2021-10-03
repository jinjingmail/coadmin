package com.gitee.app.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaRedisBetterConfigImpl;
import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.redis.JedisWxRedisOps;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.stream.Collectors;

/**
 * wechat mini-application configuration
 *
 * @author jinjin
 */
@AllArgsConstructor
@Configuration
@EnableConfigurationProperties(WxMaProperties.class)
public class WxMaConfiguration {
    private final WxMaProperties properties;

    @Bean
    public WxMaService wxMaService() {
        final List<WxMaProperties.LiteappConfig> configs = this.properties.getConfigs();
        if (configs == null) {
            throw new RuntimeException("大哥，拜托先看下项目首页的说明（readme文件），添加下相关配置，注意别配错了！");
        }

        WxMaService service = new WxMaServiceImpl();
        service.setMultiConfigs(configs
                .stream().map(a -> {

                    WxMaDefaultConfigImpl configStorage;
                    if (this.properties.isUseRedis()) {
                        final WxMaProperties.RedisConfig redisConfig = this.properties.getRedisConfig();
                        JedisPoolConfig poolConfig = new JedisPoolConfig();
                        JedisPool jedisPool = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
                                -1, redisConfig.getPassword());
                        configStorage = new WxMaRedisBetterConfigImpl(new JedisWxRedisOps(jedisPool), a.getAppId());
                    } else {
                        configStorage = new WxMaDefaultConfigImpl();
                    }

                    configStorage.setAppid(a.getAppId());
                    configStorage.setSecret(a.getSecret());
                    configStorage.setToken(a.getToken());
                    configStorage.setAesKey(a.getAesKey());
                    return configStorage;
                }).collect(Collectors.toMap(WxMaDefaultConfigImpl::getAppid, a -> a, (o, n) -> o)));
        return service;
    }

}
