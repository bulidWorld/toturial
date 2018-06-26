package org.zwx.common;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zwx.TestParent;
import org.zwx.entity.Article;
import org.zwx.service.CommonService;

import java.util.Map;

public class CommonServiceTest extends TestParent {

    @Autowired
    private CommonService commonService;


    @Test
    public void testSaveEntity() {
        Article article = Article.ArticleBuilder
                .anArticle()
                .id(commonService.generateLongKey())
                .content("hello article")
                .build();
        commonService.saveHData(article.getId(), article);
        System.out.println(article.getId());
    }

    @Test
    public void testGetEntity() {
        Map map = commonService.getHData(2L, Map.class);
        Assert.assertNotNull(map);
        System.out.println(map);
    }


}
