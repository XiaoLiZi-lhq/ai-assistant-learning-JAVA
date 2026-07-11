import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 这里需要你：创建Map，放入数据
        HashMap<String,String>ts = new HashMap<>();
        ts.put("你好","你好，我是小助手");
        ts.put("你好吗","我很好，谢谢");
        ts.forEach((key,value)->{
            System.out.println(key+":"+value);
        });
        // 这里需要你：创建Scanner对象

        // 这里需要你：写一个循环，条件是true

        // 这里需要你：读取用户输入，存到String变量里

        // 这里需要你：判断是否输入"bye"，如果是就break

        // 这里需要你：用Map的containsKey方法判断有没有答案

        // 有答案：从Map里取出答案并输出
        // 没答案：输出"抱歉，我还没学会这个问题"

        // 循环结束，关闭Scanner
    }
}