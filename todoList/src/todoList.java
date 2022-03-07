import java.util.Scanner;
import java.util.*;

public class todoList{
	public static void main(String[]args) {
		ArrayList<String> todoList = new ArrayList<>();		
		System.out.println("Welcome to our todo,\n"
				+ "1.add: 可以進行新增\n"
				+ "2.delete:可以進行刪除\n"
				+ "3.edit:可以進行編輯\n"
				+ "4.my todo:輸入此指令，可以跳出使用者個人的todo list");	
		
		try(Scanner scanner = new Scanner(System.in)){
			
			System.out.printf("todo>>");
			
			while(scanner.hasNextLine()) {
				
				String line = scanner.next();				
				
				if(line.equals("add")) {
					System.out.printf("add>>");
					StringBuilder buffer = new StringBuilder();
					while(scanner.hasNext()) {
						String todo = scanner.next();
						if(todo.equals("<done>")) {
							break;
						}
						buffer.append(todo);     
						}
						todoList.add(buffer.toString().trim()); //todoList 只接受字串
						
						for(int i = 0;i<todoList.size();i++) {  //印出表單內容
							System.out.println((i+1)+"."+todoList.get(i));
						}
						System.out.printf("todo>>");
				}
				
				if(line.equals("delete")) {
					System.out.printf("delete>>");
					int num = scanner.nextInt();
					todoList.remove(num-1);
					
					for(int i = 0;i<todoList.size();i++) {
						System.out.println((i+1)+"."+todoList.get(i));
					}	
					System.out.printf("todo>>");
				}
				
				if(line.equals("edit")) {
					System.out.printf("edit>>");
					int num1 = scanner.nextInt();
					String str1 = scanner.next();
					todoList.set(num1-1, str1);
					
					for(int i = 0;i<todoList.size();i++) {
						System.out.println((i+1)+"."+todoList.get(i));
					}	
					System.out.printf("todo>>");
				}
				
				if(line.equals("mytodo")) {
					for(int i = 0;i<todoList.size();i++) {
						System.out.println((i+1)+"."+todoList.get(i));
					}
					System.out.printf("todo>>");
				}
				
				if(line.equals("exit")) {
					break;
				}
				
			}			
			System.out.printf("Have a good day~");			
		}		
	}
}