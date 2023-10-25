

#### jvm 实战命令
 
- jmap -histo:live pid   : 输出当前java进程对象的大小分布情况
- java -Xms32M -Xmx32M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\haoxd\Desktop\job\  -jar xxx.jar  : 当java应用程序发生oom的时候导出dump文件到指定位置
- jmap -dump:format=b,file:/home/var/xxx.hprof pid : 导出应用程序的dump文件

