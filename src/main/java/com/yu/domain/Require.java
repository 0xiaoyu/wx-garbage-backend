package com.yu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author za'y
 * @TableName requirements
 */
@TableName(value ="requirements")
@Data
public class Require implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 垃圾的主键
     */
    @TableField(value = "sortedID")
    private Integer sortedid;

    /**
     * 建议
     */
    @TableField(value = "requirement")
    private String requirement;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Require other = (Require) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSortedid() == null ? other.getSortedid() == null : this.getSortedid().equals(other.getSortedid()))
            && (this.getRequirement() == null ? other.getRequirement() == null : this.getRequirement().equals(other.getRequirement()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSortedid() == null) ? 0 : getSortedid().hashCode());
        result = prime * result + ((getRequirement() == null) ? 0 : getRequirement().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sortedid=").append(sortedid);
        sb.append(", require=").append(requirement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}