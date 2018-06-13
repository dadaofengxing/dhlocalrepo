package com.dh.ddfx.model.request.house;

import com.dh.ddfx.model.PageCommonRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author zhub1@elab-plus.com
 * Created by Swing on 2018/6/6.
 */
@ApiModel(description = "新增楼盘信息请求")
public class AddHouseInfoRequest extends PageCommonRequest {

    @ApiModelProperty(name = "province", value = "省份", required = true, example = "上海")
    private String province;

    @ApiModelProperty(name = "city", value = "城市", required = true, example = "上海")
    private String city;

    @ApiModelProperty(name = "district", value = "区", required = true, example = "静安区")
    private String district;

    @ApiModelProperty(name = "address", value = "地址", required = true, example = "彭江路602号")
    private String address;

    @ApiModelProperty(name = "name", value = "名称", required = true, example = "大宁德必易园")
    private String name;

    @ApiModelProperty(name = "price", value = "单价", required = true, example = "152350")
    private Float price;

    @ApiModelProperty(name = "priceUnit", value = "价格单位", required = true, example = "1")
    private String priceUnit;

    @ApiModelProperty(name = "discountPrice", value = "折扣价")
    private Float discountPrice;

    @ApiModelProperty(name = "status", value = "状态 1:在售", required = true, example = "1")
    private Integer status;

    @ApiModelProperty(name = "type", value = "楼盘类型 楼盘类型1:内部2:外部")
    private Integer type;

    @ApiModelProperty(name = "level", value = "推荐指数")
    private Integer level;

    @ApiModelProperty(name = "reason", value = "推荐理由")
    private String reason;

    @ApiModelProperty(name = "tel", value = "售楼处电话", required = true, example = "110")
    private String tel;

    @ApiModelProperty(name = "collectNum", value = "收藏数")
    private Integer collectNum;

    @ApiModelProperty(name = "lon", value = "经度", required = true, example = "108.2323")
    private String lon;

    @ApiModelProperty(name = "lat", value = "纬度", required = true, example = "23.2222")
    private String lat;

    @ApiModelProperty(name = "description", value = "简介")
    private String description;

    @ApiModelProperty(name = "source", value = "来源")
    private String source;

    @ApiModelProperty(name = "online", value = "上架    0：默认      1：上架      -1：下架")
    private Integer online;

    @ApiModelProperty(name = "onlineTime", value = "上架时间")
    private Date onlineTime;

    @ApiModelProperty(name = "offlineTime", value = "下架时间")
    private Date offlineTime;

    @ApiModelProperty(name = "mainImageUrl", value = "主图url")
    private String mainImageUrl;

    @ApiModelProperty(name = "customMade", value = "定制,1:是0否，默认0")
    private Integer customMade;

    @ApiModelProperty(name = "sell", value = "是否卖楼1：是，0：否")
    private Integer sell;

    @ApiModelProperty(name = "display", value = "是否显示(嗖嗖)")
    private Integer display;

    @ApiModelProperty(name = "minTotalPrice", value = "最低总价")
    private String minTotalPrice;

    @ApiModelProperty(name = "areaCoordinate", value = "区域坐标")
    private String areaCoordinate;

    @ApiModelProperty(name = "icon", value = "图标")
    private String icon;

    @ApiModelProperty(name = "houseLocationImg", value = "楼盘地理位置图")
    private String houseLocationImg;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Date getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }

    public Integer getCustomMade() {
        return customMade;
    }

    public void setCustomMade(Integer customMade) {
        this.customMade = customMade;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getMinTotalPrice() {
        return minTotalPrice;
    }

    public void setMinTotalPrice(String minTotalPrice) {
        this.minTotalPrice = minTotalPrice;
    }

    public String getAreaCoordinate() {
        return areaCoordinate;
    }

    public void setAreaCoordinate(String areaCoordinate) {
        this.areaCoordinate = areaCoordinate;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHouseLocationImg() {
        return houseLocationImg;
    }

    public void setHouseLocationImg(String houseLocationImg) {
        this.houseLocationImg = houseLocationImg;
    }
}
