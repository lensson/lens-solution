package com.lens.platform;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.lens.common.entity.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Desc:
 * Mybatis Code Generator
 *
 * @author Lens Chen
 * @create 2020-10-12 12:10 PM
 */
@Slf4j
public class MBPGodeGenerator {

    // Global Auto Code Generator
    private static AutoGenerator mpg = new AutoGenerator();
    // Global Config
    private static  GlobalConfig gc = new GlobalConfig();

    private static final String ProjectPath = System.getProperty("user.dir");
    private static final String Author = "Lens Chen";

    /**
     * Datasource Config
     */
    private static final String URL = "jdbc:mysql://localhost:33306/platform?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
    private static final String DBUser = "lens";
    private static final String DBPassword = "lens";
    private static final String DBDriver = "com.mysql.cj.jdbc.Driver";

    /**
     * Package Config
     */
    private static final String PackageParent = "com.lens.platform";

    /**
     * Strategy Config
     */
    private static final String TablePrefix = "platform_";

    private static String TableName = "user";

    /**
     *  Template Config
     */
    private static final String TemplatePath = "/templates/";
    private static final String ControllerTemplate = "controller.java";
    private static final String EntityTemplate = "entity.java";
    private static final String MapperTemplate = "mapper.java";
    private static final String ServiceTemplate = "service.java";
    private static final String ServiceImplTemplate = "serviceImpl.java";
    private static final String MapperXmlTemplate = "mapper.xml";
    private static String ModuleName = "";



    public static void main(String args[]) {

        TableName = "user";
        ModuleName = "security";


        setDataSource();

        //set global and package config
        setGlobalConfig();

        setPackageConfig();

        setTemplate();

        setStrategy();

        setExtra();

        mpg.execute();


    }

    private static void setExtra(){
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(TemplatePath + MapperXmlTemplate+".vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                java.net.URL urlPath = Thread.currentThread().getContextClassLoader().getResource("");
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return urlPath.getPath() + "/src/main/resources/mapper/" + ModuleName
                        + File.separator + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        mpg.setCfg(cfg);
    }

    private static void setTemplate(){
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(TemplatePath + MapperXmlTemplate);
        templateConfig.setEntity(TemplatePath + EntityTemplate);
        templateConfig.setMapper(TemplatePath + MapperTemplate);
        templateConfig.setService(TemplatePath + ServiceTemplate);
        templateConfig.setServiceImpl(TemplatePath + ServiceImplTemplate);
        templateConfig.setController(TemplatePath + ControllerTemplate);
        mpg.setTemplate(templateConfig);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
    }

    private static void setStrategy() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setSuperEntityClass(BaseEntity.class, NamingStrategy.underline_to_camel);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(TableName);
        strategy.setTablePrefix(TablePrefix);
        mpg.setStrategy(strategy);
    }


    private static void setDataSource() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DBDriver);
        dsc.setUsername(DBUser);
        dsc.setPassword(DBPassword);
        mpg.setDataSource(dsc);
    }

    private static void setGlobalConfig() {
        java.net.URL urlPath = Thread.currentThread().getContextClassLoader().getResource("");
        log.debug("URLPath="+urlPath.getPath());
        String projectPath = Objects.requireNonNull(urlPath).getPath().replace("target/test-classes", "src/main/java");
        gc.setOutputDir(projectPath);//
        gc.setFileOverride(true);//
        gc.setAuthor(Author);
        gc.setSwagger2(true);
        gc.setIdType(IdType.AUTO);//ID
        gc.setDateType(DateType.ONLY_DATE);//Date
        mpg.setGlobalConfig(gc);
    }


    private static void setPackageConfig(){
        PackageConfig pc = new PackageConfig();
        pc.setParent(PackageParent);
        pc.setModuleName(ModuleName);
        mpg.setPackageInfo(pc);
    }

    /**
     * <p>
     * Scan for table name
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("" + tip + "");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("" + tip + "");
    }
}
