package com.example.mlTest.springresource.jdbc.framework;

import javax.sql.DataSource;
import java.io.Serializable;

/**
 * @author miaoliang
 * @since 8/1/21 7:57 PM
 */
public abstract class BaseDaoSupport<T extends Serializable, PK extends Serializable> {

    // 讲究，写的这个类是要给别人去继承的
    // 这个类一般不会单独 new 出来
    // 这个类里面的所有方法都应该设置为 protected

    /**
     * 设置主键列名
     * @return
     */
//    protected abstract String getPKColumn();

    /**
     * 设置数据源（一般是动态注入）
     * @param dataSource
     */
    protected abstract void setDataSource(DataSource dataSource);

}
