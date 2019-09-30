# 设计模式 代码实践
 
## TODO LIST
- [x] UML图解 
- [x] 软件设计七大原则 
   - [x] 1.开闭原则
   - [x] 2.依赖倒置原则
   - [x] 3.单一职责原则
   - [x] 4.接口隔离原则
   - [x] 5.迪米特法则
   - [x] 6.里氏替换原则
   - [x] 7.合成复用原则
- [x] 创建型
	- [x] 单例模式
	- [x] 工厂模式
	- [x] 原型模式
	- [x] 建造者模式
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

 
写在前面：
#  UML图解 

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
![开闭原则](https://img-blog.csdnimg.cn/20190918170004662.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例1：店铺电脑，打折促销 
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


###  二、依赖倒置原则
![依赖倒置原则](https://img-blog.csdnimg.cn/20190918170046853.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例2：采购电脑，进行筛选
  这一天 经公司上层决定，让采购人员再采购一批联想电脑或者戴尔电脑。采购人员刚好人就在该电脑店铺中。这时候她直接拿起了一台戴尔电脑标签看了下价格，但没有放下。紧接着走到一台联想电脑旁边又拿起来这台标签价格。  
  1.定义一个联想电脑。（戴尔电脑参考DellComputer类）  
   ```java
    /**
     *  联想电脑
     */
    public class LenovoComputer implements IComputer {
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
        public  LenovoComputer(Integer id,String name,Double price){
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
  2.定义一个采购人员  
  ```java
    /**
     * 错误示范：采购人员想咨询每个电脑原始价钱 都是依赖具体的方法
     */
    public class PurchaserError {
    
        /**
         * 询问戴尔电脑的价格
         * @param dellComputer
         * @return
         */
        public Double inquiryDellComputerPrice(DellComputer dellComputer){
            return dellComputer.getPrice();
        }
    
        /**
         * 获得联想电脑的价格
         * @param lenovoComputer
         * @return
         */
        public Double inquiryLenovoComputerPrice(LenovoComputer lenovoComputer){
            return lenovoComputer.getPrice();
        }
    }

  ```
  但过了一会，采购人员发现：我并不需要每个标签拿在手上待会还要还回去麻烦~~。我每次看一个，把对应标签拿起来放回去就好了。  
  3.重新定义采购人员  
  ```java
    /**
     * 采购人员1号
     */
    public class PurchaserOne {
    
    
        private IComputer computer;
    
    
        /**
         * 使用setter，而不是构造方法 ，避免每次都要创建一个对象
         * @param computer
         */
        public void setComputer(IComputer computer) {
            this.computer = computer;
        }
    
        public Double inquiryComputerPrice(){
            return computer.getPrice();
        }
    }

  ```
  4.实现效果  
  ```java
    DellComputer dellComputer = new DellComputer(1, "戴尔e320", 5000D);
    LenovoComputer lenovoComputer = new LenovoComputer(1, "联想e480", 6000D);
    //直接依赖具体实现
    PurchaserError purchaserError = new PurchaserError();
    System.out.println("采购人员error 咨询：戴尔价钱="+purchaserError.inquiryDellComputerPrice(dellComputer)
            +"联想价钱="+purchaserError.inquiryLenovoComputerPrice(lenovoComputer));
    //面向了接口编程
    PurchaserOne purchaser = new PurchaserOne();
    purchaser.setComputer(dellComputer);
    System.out.println("采购人员 咨询：戴尔价钱="+purchaser.inquiryComputerPrice());
    purchaser.setComputer(lenovoComputer);
    System.out.println("采购人员 咨询：联想价钱="+purchaser.inquiryComputerPrice());
  ```
   
###  三、单一职责原则
![单一职责原则](https://img-blog.csdnimg.cn/20190918170144804.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例3：员工抱怨，工作太多
  经过商量协商，终于从店家买回来一批戴尔电脑回来，但是还需要将这些电脑安装上公司指定地系统镜像。但采购人员想了想：怎么我买回来，还要负责安装。没办法能者多劳呗！  
  1.定义采购人员购买电脑和安装系统的接口  
  ```java
    /**
     * 错误示范：采购人员接口 将购买电脑 以及 安装系统都两个职责都放在了一起，不利于后面分工。
     *         如果说后期公司又招了运维人员专门管电脑安装 维修等工作，不容易拆分该接口
     */
    public interface IPurchaseError {
    
        /**
         * 购买
         */
          void buyComputer();
    
        /**
         * 安装
         */
        void setupComputer();
    }

  ``` 
  2.定义一个采购人员  
  ```java
     /**
      * 错误示范： 采购人员，假设公司 还未明确分工 采购电脑以及安装系统都交予采购人员
      */
     public class PurchaseTwoError implements IPurchaseError{
     
         private IComputerTwo computer;
     
         public void setComputer(IComputerTwo computer) {
             this.computer = computer;
         }
     
         @Override
         public void buyComputer() {
             System.out.println("购买了"+computer.getName());
         }
     
         @Override
         public void setupComputer() {
             System.out.println("安装了"+computer.getSystem());
         }
     }

  ```
  采购人员还是把自己安装电脑应该招收一个后勤人员专门做这件事的想法 反应了给上层领导。上层领导也同意将这个想法，将安装电脑的职责剥离出来。但在还没招到人的前提下，采购人员还需要继续负责这个职责~~  
  3.将安装电脑剥离出来，单独一个接口  
  ```java
    /**
     * 后勤接口  提供安装系统
     */
    public interface ISupport {
        /**
         * 安装
         */
        void setupComputer();
    }

  ```
  4.采购人员重新实现  
  ```java
    /**
     * 采购人员.公司有意再招收后勤人员来指定安装系统等工作。但是人还没来，故现在采购电脑以及安装系统还是都交予采购人员
     */
    public class PurchaseTwo implements IPurchase,ISupport{
    
        private IComputerTwo computer;
    
        public void setComputer(IComputerTwo computer) {
            this.computer = computer;
        }
    
        @Override
        public void buyComputer() {
            System.out.println("购买了"+computer.getName());
        }
    
        @Override
        public void setupComputer() {
            System.out.println("安装了"+computer.getSystem());
        }
    }

  ```
  5.最终实现的效果  
  ```java
   DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
    PurchaseTwoError purchaseTwoError = new PurchaseTwoError();
    purchaseTwoError.setComputer(dellComputerTwo);
    purchaseTwoError.buyComputer();
    purchaseTwoError.setupComputer();

    PurchaseTwo purchaseTwo = new PurchaseTwo();
    purchaseTwo.setComputer(dellComputerTwo);
    purchaseTwo.buyComputer();
    purchaseTwo.setupComputer();
  ```
  
### 四、接口隔离原则  
![接口隔离原则](https://img-blog.csdnimg.cn/20190918170309777.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例4： 不在其位，不谋其政
  又到了每个季度召开一次员工大会，领导者 听取手下员工建议的时候到了。  
  这时候，采购人员终于有机会把自己的想法表达出来给领导：您好，总经理！ 我是采购人员三号。我现在的职责有购买电脑，打印发票，联系商家，安装电脑，连接公司打印机....我觉得我的职责不应该这么分配，我应该做好自己分内的事，而不是承担这么多工作！  
  1.定义一个采购人员的职责接口  
  ```java
    /**
     * 错误示范：采购人员接口 将购买电脑 以及 安装系统都两个职责都放在了一起，不利于后面分工。
     *         如果说后期公司又招了运维人员专门管电脑安装 维修等工作，不容易拆分该接口
     */
    public interface IPurchaseThreeError {
        /**
         * 购买电脑
         */
        void buyComputer();
    
        /**
         * 打印发票
         */
        void printInvoice();
    
        /**
         * 对接店家
         */
        void contactShop();
    
        /**
         * 安装
         */
        void setupComputer();
    
        /**
         * 连接打印机
         */
        void linkPrinter();
    }

  ```
  2.采购人员实现职责  
  ```java
    /**
     * 错误示范： 采购人员，假设公司 还未明确分工 采购电脑以及安装系统都交予采购人员
     */
    public class PurchaseThreeError implements IPurchaseThreeError{
    
        private IComputerTwo computer;
    
        public void setComputer(IComputerTwo computer) {
            this.computer = computer;
        }
        @Override
        public void buyComputer() {
            System.out.println("购买了"+computer.getName());
        }
    
        @Override
        public void printInvoice() {
            System.out.println("打印了"+computer.getName()+"的发票");
        }
    
        @Override
        public void contactShop() {
            System.out.println("联系了"+computer.getName()+"的店家");
        }
    
        @Override
        public void setupComputer() {
            System.out.println("安装了"+computer.getSystem());
        }
    
        @Override
        public void linkPrinter() {
            System.out.println("连上了公司的打印机");
        }
    }

  ```
  领导想想也对，那就决定再招收一个运维人员，专门负责安装电脑跟连接打印机的工作。但是呢，这个运维人员还没到岗，还是需要采购人员负责这两项工作。    
  3.重新划分职责，采购人员的接口  
  ```java
    /**
     *  采购人员的职责 包含采购电脑，打印发票，对接店家等职责
     */
    public interface IPurchaseThree {
        /**
         * 购买
         */
        void buyComputer();
    
        /**
         * 打印发票
         */
        void printInvoice();
    
        /**
         * 对接店家
         */
        void contactShop();
    
    }

  ```
  4.运维人员接口  
  ```java
    /**
     * 后勤接口  提供安装系统，连接打印机
     */
    public interface ISupportThree {
            /**
             * 安装
             */
            void setupComputer();
    
            /**
             * 连接打印机
             */
            void linkPrinter();
    }

  ```
  5.采购人员重新实现职责  
  ```java
    /**
     * 采购人员。 公司招收的运维人员还未到岗，采购电脑以及安装系统都交予采购人员
     */
    public class PurchaseThree implements IPurchaseThree,ISupportThree {
    
        private IComputerTwo computer;
    
        public void setComputer(IComputerTwo computer) {
            this.computer = computer;
        }
        @Override
        public void buyComputer() {
            System.out.println("购买了"+computer.getName());
        }
    
        @Override
        public void printInvoice() {
            System.out.println("打印了"+computer.getName()+"的发票");
        }
    
        @Override
        public void contactShop() {
            System.out.println("联系了"+computer.getName()+"的店家");
        }
    
        @Override
        public void setupComputer() {
            System.out.println("安装了"+computer.getSystem());
        }
    
        @Override
        public void linkPrinter() {
            System.out.println("连上了公司的打印机");
        }
    }

  ```
  6.最终的效果  
  ```java
    DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
    PurchaseThreeError purchaseThreeError = new PurchaseThreeError();
    purchaseThreeError.setComputer(dellComputerTwo);
    purchaseThreeError.buyComputer();
    purchaseThreeError.contactShop();
    purchaseThreeError.printInvoice();
    purchaseThreeError.setupComputer();
    purchaseThreeError.linkPrinter();
    
    PurchaseThree purchaseThree = new PurchaseThree();
    purchaseThree.setComputer(dellComputerTwo);
    purchaseThree.buyComputer();
    purchaseThree.contactShop();
    purchaseThree.printInvoice();
    purchaseThree.setupComputer();
    purchaseThree.linkPrinter();
  ```
  
### 五、迪米特法则
![迪米特法则](https://img-blog.csdnimg.cn/20190918170346591.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例5： 物资紧缺，咨询订购
  过完春节后的一个月，发现公司又招收了好多新来的人员，发现电脑不够。这时候采购部部长需要再定一批电脑回来，于是想问问当初那家电脑店铺还有多少电脑？    
  1.定义店铺  
  ```java
    
    /**
     * 店铺
     */
    public class Shop {
    
        /**
         * 模拟剩余电脑数量
         */
        public void rest(){
            System.out.println("还剩余200台");
        }
    }

  ```
  2.采购部长想去咨询当初那家店铺的实现  
  ```java
    /**
     * 错误示范：某一天 采购部长想知道对接的店家那里还有多少的电脑存量。这时候自己去询问店家
     */
    public class ManagerError {
    
        /**
         * 直接询问店家剩余数量
         * @param shop
         */
        public void inquiryRest(Shop shop){
            shop.rest();
        }
    }

  ```
  但是想了想，还是应该让底下的员工去对接一下那家店铺，让底下采购员工去落实这件事情。  
  3.采购人员落实的实现  
  ```java
    /**
     * 采购人员对接店家 询问剩余电脑数量
     */
    public class PurchaseFour implements IPurchaseThree {
    
        private IComputerTwo computer;
        //这里的shop也应该面对接口编程，而不是具体实例，但此例只为演示迪米特法则
        private Shop shop;
    
        public void setShop(Shop shop) {
            this.shop = shop;
        }
    
        public void setComputer(IComputerTwo computer) {
            this.computer = computer;
        }
        @Override
        public void buyComputer() {
            System.out.println("购买了"+computer.getName());
        }
    
        @Override
        public void printInvoice() {
            System.out.println("打印了"+computer.getName()+"的发票");
        }
    
        @Override
        public void contactShop() {
            System.out.println("联系了"+computer.getName()+"的店家");
        }
    
        //模拟店家回答
        public void inquiryRest(){
            shop.rest();
        }
    
    }

  ```
  4.最终的效果  
  ```java
    DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
    Shop shop = new Shop();
    //部门管理者 自己询问 违反迪米特法则
    ManagerError managerError = new ManagerError();
    managerError.inquiryRest(shop);

    //部门管理者通过采购人员咨询
    PurchaseFour purchaseFour = new PurchaseFour();
    purchaseFour.setComputer(dellComputerTwo);
    purchaseFour.setShop(shop);
    Manager manager = new Manager();
    manager.inquiryRest(purchaseFour);

  ```

###  六、里氏替换原则
![里氏替换原则](https://img-blog.csdnimg.cn/20190918170421778.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例6： 一人量大，招人帮忙
  近期，采购部长发现采购员工4号的工作量很大，其他采购员工也无法分担，所以又招收了一名采购人员5号。  
  采购5号刚来，所以采购部长让采购4号带带她，并吩咐让联系店家的职责给采购人员4号负责。  
  但是采购人员4号很忙，就只告诉了采购人员5号那家店名等信息，而采购人员5号并不熟悉原先联系的情况。  
  1.采购人员5号，由于不知道情况，就去了一趟实体店。(采购人员4号参考PurchaseFour类)  
  ```java
    /**
     * PurchaseFive 是新人，刚进公司，而且总管希望能PurchaseFive能胜任PurchaseFour的工作，
     * 让PurchaseFive成为PurchaseFour的徒弟
     * 但是PurchaseFive 在联系店家的时候，竟然去做了趟附近实体店
     */
    public class PurchaseFiveError extends PurchaseFour {
        @Override
        public void contactShop() {
            System.out.println("去了趟附近的实体店");
            super.contactShop();
        }
    }

  ```
  但采购部长路过前台，发现采购人员5号，刚从外面回来。所以问了下原因。  
  后来部长告诉她，上次那家店拿回来了一张名片，可以先打电话问问，等沟通上了，确定了实际情况再去实体店，并且外出需要打报告的。  
  2.采购人员5号一听懂了  
  ```java
    /**
     * PurchaseFive 是新人，刚进公司，而且总管希望能PurchaseFive能胜任PurchaseFour的工作，
     * 让PurchaseFive成为PurchaseFour的徒弟
     */
    public class PurchaseFive extends PurchaseFour {
    
        /**
         * 外出
         */
        public void goOutside(){
            System.out.println("外出申请报告");
            System.out.println("去了趟附近的实体店");
        }
    }

  ```
  3.最终的效果  
  ```java
    DellComputerTwo dellComputerTwo = new DellComputerTwo(3, "戴尔e340", "windows 10", 5500D);
    Shop shop = new Shop();
    PurchaseFiveError purchaseFiveError = new PurchaseFiveError();
    purchaseFiveError.setComputer(dellComputerTwo);
    purchaseFiveError.setShop(shop);
    //部门管理者让采购人员联系商家的时候  他竟然还出去调研了。
    purchaseFiveError.contactShop();

    PurchaseFive purchaseFive = new PurchaseFive();
    purchaseFive.setComputer(dellComputerTwo);
    purchaseFive.setShop(shop);
    //部门管理者让采购人员联系商家的时候  他就咨询了店家。
    purchaseFive.contactShop();

  ```

###  七、合成复用原则
![合成复用原则](https://img-blog.csdnimg.cn/20190918170454614.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
  #### 示例7：  安装测试，合理利用
  由于公司不同岗位，需要电脑的操作系统不尽相同（假设有windows和linux）。  
  但最近根据信息安全的要求，更新了新版的镜像（操作系统安装软件），需要空出电脑来测试安装新的版本。  
  1.定义一个启动电脑的接口  
  ```java
    /**
     * 抽象操作系统类
     */
    public abstract class OperationSystem {
        /**
         *  启动电脑
         */
        public abstract void run();
    }

  ```
  2.windows操作系统  
  ```java
    /**
     * windows操作系统
     */
    public class Windows extends OperationSystem{
        @Override
        public void run(){
            System.out.println("windows 系统启动！");
        }
    }

  ```
  3.linux操作系统  
  ```java
    /**
     * linux操作系统
     */
    public class Linux extends OperationSystem{
        @Override
        public void run() {
            System.out.println("linux 加载桌面");
        }
    }

  ```
  4.安装了windows系统的电脑  
  ```java
    /**
     * 电脑 搭载这windows系统
     */
    public class DellComputerThreeError extends Windows {
        public void power(){
            System.out.println("按下电源键");
            super.run();
        }
    }

  ```
  5.安装了linux系统的电脑  
  ```java
    /**
     * 电脑 搭载这linux系统
     */
    public class DellComputerFourError extends Linux {
        public void power(){
            System.out.println("按下电源键");
            super.run();
        }
    }

  ```
  但采购人员想了想：我只要一台好的电脑就够了，为什么还要用两台。  
  6.电脑改造安装系统  
  ```java
    /**
     * 合成复用示例 戴尔电脑
     */
    public class DellComputerThree {
        
        private OperationSystem operationSystem;
    
        public void setOperationSystem(OperationSystem operationSystem) {
            this.operationSystem = operationSystem;
        }
        public  void power(){
            System.out.println("按下电源键");
            operationSystem.run();
        }
    }

  ```
  7.最终的效果  
  ```java
      //通过每次直接继承抽象类。每次有新的类型则会有新的类成对产生
      DellComputerThreeError dellComputerThreeError = new DellComputerThreeError();
      dellComputerThreeError.power();

      DellComputerFourError dellComputerFourError = new DellComputerFourError();
      dellComputerFourError.power();

      //通过组合的方式，可以减少
      DellComputerThree dellComputerThree = new DellComputerThree();
      dellComputerThree.setOperationSystem(new Windows());
      dellComputerThree.power();

      dellComputerThree.setOperationSystem(new Linux());
      dellComputerThree.power();
  ```
  
  
  
*principle目录下是七大设计原则实践*

### 一、创建型
写在前面：
为什么需要创建型模式？
<pre>
首先，在编程中，对象的创建通常是一件比较复杂的事，因为，为了达到降低耦合的目的，我们通常采用面向抽象编程的方式，对象间的关系不会硬编码到类中，而是等到调用的时候再进行组装，这样虽然降低了对象间的耦合，提高了对象复用的可能，但在一定程度上将组装类的任务都交给了最终调用的客户端程序，大大增加了客户端程序的复杂度。采用创建类模式的优点之一就是将组装对象的过程封装到一个单独的类中，这样，既不会增加对象间的耦合，又可以最大限度的减小客户端的负担。

其次，使用普通的方式创建对象，一般都是返回一个具体的对象，即所谓的面向实现编程，这与设计模式原则是相违背的。采用创建类模式则可以实现面向抽象编程。客户端要求的只是一个抽象的类型，具体返回什么样的对象，由创建者来决定。

再次，可以对创建对象的过程进行优化，客户端关注的只是得到对象，对对象的创建过程则不关心，因此，创建者可以对创建的过程进行优化，例如在特定条件下，如果使用单例模式或者是使用原型模式，都可以优化系统的性能。
</pre>


1.单例模式
1.1 定义及相关定义对比
![单例模式](https://img-blog.csdnimg.cn/20190930094357143.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

1.2 UML类图
![单例UML类图](https://img-blog.csdnimg.cn/20190930085647193.png)

1.3 实现
1.3.1 饿汉模式
```java
/**
 * 单例模式 饿汉模式:类初始化的时候，会立即加载该对象，线程天生安全，调用效率高。
 */
public class SingletonHunger {
    /**
     * 1.将构造函数私有化，不允许外部直接创建对象
     */
    private SingletonHunger() {
    }

    /**
     * 2.创建类的唯一私有实例,一旦加载类就进行初始化实例
     */
    private static final SingletonHunger instance = new SingletonHunger();

    /**
     * 3.提供外部使用
     * @return
     */
    public static SingletonHunger getInstance() {
        return instance;
    }
}

```


1.3.2 懒汉模式（双重检测）
```java
/**
 * 单例模式 双重检测 （因为JVM本身重排序的原因，可能会出现多次的初始化）懒汉模式：类初始化时，不会初始化该对象，真正需要使用的时候才会去创建该对象，具备懒加载功能。
 */
public class SingletonLazyOne {
    /**
     * 1.将默认构造函数私有化
     */
    private SingletonLazyOne(){}

    /**
     * 2.创建类的唯一私有实例。  volatile 修饰的成员变量可以确保多个线程都能够正确处理
     */
    private static volatile SingletonLazyOne instance;

    /**
     * 3.提供外部使用，当需要获得该类的实例，判断是否已存在，若无则进行创建该实例。
     * 当然代码中使用了锁就会有额外的开销 对性能有一定的影响
     * @return
     */
    public static SingletonLazyOne getInstance(){
        if (instance==null){
            synchronized (instance) {
                if(instance==null){
                    instance = new SingletonLazyOne();
                }
            }
        }
        return instance;
    }
}

```


1.3.3 懒汉模式（静态内部类）
```java
/**
 * 单例模式 静态内部类 懒汉模式：类初始化时，不会初始化该对象，真正需要使用的时候才会去创建该对象，具备懒加载功能。
 */
public class SingletonLazyTwo {
    /**
     * 1.将默认构造函数私有化
     */
    private SingletonLazyTwo(){}

    /**
     * 2.创建内部类，并且拥有的一个私有外部实例
     */
    private  static class SingletonLazy{
        private static  final SingletonLazyTwo singletonLazyTwo =new SingletonLazyTwo();
    }

    /**
     * 3.提供外部使用，当需要获得该类的实例，才去初始化内部类的静态实例（利用jvm初始化类的特性）
     * 虽然不会创建静态内部类的对象，但是其 Class 对象还是会被加载。
     * @return
     */
    public static SingletonLazyTwo getInstance(){
        return SingletonLazy.singletonLazyTwo;
    }
}
```

1.3.4 懒汉模式（枚举）
```java
/**
 * 单例模式 枚举 懒汉模式：类初始化时，不会初始化该对象，真正需要使用的时候才会去创建该对象，具备懒加载功能。
 */
public class SingletonLazyThree {

    /**
     * 1.将默认构造函数私有化
     */
    private SingletonLazyThree(){}

    /**
     * 2.创建枚举类  避免反射攻击
     */
    private enum SingletonLazy{
        INSTANCE;
        private SingletonLazyThree singleton;

        /**
         * JVM会保证此方法绝对只调用一次
         */
        SingletonLazy(){
            singleton = new SingletonLazyThree();
        }
        public SingletonLazyThree getInstance(){
            return singleton;
        }
    }

    /**
     * .提供外部使用，当需要获得该类的实例
     * @return
     */
    public static SingletonLazyThree getInstance(){
        return SingletonLazy.INSTANCE.getInstance();
    }
}

```
1.3.5  多例模式
```java
import java.util.HashMap;
import java.util.Map;

/**
 * 多例模式   类似Spring里面的方法，将类名注册，下次从里面直接获取。
 */
public class MultiSingleton {
    private static Map<String, MultiSingleton> map = new HashMap<String, MultiSingleton>();

    /**
     * 静态代码块 初始化一次
     */
    static {
        MultiSingleton single = new MultiSingleton();
        map.put(single.getClass().getName(), single);
    }

    /**
     * 保护的默认构造子
     */
    protected MultiSingleton() {
    }

    /**
     * 静态工厂方法,返还此类惟一的实例
     * @param name
     * @return
     */
    public static MultiSingleton getInstance(String name) {
        if (name == null) {
            name = MultiSingleton.class.getName();
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (MultiSingleton) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}

```



2.工厂模式
2.1 工厂方法模式
2.1.1 定义及相关定义对比
![工厂方法模式](https://img-blog.csdnimg.cn/20190930104732245.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

2.1.2 UML类图
![工厂方法UML类图](https://img-blog.csdnimg.cn/20190930104815340.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

2.1.3 实现
现在 一家饮料店新开业 开始卖奶茶给顾客。
2.1.3.1 Drink.java 接口: 负责用什么材料制作
```java
/**
 * 饮料接口
 */
public interface Drink {
     /**
      * 用什么材料
      */
     void withMaterial();
}

```
2.1.3.2 MilkTea.java 奶茶: 实现饮料的接口
```java
/**
 * 奶茶
 */
public class MilkTea implements Drink{
    @Override
    public void withMaterial() {
        System.out.println("混合珍珠奶茶");
    }
}

```

2.1.3.3 DrinkFactory.java 接口: 负责制作材料
```java
/**
 * 饮料工厂
 */
public interface DrinkFactory {
    /**
     * 制作饮料
     * @return
     */
    Drink produceDrink();
}

```

2.1.3.4 DrinkFactory.java 接口: 负责制作什么材料
```java
/**
 * 饮料工厂
 */
public interface DrinkFactory {
    /**
     * 制作饮料
     * @return
     */
    Drink produceDrink();
}

```


2.1.3.4 ConcreteDrinkFactory.java 奶茶工厂: 负责制作奶茶
```java
/**
 * 饮料工厂实现
 */
public class ConcreteDrinkFactory implements DrinkFactory {
    @Override
    public Drink produceDrink() {
        return new MilkTea();
    }
}

```

2.1.3.5  这家店  卖奶茶
```java
  //卖饮料的 只推出奶茶等
        DrinkFactory concreteDrinkFactory = new ConcreteDrinkFactory();
        Drink drink = concreteDrinkFactory.produceDrink();
        drink.withMaterial();
```



2.2 抽象工厂模式
2.2.1 定义及相关定义对比
![抽象工厂模式](https://img-blog.csdnimg.cn/20190930111426893.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)
2.2.2 UML类图
![抽象工厂UML类图](https://img-blog.csdnimg.cn/20190930111441842.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)


2.2.3 实现
现在 一家西式糕点店新开业 开始既卖奶茶又卖甜点给顾客。
2.2.3.1 Drink.java MilkTea.java  DrinkFactory.java  ConcreteDrinkFactory.java 饮料参考工厂方法代码

2.2.3.2 Dessert.java 接口： 负责用什么麦制作
```java
/**
 * 甜点
 */
public interface Dessert {
    /**
     * 用什么麦
     */
    void withFlour();
}

```

2.2.3.3 MiniCake.java 小蛋糕： 负责用小麦制作
```java
/**
 * 小蛋糕
 */
public class MiniCake implements Dessert {
    @Override
    public void withFlour() {
        System.out.println("小麦蛋糕甜点");
    }
}

```

2.2.3.4 WesternFactory.java 接口： 生成不同系列的产品（奶茶 ，蛋糕）
```java
/**
 * 西餐厅工厂接口
 */
public interface WesternFactory {
    /**
     * 制作甜点
     * @return
     */
    Dessert produceDessert();

    /**
     * 制作饮料
     * @return
     */
    Drink produceDrink();
}
```

2.2.3.5 ConcreteWesternFactory.java 西餐厅： 提供领料 蛋糕
```java
/**
 * 西餐厅实现
 */
public class ConcreteWesternFactory implements WesternFactory {
    @Override
    public Dessert produceDessert() {
        return new MiniCake();
    }

    @Override
    public Drink produceDrink() {
        return new MilkTea();
    }
}

```


2.2.3.6 西餐厅店 推出甜点 跟 饮料
```java
      //西餐厅店 推出甜点 跟 饮料。
        WesternFactory concreteWesternFactory = new ConcreteWesternFactory();
        Drink drink1 = concreteWesternFactory.produceDrink();
        Dessert dessert = concreteWesternFactory.produceDessert();
        drink1.withMaterial();
        dessert.withFlour();
```


3.原型模式
3.1 定义及相关定义对比
![原型模式](https://img-blog.csdnimg.cn/20190930115524151.png)

3.2 UML类图
![原型UML类图](https://img-blog.csdnimg.cn/20190930115546558.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

3.3 实现
3.3.1 浅克隆
（Object类的clone方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝）
ShallowClone.java
```java
import java.util.List;

/**
 * 浅克隆 ：Object类的clone方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对象等都不会拷贝
 */
public class ShallowClone implements Cloneable{
    private String name;
    private int num;
    private List children;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }
}

```
3.3.2 深克隆
（必须将原型模式中的数组、容器对象、引用对象等另行拷贝）
```java
/**
 * 深克隆：将原型模式中的数组、容器对象、引用对象等另行拷贝  使用序列化拷贝
 */
public class DeepClone implements Serializable {
    private String name;
    private int num;
    private ArrayList children;

    public Object deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis=new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);

        return(ois.readObject());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ArrayList getChildren() {
        return children;
    }

    public void setChildren(ArrayList children) {
        this.children = children;
    }
}

```

3.3.3 测试
```java
    ShallowClone shallowClone = new ShallowClone();
        shallowClone.setNum(10);
        shallowClone.setName("克隆1号");
        shallowClone.setChildren(Arrays.asList("部件1", "部件2", "部件3"));

        ShallowClone shallowClone1 = null;
        try {
            shallowClone1 = (ShallowClone) shallowClone.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //通过克隆创建了新对象 所以false
        System.out.println(shallowClone.equals(shallowClone1));
        //但是对象内容的地址引用都是同一个地址 所以都是true
        System.out.println(shallowClone.getName()==(shallowClone1.getName()));
        System.out.println(shallowClone.getChildren()==(shallowClone1.getChildren()));


        System.out.println("--------------深克隆------------------");
        DeepClone deepClone = new DeepClone();
        deepClone.setName("克隆2号");
        deepClone.setNum(12);
        deepClone.setChildren(new ArrayList(){{add("部件1"); add("部件2");add("部件3");}});

        try {
            DeepClone deepClone1 = (DeepClone) deepClone.deepClone();
            System.out.println(deepClone.getName()==(deepClone1.getName()));
            System.out.println(deepClone.getChildren()==(deepClone1.getChildren()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
```


4.建造者模式
4.1 定义及相关定义对比
![建造者模式](https://img-blog.csdnimg.cn/20190930142138309.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

4.2 UML类图
![建造者UML类图](https://img-blog.csdnimg.cn/20190930141447493.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbG9uZ2h1YW5nMTU3NDA1,size_16,color_FFFFFF,t_70)

4.3 实现
一桶方便面的制作，包含调味包，面块，叉子。

4.3.1 InstantNoodles.java  方便面：由叉子 面块 调味包组成
```java
/**
 * 方便面
 */
public class InstantNoodles {
    /**
     * 调味包
     */
    private String seasoningPacket;

    /**
     * 面块
     */
    private String noodles;

    /**
     * 叉子
     */
    private String fork;

    public String getSeasoningPacket() {
        return seasoningPacket;
    }

    public void setSeasoningPacket(String seasoningPacket) {
        this.seasoningPacket = seasoningPacket;
    }

    public String getNoodles() {
        return noodles;
    }

    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }
}

```

4.3.2 Builder.java 接口:方便面制造步骤
```java
/**
 * 方便面制造接口
 */
public interface Builder {

    /**
     * 制造调味包
     */
    void buildSeasoningPacket();

    /**
     * 制造面块
     */
    void buildNoodles();

    /**
     * 制造叉子
     */
    void buildFork();

    /**
     * 获得方便面
     * @return
     */
    InstantNoodles getInstantNoodles();
}

```


4.3.3 BuilderDirector.java 生成方便面:方便面制造步骤组装
```java
/**
 * 导演者
 */
public class BuilderDirector {
    /**
     * 抽象建造者
     */
    private Builder builder;

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    /**
     * 返回方便面
     * @return
     */
    public InstantNoodles getInstantNoodles(){
        builder.buildSeasoningPacket();
        builder.buildNoodles();
        builder.buildFork();
        return builder.getInstantNoodles();
    }
}

```


4.3.4 SeafoodInstantNoodlesBuilder.java 海鲜方便面:实现方便面制造步骤
```java
/**
 * 海鲜方便面
 */
public class SeafoodInstantNoodlesBuilder implements Builder{

    private InstantNoodles instantNoodles =new InstantNoodles();

    @Override
    public void buildSeasoningPacket() {
        instantNoodles.setSeasoningPacket("海鲜调味包");
    }

    @Override
    public void buildNoodles() {
        instantNoodles.setNoodles("小块面");
    }

    @Override
    public void buildFork() {
        instantNoodles.setFork("塑料叉");
    }

    @Override
    public InstantNoodles getInstantNoodles() {
        return instantNoodles;
    }
}

```


4.3.5 SpicyInstantNoodlesBuilder.java 麻辣方便面:实现方便面制造步骤
```java
/**
 * 麻辣方便面
 */
public class SpicyInstantNoodlesBuilder implements Builder{

    private InstantNoodles instantNoodles = new InstantNoodles();

    @Override
    public void buildSeasoningPacket() {
        instantNoodles.setSeasoningPacket("麻辣调味包");
    }

    @Override
    public void buildNoodles() {
        instantNoodles.setNoodles("大块面");
    }

    @Override
    public void buildFork() {
        instantNoodles.setFork("塑料叉");
    }

    @Override
    public InstantNoodles getInstantNoodles() {
        return instantNoodles;
    }
}

```



4.3.6 测试
```java
        BuilderDirector builderDirector = new BuilderDirector();
        builderDirector.setBuilder(new SeafoodInstantNoodlesBuilder());
        InstantNoodles instantNoodles = builderDirector.getInstantNoodles();
        System.out.println(instantNoodles.getSeasoningPacket());

        builderDirector.setBuilder(new SpicyInstantNoodlesBuilder());
        instantNoodles = builderDirector.getInstantNoodles();
        System.out.println(instantNoodles.getSeasoningPacket());
```


### 二、结构型

### 三、行为型
