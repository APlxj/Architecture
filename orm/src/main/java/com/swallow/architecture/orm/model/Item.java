package com.swallow.architecture.orm.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类描述：实例model
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 *
 * @Entity 告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
 * @Id 对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
 * @Property 可以自定义字段名，注意外键不能使用该属性
 * @NotNull 属性不能为空
 * @Transient 使用该注释的属性不会被存入数据库的字段中
 * @Unique 该属性值必须在数据库中是唯一值
 * @Generated 编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
 */
@Entity(nameInDb = "Item")
public class Item {

    //选中数量
    @Transient
    private double chooseNum;

    //ID
    @Unique
    @NotNull
    @Property(nameInDb = "Id")
    private String id;

    //商品名称
    @NotNull
    @Property(nameInDb = "Name")
    private String name;

    //商品价格
    @NotNull
    @Property(nameInDb = "Price")
    private double price;

    //商品折扣（0~1）
    @NotNull
    @Property(nameInDb = "DisCount")
    private double disCount;

    //库存数量
    @Property(nameInDb = "StockNum")
    private double stickNum;

    //图标地址
    @Property(nameInDb = "ImgUrl")
    private String imgUrl;

    //商家地址
    @Property(nameInDb = "Address")
    private String address;

    //商品列表分类
    @NotNull
    @Property(nameInDb = "ItemClassId")
    private String itemClassId;

    @Property(nameInDb = "Memo")
    private String memo;


    @Generated(hash = 478542524)
    public Item(@NotNull String id, @NotNull String name, double price,
                double disCount, double stickNum, String imgUrl, String address,
                @NotNull String itemClassId, String memo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.disCount = disCount;
        this.stickNum = stickNum;
        this.imgUrl = imgUrl;
        this.address = address;
        this.itemClassId = itemClassId;
        this.memo = memo;
    }

    @Generated(hash = 1470900980)
    public Item() {
    }


    public double getChooseNum() {
        return chooseNum;
    }

    public void setChooseNum(double chooseNum) {
        this.chooseNum = chooseNum;
    }

    public String getId() {
        return null == id ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDisCount() {
        return disCount;
    }

    public void setDisCount(double disCount) {
        this.disCount = disCount;
    }

    public double getStickNum() {
        return stickNum;
    }

    public void setStickNum(double stickNum) {
        this.stickNum = stickNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getItemClassId() {
        return itemClassId;
    }

    public void setItemClassId(String itemClassId) {
        this.itemClassId = itemClassId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
