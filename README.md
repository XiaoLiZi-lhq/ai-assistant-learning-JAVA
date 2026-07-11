# AI Assistant Learning JAVA

一个用于复习 Java 基础知识的问答项目，每次上传都是在上一个版本基础上更加完善的迭代版本。

## 项目说明

本项目通过逐步迭代的方式复习和巩固 Java 核心知识，当前包含两个版本：

### V1 - 入门版（Main.java）

- 使用 `HashMap` 存储问答数据
- 练习 Map 的基本操作（put、get、containsKey）
- 包含待完成的注释提示，适合作为练习题

### V2 - 进阶版（AiAssistant.java）

- 从外部文件 `knowledge.txt` 读取知识库
- 使用 `BufferedReader` + `FileReader` 进行文件 I/O
- 完整的问答交互循环（输入、匹配、退出）
- 支持空输入处理和异常捕获

## 技术要点

- `HashMap` 数据结构
- `Scanner` 用户输入读取
- `BufferedReader` / `FileReader` 文件读取
- `try-with-resources` 异常处理
- 字符串分割与匹配

## 运行方式

在 IntelliJ IDEA 中打开项目，运行 `Main.java` 或 `AiAssistant.java` 即可。

## 知识库格式

`knowledge.txt` 中每行格式为：

```
问题#答案
```

用 `#` 分隔问题和答案。
