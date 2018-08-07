package model;

import java.io.Serializable;

/**
 * @Description:
 * @author:lidetian
 * @date: 2018/7/30
 * @system name:马达贷
 * @copyright:长安新生（深圳）金融投资有限公司
 */
@SuppressWarnings("serial")
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                '}';
    }
}
