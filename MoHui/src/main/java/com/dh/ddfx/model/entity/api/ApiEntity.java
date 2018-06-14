package com.dh.ddfx.model.entity.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author duh on 2018/6/5 15:19.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
@Table(name = "apis",catalog = "system")
@ApiModel(description = "api实体")
public class ApiEntity {
    @ApiModelProperty(name = "id", value = "api编号")
    @Id
    private String id;

    @ApiModelProperty(name = "name", value = "api名称")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(name = "version", value = "api版本")
    @Column(name = "version")
    private String version;

    @ApiModelProperty(name = "method", value = "api调用方式")
    @Column(name = "method")
    private String method;

    @ApiModelProperty(name = "url", value = "api地址")
    @Column(name = "url")
    private String url;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(name = "enabled", value = "api状态")
    @Column(name = "enabled")
    private String enabled;

    @ApiModelProperty(name = "created", value = "创建时间")
    @Column(name = "created")
    private String created;

    @ApiModelProperty(name = "creator", value = "创建人")
    @Column(name = "creator")
    private String creator;

    @ApiModelProperty(name = "modified", value = "修改时间")
    @Column(name = "modified")
    private String modified;

    @ApiModelProperty(name = "modifier", value = "修改人")
    @Column(name = "modifier")
    private String modifier;

    public String getId() {
        return id;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
}
