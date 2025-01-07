//package com.example.demo.config;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * 
// *
// * @author lixin
// */
//@EnableTransactionManagement(proxyTargetClass = true)
//@Configuration
//public class MybatisPlusConfig
//{
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor()
//    {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//       
//        interceptor.addInnerInterceptor(paginationInnerInterceptor());
//        
//        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor());
//        
//        interceptor.addInnerInterceptor(blockAttackInnerInterceptor());
//        return interceptor;
//    }
//
//    
//    public PaginationInnerInterceptor paginationInnerInterceptor()
//    {
//        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
//        
//        paginationInnerInterceptor.setDbType(DbType.MYSQL);
//        
//        paginationInnerInterceptor.setMaxLimit(-1L);
//        return paginationInnerInterceptor;
//    }
//
//    
//    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor()
//    {
//        return new OptimisticLockerInnerInterceptor();
//    }
//
//    
//    public BlockAttackInnerInterceptor blockAttackInnerInterceptor()
//    {
//        return new BlockAttackInnerInterceptor();
//    }
//
//}
