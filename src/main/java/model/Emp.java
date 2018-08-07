package model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author:lidetian
 * @date: 2018/7/30
 * @system name:马达贷
 * @copyright:长安新生（深圳）金融投资有限公司
 */
@SuppressWarnings("serial")
public class Emp implements Serializable{
    private Integer empno;
    private String ename;
    private Double sal ;
    private Date hiredate;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                ", hiredate=" + hiredate +
                ", dept=" + dept +
                '}';
    }
}
