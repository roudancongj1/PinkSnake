package com.gao.util;

public enum Renum {


    OKOK("okok"),

    ERRORERROR("errorerror"),
    ;

    private  final String desc;
    Renum(String desc) {
        this.desc=desc;
    }



}
/*
*     OKOK("ok","okok"),

    ERRORERROR("error","errorerror"),

    ;

    private  final String name;
    private  final String desc;
    Renum(String name,String desc) {
        this.name=name;
        this.desc=desc;
    }

    public String getName(){
        return this.name;
    }*/

/*
class Season{
    //1.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化类的构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //3.提供当前枚举类的多个对象：public static final修饰
    public static final Season SPRING = new Season("春天","春天来了");
    public static final Season SUMMER = new Season("夏天","夏天来了");
    public static final Season AUTUMN = new Season("秋天","秋天来了");
    public static final Season WINTER = new Season("冬天","冰天来了");
}----------------------------相当于创建一个季节类 构造私有在内部创建多个不同属性值的不同季节对象
*/
