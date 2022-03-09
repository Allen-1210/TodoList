/*此程式為簡易版的todo List 
  擁有repl的功能*/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class todolist{
    public static void main(String[]args) {
        ArrayList<String> todoList = new ArrayList<>();
        FileReader fileReader; //讀入

        try {
            fileReader = new FileReader("C:\\Users\\1\\eclipse-workspace1\\TodoList\\cinn.txt"); //檔案路徑
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line=bufferedReader.readLine())!=null) {
                todoList.add(line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Welcome to our todo,\r\n"
                + "1.add:可以進行新增\r\n"
                + "2.delete:可以進行刪除\r\n"
                + "3.edit:可以進行編輯\r\n"
                + "4.mytodo:輸入此指令，可以跳出user個人的todo list");
        try(Scanner scanner = new Scanner(System.in)){

            System.out.printf("todo>>");

            while(scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if(line.equals("add")) {

                    System.out.printf("add>>");
                    StringBuilder buffer = new StringBuilder();

                    while(scanner.hasNext()) {
                        String todo = scanner.next();

                        if((todo).equals("<done>")) {
                            break;
                        }

                        if((todo).equals("")) {
                            continue;
                        }

                        buffer.append(todo);
                        buffer.append("\n");
                    }
                    todoList.add(buffer.toString().trim());  //todoList內容只能為String物件 ，所以需用toString方法 ， 方法trim為去除頭尾空白

                    for(int i =0; i < todoList.size();i++) { //印出todoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("delete")) { // 刪除todoList內容
                    System.out.printf("delete>>");
                    int num = scanner.nextInt();
                    todoList.remove(num-1);

                    for(int i =0; i < todoList.size();i++) { //印出todoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("edit")) { // 編輯todoList內容
                    System.out.printf("edit>>");
                    int num1 = scanner.nextInt();
                    String str1 = scanner.next();
                    todoList.set(num1-1, str1);

                    for(int i =0; i < todoList.size();i++) {//印出todoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("mytodo")) { //秀出使用者最新的todoList
                    System.out.println("Your todo List:");

                    for(int i =0; i < todoList.size();i++) { //印出todoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("exit")) { //結束此程式
                    break;
                }
            }
            System.out.println("Have a good day~");
            FileWriter fileWriter;
            try { //寫進
                fileWriter = new FileWriter("C:\\\\Users\\\\1\\\\eclipse-workspace1\\\\TodoList\\\\cinn.txt"); //檔案位置
                for(int i =0; i < todoList.size();i++) {         
                    fileWriter.write(todoList.get(i)+"\n"); // 依序寫入 todoList內容  並換行!!
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.print(e);
            }

        }
    }

}
