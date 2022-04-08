package com.econ;

import java.util.Objects;
import java.util.Scanner;
//import java.lang.Object;

class NoteBook{
	String keyboard="키보드";
	String monitor="OLED";
	String mouse="터치패드";
	@Override
	public String toString() {
		return "NoteBook={\"keyboard\": \"" + keyboard + "\", \"monitor\": \"" + monitor + "\", \"mouse\": \"" + mouse
				+ "\"}";
	}
	@Override
	public int hashCode() {
		return Objects.hash(keyboard, monitor, mouse);
	}
	//정석의 검사식
	@Override
	public boolean equals(Object obj) {
		if (this == obj) //주소가 같으면
			return true;
		if (obj == null) //주소가 null이면
			return false;
		if (getClass() != obj.getClass()) //타입이 다른지
			return false;
		NoteBook other = (NoteBook) obj;
		return Objects.equals(keyboard, other.keyboard) && Objects.equals(monitor, other.monitor)
				&& Objects.equals(mouse, other.mouse);
	}
	
}
//${object.className}={"${member.name()}": "${member.value}", "${otherMembers}"}
public class L34Object {
	public static void main(String[] args) {
		NoteBook nb=new NoteBook();
		System.out.println(nb);
		System.out.println(nb.getClass());
		NoteBook nb2=new NoteBook();
		System.out.println("nb==nb2:"+(nb==nb2));
		System.out.println("nb.equals(nb2):"+(nb.equals(nb2)));
		nb2.keyboard="야광키보드";
		System.out.println("nb.equals(nb2):"+(nb.equals(nb2)));
		
		
		String a="안녕";
		String b="안녕";
		String d=new String("안녕");
		System.out.println(a==b);
		System.out.println(a==d);
		Scanner sc=new Scanner(System.in);
		String c=sc.nextLine();
		System.out.println(a==c);
		System.out.println(a.equals(c));
		
	}
}
