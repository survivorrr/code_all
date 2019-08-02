package cn.itcase.demo4;
/*
 * 这里当Develop继承Employee时候，如果不在Develop强制写入父类Employee的具体工作work（）
 * 方法就会报错。因为没有重写父类的抽象方法，即这个类还是一个抽象类，所以在这个类前也加入一个abstract就可以了，
 * 在这个程序中暂时看不出有什么好处，但是它其实可以在这里加入Develop类中特有的功能，比如奖金。
 * */
public abstract class Develop extends Employee {

}
