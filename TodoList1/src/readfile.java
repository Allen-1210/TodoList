import java.io.BufferedReader;
import java.io.FileReader;

public class readfile {
    public static void main(String args[]){
        FileReader fileReader;
        try {
            fileReader = new FileReader("C:\\Users\\1\\eclipse-workspace1\\TodoList\\cinn.txt"); //ÀÉ®×¸ô®|
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}