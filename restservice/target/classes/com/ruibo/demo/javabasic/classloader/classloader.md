# 类加载机制

![JVM类加载器](http://img.blog.csdn.net/20160814103048141)



## 双亲委派机制

### 为什么需要双亲委派机制

* 防止类冲突

### 破坏双亲委派机制

> 根本原因，有些接口是**JDK强制制定的规范标准**，只能使用它们，但是JDK又把它的实现交给了用户，或者用户对JDK的实现不满意，自己进行了重新实现。
>
> 但是，很蛋疼的问题是，用户在调用接口时，由于**双亲委派机制**，用户线程在进行类加载时，会找到父加载器进行类加载（为了安全考虑，可想一想*为什么需要双亲委派模型*），结果父加载器在自己的搜索空间中无法找到对应的Jar包，于是报出ClassNotFoundExp。
>
> 所以，为了保证能够调用到用户定义的实现类，比如用户类路径下classpath，那么在用户线程进行方法调用时，直接对其类加载器进行“截断”，比如将其设置为AppClassLoader阻止其进一步传递给其父加载器。这样实现类就可以在用户类路径下classpath下进行寻找了。

### 自定义类加载器
