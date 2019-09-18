# 设计模式 代码实践
## TODO LIST
- [x] uml图解
- [x] 软件设计七大原则
   - [x] 1.开闭原则
   - [x] 2.里氏替换原则
   - [x] 3.依赖倒置原则
   - [x] 4.单一职责原则
   - [x] 5.接口隔离原则
   - [x] 6.迪米特法则
   - [x] 7.合成复用原则
- [ ] 创建型
	- [ ] 单例模式
	- [ ] 工厂模式
	- [ ] 原型模式
	- [ ] 建造者模式
- [ ] 结构型
	- [ ] 代理模式
	- [ ] 适配器模式
	- [ ] 桥接模式
	- [ ] 装饰模式
	- [ ] 外观模式
	- [ ] 享元模式
	- [ ] 组合模式
- [ ] 行为型
	- [ ] 策略模式
	- [ ] 命令模式
	- [ ] 职责链模式
	- [ ] 状态模式
	- [ ] 观察者模式
	- [ ] 中介者模式
	- [ ] 迭代器模式
	- [ ] 访问者模式
	- [ ] 备忘录模式
	- [ ] 模板方法模式
	- [ ] 解释器模式

***

写在前面：UML图解

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190912140838301.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190912140855113.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

>继承和实现是比较容易理解的两种类关系。在架构设计中，要注意组合、聚合和
依赖这三者的区别。
组合在 语中的含义是把若干个独立部分组成整体 各个部分都有其 立的使用
价值和生命周期。而类关系中的组合是一种完全绑定的关系，所有成员共同完成一件
使命 它们的生命周期是一样的。组合体现的是非常强的整体与部分的关系， 同生共
部分不能在整体之间共享。
聚合是 种可以拆分的整体与部分的关系 是非常松散的暂时组合 部分可以被
拆出来给另一个整体。
依赖 除组合和聚合外的类与类之间的关系 这个类只要 import 那就是依赖关系


类图实例的图形解释：
- 如果出抽象类，类名是用斜体来表示
- "+"表示public
- "-"表示private
- "#"表示protected
- "~"或者什么都不加就表示default的包权限
- 有下划线"_"表示static的属性或者是方法
- 斜体的表示的是抽象方法，既然这个类里面含有抽象方法，那么这个类也必然是一个抽象类
 

*分别截取于大话设计模式以及码处高效*

# （一）软件设计七大原则
    场景：  地点：公司--采购部
            参与人物：部门管理者，采购人员，电脑店铺店主
            物件： 戴尔电脑（windows|linux），联想电脑（windows|linux）
### 一、开闭原则
![开闭原则](https://img-blog.csdnimg.cn/20190912120021480.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例1： 
  某一电脑店铺中摆放着些许电脑，这些电脑都能看到名称跟价钱。
    1.定义一个电脑的接口
  ```java
        /**
         * 电脑接口
         */
        public interface IComputer {
            /**
             * 获得id
             * @return
             */
            Integer getId();
        
            /**
             * 获得名称
             * @return
             */
            String getName();
        
            /**
             * 获得价格
             * @return
             */
            Double getPrice();
        }
  ```
 
  2.现在首先映入眼帘的是一台戴尔电脑。
   ```java
    /**
     * 戴尔电脑
     */
    public class DellComputer implements IComputer {
    
        /**
         * id
         */
        private Integer id;
        /**
         *  名称
         */
        private String name;
        /**
         * 价格
         */
        private Double price;
    
        /**
         * 构造方法 进行设值
         * @param id
         * @param name
         * @param price
         */
        public  DellComputer(Integer id,String name,Double price){
            this.id = id;
            this.name = name;
            this.price = price;
        }
        @Override
        public Integer getId() {
            return id;
        }
    
        @Override
        public String getName() {
            return name;
        }
    
        @Override
        public Double getPrice() {
            return price;
        }
    }

 ```
   3.这台戴尔电脑旁边的标签写着它具体的信息
   ```java
   //1.原价电脑信息
    DellComputer dellComputer = new DellComputer(1, "戴尔e320", 5000D);
    System.out.println("最初电脑信息 ====  id: "+dellComputer.getId()+"  名称："+dellComputer.getName()+"  价格："+dellComputer.getPrice());
  ```
   4.10月1号 迎来了国庆。店家也体现一下自己的爱国心，店铺临时做出了打折活动，电脑将九折出售。
     由于紧急调整，这时候店家直接在原有的接口和类进行修改。
     4.1 加入获得打折后的价格接口方法
   ```java
    
    /**
     * 错误示范：电脑接口 由于需求变动 现在需要遇到节假日进行打折促销活动.接口应该是稳定的，不应该是经常修改的。
     */
    public interface IComputerError {
        /**
         * 获得id
         * @return
         */
        Integer getId();
    
        /**
         * 获得名称
         * @return
         */
        String getName();
    
        /**
         * 获得价格
         * @return
         */
        Double getPrice();
    
        /**
         * 获得打折价格
         * @return
         */
        Double getDiscountPrice();
    }
  ```
  4.2 戴尔电脑实现获得打折后的价格方法
   ```java
   
    /**
     * 错误示范：在原来接口直接进行修改，加入getDiscountPrice方法
     */
    public class DellDiscountComputerError  implements IComputerError  {
        /**
         * id
         */
        private Integer id;
        /**
         *  名称
         */
        private String name;
        /**
         * 价格
         */
        private Double price;
    
        /**
         * 构造方法 进行设值
         * @param id
         * @param name
         * @param price
         */
        public  DellDiscountComputerError(Integer id,String name,Double price){
            this.id = id;
            this.name = name;
            this.price = price;
        }
        @Override
        public Integer getId() {
            return id;
        }
    
        @Override
        public String getName() {
            return name;
        }
    
        @Override
        public Double getPrice() {
            return price;
        }
    
        @Override
        public Double getDiscountPrice() {
            return price*0.9;
        }
    }
   ```
   5.国庆过后，店家想想这样活动，在原先的标签上直接进行价格栏的修改，并不合适。想想应该在做一个单独的标签（在原有的标签下，再加一栏打折后的价格）给活动使用。
   5.1 在原先有的标签，再加一栏打折后的价格
  ```java
    /**
     * 当遇到节假日 促进促销，对电脑进行打折
     */
    public class DellDiscountComputer extends DellComputer {
        /**
         * 构造方法 进行设值
         *
         * @param id
         * @param name
         * @param price
         */
        public DellDiscountComputer(Integer id, String name, Double price) {
            super(id, name, price);
        }
    
        /**
         * 对原来的类进行扩展，不改变原来的接口
         * @return
         */
        public Double getDiscountPrice(){
            return super.getPrice()*0.9;
        }
    }
 
  ```
  6.最终店家看到新的标签，满意地笑了笑~~
  ```java
    //2.打折后电脑信息 虽然实现了功能，但是违反开闭原则，在原来的接口上直接修改
    DellDiscountComputerError discountComputerError = new DellDiscountComputerError(1, "戴尔e320", 5000D);
    System.out.println("打折电脑信息error  ====  id: "+discountComputerError.getId()+"  名称："+discountComputerError.getName()
            +"  价格："+discountComputerError.getPrice()+"  打折价格："+discountComputerError.getDiscountPrice());

    //3.打折后电脑信息 对原有的类进行扩展,不进行修改现有的接口 符合开闭原则
    DellDiscountComputer dellDiscountComputer = new DellDiscountComputer(1, "戴尔e320", 5000D);
    System.out.println("打折电脑信息 ====  id: "+dellDiscountComputer.getId()+"  名称："+dellDiscountComputer.getName()+"  原价价格：" 
             +dellDiscountComputer.getPrice()+"  打折价格："+dellDiscountComputer.getDiscountPrice());
    ```


###  二、里氏替换原则
![里氏替换原则](https://img-blog.csdnimg.cn/20190912120028714.png)

###  三、依赖倒置原则
![依赖倒置原则](https://img-blog.csdnimg.cn/20190912120047917.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

###  四、单一职责原则
![单一职责原则](https://img-blog.csdnimg.cn/20190912115905193.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

### 五、接口隔离原则
![接口隔离原则](https://img-blog.csdnimg.cn/20190912120013656.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

### 六、迪米特法则
![迪米特法则](https://img-blog.csdnimg.cn/20190912115912319.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

###  七、合成复用原则
![合成复用原则](https://img-blog.csdnimg.cn/20190912115920346.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)


*principle目录下是七大设计原则实践*

### 一、创建型
1.单例模式
2.工厂模式
3.原型模式
4.建造者模式

### 二、结构型

### 三、行为型
