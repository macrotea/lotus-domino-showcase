这是一个基于 **Maven** 构建的Java示例项目，通过构建完整的项目环境，更好地 **测试和实践** 框架或类库的 **某个功能点** 或者 **特性**，从而更利于技能的 **学习**，**积累** 和 **分享** 。

## 简介 ##

- 简单的项目开发骨架
- 基于 Maven3 构建项目
- Domino服务器通过DIOOP访问

## 关注点 ##

- 安装domino的NCSO.jar到本地仓库

mvn install:install-file -Dfile=C:\Domino\Data\domino\java\NCSO.jar -DgroupId=ibm.lotus -DartifactId=domino-ncso -Dversion=0.0.1 -Dpackaging=jar

- 2.解决: Service controller未能在主机上的2050上监听

http://my.oschina.net/bigyuan/blog/68061

- 3.查看diiop_ior.txt文件 : 

http://localhost:80/diiop_ior.txt  
http://localhost:63148/diiop_ior.txt

- 4.hosts添加"127.0.0.1  tea",否则Domino Admin 8.5打不开(tea是domino服务器的服务器名称)

- 5.打开 Domino Admin 8.5 ,然后在 Configuration 标签页的 Basics 的 Fully qualified Internet host name 改成 localhost,且 hosts的文件中添加 "127.0.0.1  localhost"

- 6.解决 "Exception in thread "Thread-0" java.lang.UnsatisfiedLinkError: no nlsxbe in java.library.path "
复制 nlsxbe.dll 文件到 "C:\Windows\System32\",但是我是64位的系统,所以出现了错误: java.lang.UnsatisfiedLinkError: C:\Windows\System32\nlsxbe.dll: Can't load IA 32-bit .dll on a AMD 64-bit platform


## 运行 ##

- git clone
- mvn clean install

## 联系我 ##

- [个人主页](http://www.macrotea.com "http://www.macrotea.com")
- [新浪微博](http://weibo.com/macrotea "http://weibo.com/macrotea")