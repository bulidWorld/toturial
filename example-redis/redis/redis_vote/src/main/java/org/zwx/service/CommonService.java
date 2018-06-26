package org.zwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.zwx.utils.JsonUtils;

import java.util.Map;

@Component
public class CommonService {

    public static final String INC_SEQ = "SEQ_INC:";

    public static final Long INC_SPACE = 1L;

    @Autowired
    private RedisTemplate redisTemplate;


    public Long generateLongKey() {
        return redisTemplate.opsForValue().increment(INC_SEQ, INC_SPACE);
    }

    public void saveHData(Object key, Object val) {
        redisTemplate.opsForHash().putAll(key, JsonUtils.cvrtObj2Map(val));
    }

    public <T> T getHData(Object key, Class<T> cls) {
        Map map = redisTemplate.opsForHash().entries(key);
        return JsonUtils.cvrtmap2Obj(map, cls);
    }
}
