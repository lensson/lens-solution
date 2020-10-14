package com.lens.wx.gzhserver;


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
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
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
    private static final String URL = "jdbc:mysql://localhost:33306/gzh?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
    private static final String DBUser = "lens";
    private static final String DBPassword = "lens";
    private static final String DBDriver = "com.mysql.cj.jdbc.Driver";

    /**
     * Package Config
     */
    private static final String PackageParent = "com.lens.wx.gzhserver";

    /**
     * Stratege Config
     */
    private static final String TablePrefix = "wx_";

    private static final String TableName = "wx_user";

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

    public static void main(String args[]) {

        setDataSource();

        //set global and package config
        setGlobalConfig();

        setTemplate();

        setStrategy();

        mpg.execute();


//        gc.setOutputDir(ProjectPath + "/wx/gzhserver/src/main/java");
//        gc.setAuthor(Author);
//        gc.setOpen(false);
//        gc.setSwagger2(true);
//        mpg.setGlobalConfig(gc);

        /**
         * Datasource Config
         */
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://localhost:33306/gzh?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8" );
//        dsc.setSchemaName("gzh");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("lens");
//        dsc.setPassword("lens");
//        mpg.setDataSource(dsc);

        // Package Config
//        PackageConfig pc = new PackageConfig();
//        pc.setModuleName(scanner("Module Name :"));
//        pc.setParent("com.lens.wx.gzhserver");
//        mpg.setPackageInfo(pc);

        // Private Customization
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };

        // Template freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // Template velocity
//         String templatePath = "/vm";

        // Cusomized Config
//        List<FileOutConfig> focList = new ArrayList<>();
//        // Cusomized Config First
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return projectPath + "/src/main/resources/mybatis/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // �ж��Զ����ļ����Ƿ���Ҫ����
                checkDir("����Ĭ�Ϸ���������Ŀ¼���Զ���Ŀ¼��");
                if (fileType == FileType.MAPPER) {
                    // �Ѿ����� mapper �ļ��жϴ��ڣ������������ɷ��� false
                    return !new File(filePath).exists();
                }
                // ��������ģ���ļ�
                return true;
            }
        });
        */
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);



//        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setEntity("/vm/java/domain.java");
//        templateConfig.setMapper("/vm/java/mapper.java");
//        templateConfig.setService("/vm/java/service.java");
//        templateConfig.setServiceImpl("/vm/java/serviceImpl.java");
//        templateConfig.setController("/vm/java/controller.java");
//
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
////        strategy.setSuperEntityClass("");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//
////        strategy.setSuperControllerClass("");
//        // Super
//        strategy.setSuperEntityColumns("id");
//        strategy.setInclude(scanner("Table Name, split by comma:").split(","));
//
//
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
//
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new VelocityTemplateEngine());
//        mpg.execute();
    }

    private static void setTemplate(){
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("/vm/java/domain.java");
        templateConfig.setMapper("/vm/java/mapper.java");
        templateConfig.setService("/vm/java/service.java");
        templateConfig.setServiceImpl("/vm/java/serviceImpl.java");
        templateConfig.setController("/vm/java/controller.java");
        mpg.setTemplate(templateConfig);
    }

    private static void setStrategy() {
        StrategyConfig strategy = new StrategyConfig();

        // Tb_userController -> TbUserController
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // start_time -> startTime
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok  setter/getter
        strategy.setEntityLombokModel(true);
        // ControllerRestController
        strategy.setRestControllerStyle(true);
        //
        strategy.setInclude(TableName);
        //
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
        String projectPath = Objects.requireNonNull(urlPath).getPath().replace("target/classes", "src/main/java");
        gc.setOutputDir(projectPath);//
        gc.setFileOverride(true);//
        gc.setAuthor(Author);
        gc.setSwagger2(true);
        gc.setIdType(IdType.AUTO);//ID
        gc.setDateType(DateType.ONLY_DATE);//Date
        mpg.setGlobalConfig(gc);
        PackageConfig pc = new PackageConfig();
        pc.setParent(PackageParent);
        mpg.setPackageInfo(pc);
    }
}
