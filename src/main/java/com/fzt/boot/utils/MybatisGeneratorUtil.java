package com.fzt.boot.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description mybatis自动生产基础类工具
 * @Author fengzt
 * @Date 2018/12/26
 * @Version 1.0
 **/
public class MybatisGeneratorUtil {

    public static void main(String[] args) throws Exception {
        System.out.println("Generator start ...");
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        File configFile = new File(MybatisGeneratorUtil.class.getResource("/generator/generatorConfig.xml").getFile());
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("Generator success!");
    }

}
