## 创建一个泛型数组
T [] datas=(T[])new Object[size];


栈应用的例子
无处不在的撤销（undo）操作
程序调用的系统栈


循环队列关键
* 有两个指针，front 指向队首，tail 指向队尾
* 判断为null front ==tail
* 判断已经满  (tail+1)%c==front   c 是指的队列长度

```
