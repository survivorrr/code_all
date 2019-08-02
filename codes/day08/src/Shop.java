
import java.util.ArrayList;
import java.util.Scanner;

/*
 * ʵ�ֲ�Ʒ����ɾ�Ĳ�
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
			default:System.out.println("û�д˹��ܣ�����");
			}
		}
	}
	
	//ѡ��˵�
	public static int chooseNumber(ArrayList<FruitItem> array)
	{
		System.out.println();
		int number;
		System.out.println("��������Ҫ���ܵ����");
		System.out.println("1.��Ϣ��ѯ 2.������Ʒ 3.ɾ����Ʒ 4.�޸���Ʒ 5 �˳�");
		Scanner sc = new Scanner(System.in);
		number = sc.nextInt();
		return number;
	}
	
	//��Ӳ�Ʒ��Ϣ
	public static void initFruit(ArrayList<FruitItem> array)
	{
		FruitItem item1 = new FruitItem();
		
		item1.ID = 9001;
		item1.name = "�������ֱ�����";
		item1.price = 120;
		
		FruitItem item2 = new FruitItem();
		
		item2.ID = 9002;
		item2.name = "�½�ԭ�����ܹ�";
		item2.price = 20;

		FruitItem item3 = new FruitItem();
		item3.ID = 9003;
		item3.name = "�п�����ĵ����";
		item3.price = 3;
		
		array.add(item1);
		array.add(item2);
		array.add(item3);
	}

	// ��ӡ��Ʒ��Ϣ
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
	
	//������Ʒ��Ϣ
	public static void addFruit(ArrayList<FruitItem> array)
	{
		FruitItem item4 = new FruitItem();
		item4.ID = 9004;
		item4.name = "޹�²ݺ������";
		item4.price = 98;
		
		array.add(item4);
		System.out.println("���ӳɹ�������");	
	}
	
	//ɾ����Ʒ��Ϣ
	public static void deletFruit(ArrayList<FruitItem> array)
	{
		System.out.println("������Ҫɾ���Ĳ�ƷID");
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		for(int i = 0;i < array.size();i++)
		{
			FruitItem f = array.get(i);
			if(s == f.ID)
			{
				array.remove(i);
				System.out.println("ɾ���ɹ�������");
				return;
			}
		}	
	}
	
	//�޸���Ʒ��Ϣ
	public static void updataFruit(ArrayList<FruitItem> array)
	{
		System.out.println("������Ҫ�޸Ĳ�Ʒ��ID���");
		Scanner sc = new Scanner(System.in);
		int ID = sc.nextInt();
		for(int i = 0;i < array.size();i++)
		{
			FruitItem f = array.get(i);
			if(ID == f.ID)
			{
				System.out.println("�����������ƷID");
				f.ID = sc.nextInt();
				
				System.out.println("�����������Ʒ����");
				f.name = sc.next();
				
				System.out.println("�����������Ʒ�۸�");
				f.price = sc.nextDouble();
				
				System.out.println("��Ʒ��Ϣ�������");
				return;
			}
		}
		System.out.println("û�������ŵ�ˮ��������");
		
     }
}
