package cn.itcase.demo4;
/*
 * 这里当Maintainer继承Employee时候，如果不在Maintainer强制写入父类Employee的具体工作work（）
 * 方法就会报错，所以在这个类前也加入一个abstract就可以了，在这个程序中暂时看不出有什么好处，但是
 * 它其实可以在这里加入Maintainer类中特有的功能，比如奖金。
 * */
public abstract class Maintainer extends Employee{

}
