
import java.io.FileWriter;
public class writefile {
    public static void main(String args[]){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("C:\\\\Users\\\\1\\\\eclipse-workspace1\\\\TodoList\\\\cinn.txt"); //檔案位置
            fileWriter.write("你要給我確定欸"); // 想寫入的字
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}