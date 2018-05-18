package com.qc.test.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duh on 2018/5/18 10:48.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
public class People {
    public String name = "unknown";
    public int index;//家中排行
    public int level;//第几代
    public People father;
    public List<People> sons = new ArrayList<>();

    public void addGrandPa(People grandPa){
        if(father == null){
            father = new People();
        }
        father.addSon(this);
        grandPa.addSon(father);
    }
    public void addFather(People father){
        father.addSon(this);
    }
    public void addSon(People people){
        for(People son : sons){
            if(son.equals(people)){
                return;
            }
        }
        sons.add(people);
        people.father = this;
        //代际加1
        people.level++;
        for(People people1:people.sons){
            people1.level++;
        }
    }
    public void addGrandSon(People grandSon){
        grandSon.addGrandPa(this);
    }
    public void addBrother(People brother){
        if(null == father){
            father = new People();
            father.addSon(this);
        }
        father.addSon(brother);
    }
    public void addElderBrother(People elderBrother){
        elderBrother.index = this.index+1;
        addBrother(elderBrother);
    }
    public void addLitterBrother(People litterBrother){
        litterBrother.addElderBrother(this);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }else if(obj instanceof People){
            return ((People) obj).name.equals(this.name);
        }
        return false;
    }
}
