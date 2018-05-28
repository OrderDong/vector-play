package cn.com.vector.play.entity;

import cn.com.vector.play.util.DateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 
 * @author wd
 *
 */
public class User implements Serializable {
	private Long id; //编号
	private String name;//用户名
	private String username; //登录名
    private Long organizationId; //所属公司
    private String organizationName;
    private String password; //密码
    private String mobile;
    private String email;
    private String qq;
    private String remark;
    private Integer status;
    private String createUser;
    private Date createTime;
    private Date updateTime;
    private String updateUser;
    private String salt; //加密密码的盐
    private Boolean locked = Boolean.FALSE;
//    private Role role;
    private String roleName;
//    private List<Long> roleIds; //拥有的角色列表
    private String roleIds;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

/*	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}*/

    /*public List<Long> getRoleIds() {
        if(roleIds == null) {
            roleIds = new ArrayList<Long>();
        }
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }*/
	

    /*public String getRoleIdsStr() {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            s.append(roleId);
            s.append(",");
        }
        return s.toString();
    }
	
    public void setRoleIdsStr(String roleIdsStr) {
        if(StringUtils.isEmpty(roleIdsStr)) {
            return;
        }
        String[] roleIdStrs = roleIdsStr.split(",");
        for(String roleIdStr : roleIdStrs) {
            if(StringUtils.isEmpty(roleIdStr)) {
                continue;
            }
            getRoleIds().add(Long.valueOf(roleIdStr));
        }
    }*/
    
    public Boolean getLocked() {
        return locked;
    }

    public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", username=" + username +
                ", organizationId=" + organizationId +
                ", organizationName=" + organizationName +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roleIds=" + roleIds +
                ", mobile=" + mobile +
                ", email=" + email +
                ", qq=" + qq +
                ", remark=" + remark +
                ", status=" + status +
                ", roleName=" + roleName +
                '}';
    }
    public List<Long> getRoleIdsStr() {
    	String[] strs = roleIds.split("\\/"); 
    	List<Long> roids =  new ArrayList<Long>();
    	 for(String roleIdStr : strs) {
    		 roids.add(Long.valueOf(roleIdStr));
         }
        return roids;
    }
    public Map<String,Object> getTransMap(){
    	Map<String,Object> retMap = new HashMap<String,Object>();
    	retMap.put("id", id);
    	retMap.put("userId", username);
    	retMap.put("userName", name);
    	retMap.put("password", password);
    	retMap.put("mobile", mobile);
    	retMap.put("email", email);
    	retMap.put("qq", qq);
    	retMap.put("remark", remark);
    	retMap.put("creatuser", createUser);
    	retMap.put("creattime", DateUtils.dateTimeToStr(createTime));
    	retMap.put("status", status);
    	retMap.put("deptid", organizationId);
    	retMap.put("deptname", organizationName);
    	retMap.put("relations", roleIds);
    	retMap.put("roleId", roleIds);
    	retMap.put("roleName", roleName);
    	return retMap;
    }
}
