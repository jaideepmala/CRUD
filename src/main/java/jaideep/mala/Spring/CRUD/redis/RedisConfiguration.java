package jaideep.mala.Spring.CRUD.redis;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ConfigurationProperties(prefix = "spring.redis.sentinel")
@PropertySources(value = {@PropertySource("classpath:application.properties")})

public class RedisConfiguration {


  /*  private String master;
    private List<String> nodes;
    private Integer port;*/

   /* public RedisConfiguration(String master, List<String> nodes, Integer port) {
        this.master = master;
        this.nodes = nodes;
        this.port = port;
    }
    public RedisConfiguration() {
    }
*/

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

      /*  RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration().master(master);
        for (String node : nodes) {
            RedisNode redisNode = new RedisNode(node, port);
            sentinelConfig.addSentinel(redisNode);
        }
        JedisConnectionFactory factory = new JedisConnectionFactory(sentinelConfig);
        return factory;*/
      return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    /*public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }*/
}
