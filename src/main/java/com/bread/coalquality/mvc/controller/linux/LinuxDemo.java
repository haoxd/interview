package com.bread.coalquality.mvc.controller.linux;

/**
 * @Description: 生产服务变慢谈谈你的分析思路和定位
 *
 *   <>top 命令（查看整体情况）
 *
 *     看cup，内存占用多少
 *     主要看 top 的load average（它分别记录了一分钟、五分钟、以及十五分钟的系统平均负载）
 *   </>
 *
 *   <>uptime 命令（top的精简版）
 *
 *     看cup，内存占用多少
 *     主要看 top 的load average（它分别记录了一分钟、五分钟、以及十五分钟的系统平均负载）
 *   </>
 *
 *   <>vmstat 命令（查看cpu情况 包含不限于）
 *         vmstat -n 2 3 -》 每俩秒采样一次，共计采样三次
 *
 *    procs 参数 分析-》{
 *
 *        r ：表示运行队列(就是说多少个进程真的分配到CPU)，我测试的服务器目前CPU比较空闲，没什么程序在跑，当这个值超过了CPU数目，就会出现CPU瓶颈了。这个也和top的负载有关系，一般负载超过了3就比较高，超过了5就高，超过了10就不正常了，服务器的状态很危险。top的负载类似每秒的运行队列。如果运行队列过大，表示你的CPU很繁忙，一般会造成CPU使用率很高。
 *        b : 表示阻塞的进程,这个不多说，进程阻塞
 *
 *
 *    }
 *
 *    cpu 参数分析 -》{
 *
 *          us：用户进程消耗cpu百分比 us值越高说明用户进程消耗cpu时间多，
 *          sy： 系统CPU时间，如果太高，表示系统调用时间长，例如是IO操作频繁
 *          id: 空闲 CPU时间，一般来说，id + us + sy = 100,一般我认为id是空闲CPU使用率，us是用户CPU使用率，sy是系统CPU使用率。
 *
 *    }
 *
 *   </>
 *
 *   <>mpstat -P ALL 5 2 命令（表示每5秒产生一个报告，总共产生2个。）
 *      能查看所有CPU的平均状况信息，而且能够查看特定CPU的信息。
 *     pidstat -u 1 -p 12804

 *   </>
 *
 *   <> pidstat -u 1 -p 12804 命令（查看一个进程的cpu使用率）
 *      能查看所有CPU的平均状况信息，而且能够查看特定CPU的信息。
 *
 *   </>
 *
 *   <> free 命令（查看内存使用情况）
 *      能查看所有CPU的平均状况信息，而且能够查看特定CPU的信息。
 *      free -h 单位G
 *      free -g 单位G
 *      free -m 单位Mb
 *      pidstat -p 12804 -r 2  查看一个进程的内存使用率


 *   </>
 *
 *   <> df -h 命令（硬盘使用情况）
 *   </>
 *
 *   <> iostat 命令（查看磁盘IO情况）
 *      iostat -xdk 2 3 （每俩秒取样一次，共计取样三次）
 *
 *      参数说明-》{
 *
 *          1 rkb/s ：每秒读取数据量KB
 *          2 wkb/s ：每秒写入数据量KB
 *          3 %util ：一秒钟有百分之几的时间用于I/O 操作，接近百分之100的时候，表示磁盘带宽跑满，需要优化程序。
 *
 *
 *
 *      }
 *
 *      pidstat -p 12804 -d 2  查看一个进程的磁盘读写情况
 *
 *
 *   </>
 *
 *
 *   <>ifstat 命令 查看网络IO情况
 *
 *
 *
 *   </>
 *
 *    ps -mp 4565 -o THREAD,tid,time
 *   分析思路-》{
 *
 *          1：先用top命令找出cpu占比高的程序
 *          2： ps -ef|grep    或者 jps -l 获取是那个程序的问题
 *          3 定位到具体的线程和代码-》{
 *
 *                  1： ps -mp pid -o THREAD,tid,time (定位那个线程执行的时间长)
 *          }
 *          4: 将需要定位的线程id转换为16进制格式（英文|小写格式） printf “%x\n” tid
 *          5： jstack pid |grep tid（16进制的id号） -A60
 *          jstack 15033 |grep 3ac1 -A60
 *
 *   }
 *
 *
 * @Author: haoxd
 * @Version: 1.0
 */
public class LinuxDemo {
}
