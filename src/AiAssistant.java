import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
            //当读取的line数据不为空时，就继续循环，直到为空停止循环
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
            //将输入内容存到input字符串里
            String input = scanner.nextLine();
            //将input字符串里的首尾空格去掉
            input = input.trim();
            //添加学习功能，如果以“学习#”开头，就把该段内容存到map里
            if(input.startsWith("学习#")){
                //将input字符串里的“#”符号去掉，存到parts字符串数组里
                String[] parts = input.split("#",3);
                //如果分割后的长度为3，则是我们需要学习的内容，则存到map里
                if (parts.length==3){
                    knowledge.put(parts[1],parts[2]);
                    System.out.println("学习成功");
                }else {
                    System.out.println("学习失败，格式错误");
                }
                continue;
            }
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
        //将map写回到knowledge.txt文件里
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("knowledge.txt"))){
            //通过集合里的entryset方法遍历map里的每个entryset
            for (Map.Entry<String,String> entry : knowledge.entrySet()){
                //再把key和value用”#“连接回去，写回到knowledge.txt文件里
                writer.write(entry.getKey()+"#"+entry.getValue());
                //换行
                writer.newLine();
                }
        }catch(IOException e){
            System.out.println("写入文件失败："+e.getMessage());
        }
    }
}
