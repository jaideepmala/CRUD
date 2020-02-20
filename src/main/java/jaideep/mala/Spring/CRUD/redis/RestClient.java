package jaideep.mala.Spring.CRUD.redis;

public interface RestClient {

  void setValue(final String key, Object value);

  Object getValue(final String key);

  void increment(String key);

  void deleteKey(final String key);
}
