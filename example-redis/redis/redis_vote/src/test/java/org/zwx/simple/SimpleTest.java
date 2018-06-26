package org.zwx.simple;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zwx.TestParent;
import org.zwx.entity.Article;
import org.zwx.service.CommonService;
import org.zwx.utils.JsonUtils;

import java.util.*;

public class SimpleTest extends TestParent {

    @Autowired
    private CommonService commonService;


    @Test
    public void testConn() {
        Set<String> set = redisTemplate.keys("*");
        Assert.assertNotEquals(set.size(), 0);
        System.out.println(set.size());
    }

    @Test
    public void testIncre() {
        Long val1 = redisTemplate.opsForValue().increment("SEQ", 1);
        Long val2 = redisTemplate.opsForValue().increment("SEQ", 1);
        System.out.println("val1:" + val1 + ",val2:" + val2);
        Assert.assertEquals(val2 - val1, 1);
    }


    @Test
    public void testSaveHash() {
        Map<String, String> map = new HashMap<>();
        map.put("key3", "val1");
        map.put("key4", "val2");

        commonService.saveHData("test:1098", map);

    }


    @Test
    public void testGetHash() {
        Map map = redisTemplate.opsForHash().entries("test:1098");
        System.out.println(map);
    }

    @Test
    public void testJson() {
        Map<String, Object> prop = new HashMap<>();

        prop.put("key", Arrays.asList("str1", "str2"));
        Article article = Article.ArticleBuilder.anArticle().content("abc").id(1L).props(prop).build();
        try {
            Map map = JsonUtils.cvrtObj2Map(article);
            Article article1 = JsonUtils.cvrtmap2Obj(map, Article.class);
            System.out.println(article1.getProps());
        } finally {

        }
    }

}
