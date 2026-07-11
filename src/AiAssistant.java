import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AiAssistant {
    public static void main(String[] args) {
        //这里创建的map是用来存储下面读取knowledge.txt文件里的数据
        Map<String,String> knowledge = new HashMap<>();
        //这个是为了待会要来读取用户输入的对象
        Scanner scanner=new Scanner(System.in);
        //这里是为了尝试阅读knowledge.txt文件里的数据
        try(BufferedReader reader = new BufferedReader(new FileReader("knowledge.txt"))){
            //这里创建的字符串是为了暂时存储待会的每一行的数据
            String line;
            //循环直到读取到的数据为空
            while((line = reader.readLine())!=null){
                //通过字符串里的split方法对line行数据进行“#”符号分割，分割成两个字符串存到parts字符串数组中
                String[] parts = line.split("#",2);
                //如果parts字符串数组的长度等于2，说明line行数据是需要的数据，就存到map里
                if(parts.length==2){
                    knowledge.put(parts[0],parts[1]);
                }
            }
        }catch(IOException e){
            //如果读取文件失败，就输出错误信息
            System.out.println("读取文件失败："+e.getMessage());
            return;
        }
        while(true){
            System.out.print("请输入你的问题：");
            String input = scanner.nextLine();
            input = input.trim();
            if(input.equals("再见")){
                System.out.println(knowledge.get("再见"));
                break;
            } else if (input.isEmpty()) {
                System.out.println("输入不能为空，重新输入");
            } else if (knowledge.containsKey(input)){
                System.out.println(knowledge.get(input));
            }else{
                System.out.println("抱歉，我还没学会这个问题");
            }
        }
    }
}
