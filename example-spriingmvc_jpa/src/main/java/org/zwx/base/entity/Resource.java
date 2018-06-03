package org.zwx.base.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "t_resource")
public class Resource {

//    @ManyToMany(mappedBy = "resources")
//    private List<Group> groups;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id; 								//编号

    @Column(name = "name")
    @NotEmpty(message = "{resource.name.not.empty}")
    private String name; 							//资源名称

    @Column(name = "type")
    private String type;							//资源类型

    @Column(name = "url")
    private String url; 							//资源路径

    @Column(name = "permission")
    @NotEmpty(message = "{resource.permission.not.empty}")
    private String permission; 						//权限字符串

    @Column(name = "parent_id")
    @NotNull(message = "{resource.parentId.not.empty}")
    private Integer parentId; 							//父编号

    @Column(name = "parent_ids")
	/*@NotEmpty(message="{resource.parentIds.not.empty}")
	@Length(min = 2, max = 20, message = "{resource.parentIds.length.illegal}")*/
    private String parentIds; 						//父编号列表

    @Column(name = "available")
    private Integer available;

//    public List<Group> getGroups() {
//        return groups;
//    }

//    public void setGroups(List<Group> groups) {
//        this.groups = groups;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
