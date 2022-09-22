package com.xxl.job.executor.study.design.signleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-22 10:12
 * @description 单例模式在缓存中的应用
 */
public class SignletonCache {

    private Map<String, SignletonCacheModel> cacheMap = null;

    private SignletonCache(){
        cacheMap = createDataSource();
    }

    private static SignletonCache signletonCache = null;

//    真实的项目开发中不会采用饿汉式加载方式，因为不稳定。
    public SignletonCache getInstance(){
        if(signletonCache == null) {
            synchronized (this) {
                if (signletonCache == null) {
                    signletonCache = new SignletonCache();
                }
            }
        }
        return signletonCache;
    }

    public SignletonCacheModel getModel(String key){
        if(signletonCache == null){
            signletonCache = getInstance();
        }
        if(!cacheMap.keySet().contains(key)){
            SignletonCacheModel signletonCacheModel = new SignletonCacheModel();
            signletonCacheModel.setKey(key);
            signletonCacheModel.setValue("为此key创建一个缓存对象");
            cacheMap.put(key,signletonCacheModel);
            return signletonCacheModel;
        }else {
            return cacheMap.get(key);
        }
    }

    //构造数据源
    private Map<String, SignletonCacheModel> createDataSource(){
        SignletonCacheModel signletonCacheModel1 = new SignletonCacheModel();
        signletonCacheModel1.setValue("color");
        signletonCacheModel1.setValue("红色");
        SignletonCacheModel signletonCacheModel2 = new SignletonCacheModel();
        signletonCacheModel2.setValue("size");
        signletonCacheModel2.setValue("很大");
        SignletonCacheModel signletonCacheModel3 = new SignletonCacheModel();
        signletonCacheModel3.setValue("sex");
        signletonCacheModel3.setValue("男");
        Map<String, SignletonCacheModel> cacheModelMap = new HashMap<>();
        cacheModelMap.put(signletonCacheModel1.getKey(),signletonCacheModel1);
        cacheModelMap.put(signletonCacheModel2.getKey(),signletonCacheModel1);
        cacheModelMap.put(signletonCacheModel3.getKey(),signletonCacheModel1);
        return cacheModelMap;
    }
}
