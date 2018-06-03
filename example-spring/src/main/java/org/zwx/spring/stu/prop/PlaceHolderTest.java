package org.zwx.spring.stu.prop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.zwx.dao.DatabaseService;

import java.util.Map;
import java.util.Properties;

public class PlaceHolderTest extends PropertyPlaceholderConfigurer {

    @Autowired
    DatabaseService dataBaseService;


    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        //数据库查询配置项
        Map<String, String> databaseConfigMap = dataBaseService.getConfig();
        //配置项合并到Properties
        props.putAll(databaseConfigMap);
        //调用父类的方法替换占位符的值
        super.processProperties(beanFactoryToProcess, props);
    }
}
