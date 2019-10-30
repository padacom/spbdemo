package me.nnsty.database;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器
 *
 * @author admin
 * @create 2018/12/4 15:07
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("E:/mydoc/project/spbdemo/sty-database/src/main/java");
        // 是否覆盖文件
        gc.setFileOverride(false);
        // 不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        gc.setAuthor("ly");

        //日期类型定义，如果不增加这行，则数据库日期类型ENTITY映射为LocalDateTime类型（JDK8新日期类型）
//        gc.setDateType(DateType.ONLY_DATE);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setServiceName("I%sDao");
        gc.setServiceImplName("%sDaoImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //测试库
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/eladmin?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
        //========================================================
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 全局大写命名 ORACLE 注意
        // strategy.setCapitalMode(true);
        // 此处可以修改为您的表前缀
        //strategy.setTablePrefix(new String[]{"t_"});
        // 表名生成策略  underline_to_camel为驼峰命名，nochange为下划线命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setNaming(NamingStrategy.nochange);
        // 需要生成的表
        strategy.setInclude(
                //"t_user",
                "user");
        // 排除生成的表
        // strategy.setExclude(new String[]{"test"});
        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("me.nnsty");
        pc.setModuleName("database");
        pc.setService("dao");
        pc.setServiceImpl("dao.impl");
        mpg.setPackageInfo(pc);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        tc.setXml(null);
        tc.setController(null);
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }

}

