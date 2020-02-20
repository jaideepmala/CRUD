package jaideep.mala.Spring.CRUD.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisClientImpl implements RestClient {

  private static final Long KEY_TIMEOUT = 1L;
  @Autowired private RedisTemplate<String, Object> redisTemplate;

  @Autowired
  public RedisClientImpl(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void increment(String key) {
    /*Integer counter =  Integer.parseInt(redisTemplate.opsForValue().get(key).toString()) + 1;
    String value = counter.toString();*/
    redisTemplate.opsForValue().increment(key,1L);
    //redisTemplate.opsForValue().set(key,value);
  }

  @Override
  public void setValue(String key, Object value) {
    redisTemplate.opsForValue().set(key, value);
    redisTemplate.expire(key, KEY_TIMEOUT, TimeUnit.DAYS);
  }

  @Override
  public Object getValue(String key) {
    if(redisTemplate.opsForValue().get(key)==null)
      return null;
    return redisTemplate.opsForValue().get(key).toString();
  }

  @Override
  public void deleteKey(String key) {
    redisTemplate.delete(key);
  }

  public Long getExpire(String key) {
    return redisTemplate.getExpire(key);
  }
}
