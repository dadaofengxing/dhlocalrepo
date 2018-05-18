package com.qc.test.controller;

import com.qc.test.model.People;
import com.qc.test.model.RelationEnum;
import com.qc.test.utils.Constants;
import com.qc.test.utils.ReadFileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by duh on 2018/5/18 11:51.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
public class RelationController {
    private static List<String> names = new ArrayList<>();
    private static Map<String,People> namePeopleMap = new HashMap<>();
    People root = new People();
    public void getRelation(String content){
        String[] pepleName = content.split(Constants.WORD_SHI);
        int relation = 0;
        String firstName;
        String secondName;
        if(pepleName[0].contains(Constants.WORD_DE)){
            String[] pepleNameAndRelation = pepleName[0].split(Constants.WORD_DE);
            firstName = pepleName[1];
            addUnique(names,firstName);
            secondName = pepleNameAndRelation[0];
            addUnique(names,secondName);
            relation = (Constants.WORD_RELATIONS.indexOf(pepleNameAndRelation[1])+1)/2+1;
        }else {
            String[] pepleNameAndRelation = pepleName[1].split(Constants.WORD_DE);
            firstName = pepleName[0];
            addUnique(names,firstName);
            secondName = pepleNameAndRelation[0];
            addUnique(names,secondName);
            relation = -(Constants.WORD_RELATIONS.indexOf(pepleNameAndRelation[1]))/2-1;
        }
        if(relation >= 0){
            addRelation(namePeopleMap.get(firstName),namePeopleMap.get(secondName),relation);
        }else {
            addRelation(namePeopleMap.get(secondName),namePeopleMap.get(firstName),-relation);
        }
    }
    private void addUnique(List<String> list,String name){
        if(list.size() == 0){
            root.name = "root";
            namePeopleMap.put("root",root);
        }
        if(!list.contains(name)){
            list.add(name);
            People people = new People();
            people.name = name;
            root.addSon(people);
            namePeopleMap.put(name,people);
        }
    }
    public void addRelation(People people1,People people2,int relation){
        switch (relation) {
            case 0:
                people1.addGrandSon(people2);
                break;
            case 1:
                people1.addSon(people2);
                break;
            case 2:
                people1.addLitterBrother(people2);
                break;
            case 3:
                people1.addBrother(people2);
                break;
            case 4:
                people1.addElderBrother(people2);
                break;
            case 5:
                people1.addFather(people2);
                break;
            case 6:
                people1.addGrandPa(people2);
                break;
        }

    }
    public String getRelation(String firstName,String secondName){
        String head = firstName + "是"+secondName+"的";
        String head2 = firstName + "和"+secondName;
        if(names.contains(firstName) && names.contains(secondName)){
            People first = namePeopleMap.get(firstName);
            People second = namePeopleMap.get(secondName);
            if(first.level == second.level){
                if(first.father.equals(second.father)){
                    if(first.index == second.index){
                        return head+RelationEnum.ENUM3.code;
                    }else if(first.index < second.index){
                        return head+RelationEnum.ENUM4.code;
                    }else {
                        return head+RelationEnum.ENUM5.code;
                    }
                }
            }else if(first.level < second.level){
                return head+getRelation(first,second);
            }else {
                return head+getRelation(second,first);
            }
        }
        return head2+"无关系";
    }
    private String getRelation(People first,People second){
        String[] relations = {RelationEnum.ENUM2.code,RelationEnum.ENUM1.code,"老爷"};
        int i = 0;
        while (second.father != first){
            i++;
            if(second.father == root){
                return relations[i];
            }
        }

        return i+"";
    }
    public static void main(String[] args) {
        String content = "A是B的哥哥";
        RelationController controller = new RelationController();
        controller.getRelation(content);
        System.out.println(names);
        System.out.println(controller.getRelation("A","root"));
        System.out.println(controller.getRelation("A","B"));
        List<String> fileContent = ReadFileUtils.getFileContent("people.txt");
        for (String con : fileContent){
            controller.getRelation(con);
        }
        System.out.println(controller.getRelation("A","小华"));
        System.out.println(controller.getRelation("小明","小青"));
        System.out.println(controller.getRelation("小明","小华"));
    }
}
