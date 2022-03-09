/*���{����²������todo List 
  �֦�repl���\��*/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class todolist{
    public static void main(String[]args) {
        ArrayList<String> todoList = new ArrayList<>();
        FileReader fileReader; //Ū�J

        try {
            fileReader = new FileReader("C:\\Users\\1\\eclipse-workspace1\\TodoList\\cinn.txt"); //�ɮ׸��|
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line=bufferedReader.readLine())!=null) {
                todoList.add(line);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Welcome to our todo,\r\n"
                + "1.add:�i�H�i��s�W\r\n"
                + "2.delete:�i�H�i��R��\r\n"
                + "3.edit:�i�H�i��s��\r\n"
                + "4.mytodo:��J�����O�A�i�H���Xuser�ӤH��todo list");
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
                    todoList.add(buffer.toString().trim());  //todoList���e�u�ରString���� �A�ҥH�ݥ�toString��k �A ��ktrim���h���Y���ť�

                    for(int i =0; i < todoList.size();i++) { //�L�XtodoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("delete")) { // �R��todoList���e
                    System.out.printf("delete>>");
                    int num = scanner.nextInt();
                    todoList.remove(num-1);

                    for(int i =0; i < todoList.size();i++) { //�L�XtodoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("edit")) { // �s��todoList���e
                    System.out.printf("edit>>");
                    int num1 = scanner.nextInt();
                    String str1 = scanner.next();
                    todoList.set(num1-1, str1);

                    for(int i =0; i < todoList.size();i++) {//�L�XtodoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("mytodo")) { //�q�X�ϥΪ̷̳s��todoList
                    System.out.println("Your todo List:");

                    for(int i =0; i < todoList.size();i++) { //�L�XtodoList
                        System.out.println((i+1)+"."+todoList.get(i));
                    }

                    System.out.printf("todo>>");
                }

                if(line.equals("exit")) { //�������{��
                    break;
                }
            }
            System.out.println("Have a good day~");
            FileWriter fileWriter;
            try { //�g�i
                fileWriter = new FileWriter("C:\\\\Users\\\\1\\\\eclipse-workspace1\\\\TodoList\\\\cinn.txt"); //�ɮצ�m
                for(int i =0; i < todoList.size();i++) {         
                    fileWriter.write(todoList.get(i)+"\n"); // �̧Ǽg�J todoList���e  �ô���!!
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.print(e);
            }

        }
    }

}
