

#### ElasticSearch
 
-  倒排索引 ：
    数据结构 -
    
            {
             1 term dict (词项字典)   数据结构 fst
             2 posting List (包含词项的所有ID list)   压缩算法（FOR（解决稠密数租），RBM（解决稀疏数组））
             3 term index 词项字典的索引     数据结构 fst
            }
            

- 字典树
        
            {
                    
            
            }
            
- 写入原理

            {
            
                1 发起写入请求
                2 内存写入buffer
                3 内存写入buffer 1秒后 写入到segment 文件当中 （倒排索引文件）， 
                4 同步到os cache当中（物理内存）
                5 修改文件状态 open 清空buffer
                6 当segment达到一定大小的时候，触发 commit point 操作 将 segment文件进行合并整理 创建新的commit point操作，将就的
                    segment文件标记为删除，将新的segment文件标记为可搜索状态 ，然后删除就的文件
                7 触发flush操作，当文件大小或者达到一定时间 默认30分钟，将os-cache当中的segment同步到磁盘，同时情况tranceLog文件
                    
            }   