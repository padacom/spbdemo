package me.nnsty.database.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Mybatis Plus 配置
 *
 * @author admin
 * @create 2018/12/4 15:07
 **/
//配置扫描mapper
@MapperScan(basePackages = {"me.nnsty.database.mapper*"})
@Configuration
public class MybatisPlusConfig {

    /**
     * SQL执行效率插件
     * 设置 dev test 环境开启
     */
    @Bean
    @Profile({"local","test"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
