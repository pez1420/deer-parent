package com.longlydeer.deer.web.portal.test;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/spring-appcontext.xml"})
public class TestCache {

    CacheManager cacheManager;

    @Before
    public void before() {
        cacheManager = CacheManager.create();
    }


    @Test
    public void testCache() {
        Cache sample = cacheManager.getCache("authorization");

        // 获取缓存管理器中的缓存配置名称
        for (String cacheName : cacheManager.getCacheNames()) {
            System.out.println(cacheName);
        }

        System.out.println(System.getProperty("java.io.tmpdir"));
        //Assert.assertTrue();
    }
}

