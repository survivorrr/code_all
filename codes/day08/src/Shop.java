
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 实现产品的增删改查
 * */
public class Shop {

	public static void main(String[] args) 
	{
		ArrayList<FruitItem> array = new ArrayList<FruitItem>(); 
		initFruit(array);
		while(true)
		{
			int number = chooseNumber(array);
			switch(number)
			{
			case 1:printFruit(array);break;
			case 2:addFruit(array);break;
			case 3:deletFruit(array);break;
			case 4:updataFruit(array);break;
			case 5:return;
			default:System.out.println("没有此功能！！！");
			}
		}
	}
	
	//选择菜单
	public static int chooseNumber(ArrayList<FruitItem> array)
	{
		System.out.println();
		int number;
		System.out.println("请输入需要功能的序号");
		System.out.println("1.信息查询 2.增加商品 3.删除商品 4.修改商品 5 退出");
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		return number;
	}
	
	//添加产品信息
	public static void initFruit(ArrayList<FruitItem> array)
	{
		FruitItem item1 = new FruitItem();
		
		item1.ID = 9001;
		item1.name = "少林寺酥饼核桃";
		item1.price = 120;
		
		FruitItem item2 = new FruitItem();
		
		item2.ID = 9002;
		item2.name = "新疆原产哈密瓜";
		item2.price = 20;

		FruitItem item3 = new FruitItem();
		item3.ID = 9003;
		item3.name = "尚康杂粮牡丹饼";
		item3.price = 3;
		
		array.add(item1);
		array.add(item2);
		array.add(item3);
	}

	// 打印产品信息
	public static void printFruit(ArrayList<FruitItem> array)
	{
		for(int i = 0; i < array.size(); i++)
		{
			FruitItem f = new FruitItem();
			f = array.get(i);
			System.out.print(f.ID+"  "+f.name+"   "+f.price);
			System.out.println();
		}
	}
	
	//增加商品信息
	public static void addFruit(ArrayList<FruitItem> array)
	{
		FruitItem item4 = new FruitItem();
		item4.ID = 9004;
		item4.name = "薰衣草红枣饼干";
		item4.price = 98;
		
		array.add(item4);
		System.out.println("增加成功！！！");	
	}
	
	//删除商品信息
	public static void deletFruit(ArrayList<FruitItem> array)
	{
		System.out.println("请输入要删除的产品ID");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		for(int i = 0;i < array.size();i++)
		{
			FruitItem f = array.get(i);
			if(s == f.ID)
			{
				array.remove(i);
				System.out.println("删除成功！！！");
				return;
			}
		}	
	}
	
	//修改商品信息
	public static void updataFruit(ArrayList<FruitItem> array)
	{
		System.out.println("请输入要修改产品的ID编号");
		Scanner sc = new Scanner(System.in);
		int ID = sc.nextInt();
		for(int i = 0;i < array.size();i++)
		{
			FruitItem f = array.get(i);
			if(ID == f.ID)
			{
				System.out.println("请重新输入产品ID");
				f.ID = sc.nextInt();
				
				System.out.println("请重新输入产品名称");
				f.name = sc.next();
				
				System.out.println("请重新输入产品价格");
				f.price = sc.nextDouble();
				
				System.out.println("产品信息更新完毕");
				return;
			}
		}
		System.out.println("没有这个编号的水果！！！");
		
     }
}
