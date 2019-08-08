package com.shiyang.sell.dataobject;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @description: 商品类目
 * @author: W
 * @create: 2019-08-08 14:06
 **/
@Entity
@DynamicUpdate
public class ProductCategory {
    
    /** 类目ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    
    /** 类目名字 */
    private String categoryName;
    
    /** 类目编号 */
    private Integer categoryType;
    
    /** 创建时间 */
    private Date createTime;
    
    /** 更新时间 */
    private Date updateTime;
    
    // 一定要有空的构造方法 否则会报错(底层通过反射创建实体类?)
    public ProductCategory() {
    }
    
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.createTime = new Date();
    }
    
    public Integer getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public Integer getCategoryType() {
        return categoryType;
    }
    
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        return "ProductCategory{" +
            "categoryId=" + categoryId +
            ", categoryName='" + categoryName + '\'' +
            ", categoryType=" + categoryType +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
    }
}
