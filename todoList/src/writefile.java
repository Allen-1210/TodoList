
import java.io.FileWriter;
public class writefile {
    public static void main(String args[]){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("C:\\\\Users\\\\1\\\\eclipse-workspace1\\\\TodoList\\\\cinn.txt"); //�ɮצ�m
            fileWriter.write("�A�n���ڽT�w��"); // �Q�g�J���r
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}