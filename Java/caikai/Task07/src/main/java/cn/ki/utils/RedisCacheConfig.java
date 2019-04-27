package cn.ki.utils;

import java.lang.reflect.Method;

import org.apache.ibatis.jdbc.Null;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 通过spring管理redis缓存配置
 *
 * @author Administrator
 *
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
	private volatile JedisConnectionFactory jedisConnectionFactory;
	private volatile RedisTemplate<String, String> redisTemplate;
	private volatile RedisCacheManager redisCacheManager;

	public RedisCacheConfig() {
		super();
	}

	/**
	 * 带参数的构造方法 初始化所有的成员变量
	 *
	 * @param jedisConnectionFactory
	 * @param redisTemplate
	 * @param redisCacheManager
	 */
	public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate,
							RedisCacheManager redisCacheManager) {
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}

	public JedisConnectionFactory getJedisConnecionFactory() {
		return jedisConnectionFactory;
	}

	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				//sb.append(target.getClass().getName());
				sb.append(method.getName());
				if(objects.length != 0){
					sb.append("_");
					for (Object obj : objects) {
						sb.append(obj.toString());
					}
				}
				return sb.toString();
			}
		};
	}

	public static void main(String[] args) {
//		Double i = 6d;
//		Double o = new Double(6d);
//		Integer o = new Integer(2);
//		System.out.println(i.equals(o));
//		int a = 1;
//		int b = 2;
//		a = ++a+(--b)+(a-b)+b;
//		System.out.println(a);
		String arg = new String();
		for(int i=0;i<6;i++){
			arg+=(int)(1+Math.random()*8);

		}
		System.out.println(arg);
	}


}