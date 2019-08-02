package cn.itcast.demo05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PookerDemo {
	public static void main(String[] args) {
		//准备牌
		HashMap<Integer,String> pooker = new HashMap<Integer,String>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
		String[] colors = {"♠","♣","♥","♦"};
		int index = 2;
		for(int i = 0; i < numbers.length; i++){
			for(int j = 0; j < colors.length; j++){
				pooker.put(index, numbers[i]+colors[j]);
				list.add(index);
				index++;
			}
		}
		pooker.put(0, "大王");
		list.add(0);
		pooker.put(1, "小王");
		list.add(1);
		
		//洗牌
		Collections.shuffle(list);
//		System.out.println(list);
		
		//发牌
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		ArrayList<Integer> player3 = new ArrayList<Integer>();
		ArrayList<Integer> bottem = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++){
			if(i<3){
				bottem.add(list.get(i));
			}else if(i%3 == 0){
				player1.add(list.get(i));
			}else if(i%3 == 1){
				player2.add(list.get(i));
			}else if(i%3 == 2){
				player3.add(list.get(i));
			}
		}
		
		//把牌按大小排序
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		
		/*System.out.println(player1);
		System.out.println(player2);
		System.out.println(player3);*/
		//看牌
/*		for(int m=0;m<player1.size();m++){
			int key = player1.get(m);
			String value = pooker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
		for(int m=0;m<player2.size();m++){
			int key = player2.get(m);
			String value = pooker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
		for(int m=0;m<player3.size();m++){
			int key = player3.get(m);
			String value = pooker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
		for(int m=0;m<bottem.size();m++){
			int key = bottem.get(m);
			String value = pooker.get(key);
			System.out.print(value+" ");
		}*/
		
		look(player1,pooker);
		look(player2,pooker);
		look(player3,pooker);
		look(bottem,pooker);
	}
	
	public static void look(ArrayList<Integer> player,HashMap<Integer,String> pooker){
		for(int i=0;i<player.size();i++){
			int key = player.get(i);
			String value = pooker.get(key);
			System.out.print(value+" ");
		}
		System.out.println();
	}
}







