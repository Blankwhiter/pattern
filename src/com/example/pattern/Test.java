package com.example.pattern;

import com.example.pattern.adapter.*;
import com.example.pattern.builder.BuilderDirector;
import com.example.pattern.builder.InstantNoodles;
import com.example.pattern.builder.SeafoodInstantNoodlesBuilder;
import com.example.pattern.builder.SpicyInstantNoodlesBuilder;
import com.example.pattern.cglib.Train;
import com.example.pattern.cglib.cglibProxy;
import com.example.pattern.cor.Customer;
import com.example.pattern.cor.Director;
import com.example.pattern.cor.PriceHandlerFactory;
import com.example.pattern.factory.*;
import com.example.pattern.mediator.ConcreteMediator;
import com.example.pattern.mediator.Program;
import com.example.pattern.mediator.ProgramA;
import com.example.pattern.mediator.ProgramB;
import com.example.pattern.observer.AlarmDevice;
import com.example.pattern.observer.TemperatureSensor;
import com.example.pattern.prototype.DeepClone;
import com.example.pattern.prototype.ShallowClone;
import com.example.pattern.proxy.*;
import com.example.pattern.singleton.SingletonHunger;
import com.example.pattern.singleton.SingletonLazyOne;
import com.example.pattern.strategy.BcTax;
import com.example.pattern.strategy.DzTax;
import com.example.pattern.template.Coffee;
import com.example.pattern.template.FreshTea;
import com.example.pattern.template.Tea;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
//        TestSingleton();
//        TestProxy();
//        TestCor();
//        TestStrategy();
//        TestTemplate();
//        TestAdapter();
//        TestBuilder();
//        TestPrototype();
//        TestObserver();
//        TestMediator();

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
////        for (int i = 0; i < 20; i++) {
////            priorityQueue.offer(i);
////        }
//        priorityQueue.addAll(Arrays.asList(20,10,130,10,33,44,55,66,77,88,99,23,234));
//        System.out.println(priorityQueue);
//        for (int i = 0; i < priorityQueue.size(); i++) {
//            System.out.print(priorityQueue.poll());
//        }


    }



    /**
     * 区别：饿汉模式 加载类的时候速度较慢，但运行时获取对象速度较快 线程安全
     *      懒汉模式 加载类的时候速度较快，但运行时获得对象速度较慢  线程不安全
     */
    public static void TestSingleton() {
        //饿汉模式
        SingletonHunger hunger1 = SingletonHunger.getInstance();
        SingletonHunger hunger2 = SingletonHunger.getInstance();
        if (hunger1==hunger2) {
            System.out.println("[**** 饿汉模式 两个实例相等 ****]");
        }else {
            System.out.println("[**** 饿汉模式 两个实例不相等 ****]");
        }
        //懒汉模式
        SingletonLazyOne lazy1 = SingletonLazyOne.getInstance();
        SingletonLazyOne lazy2 = SingletonLazyOne.getInstance();
        if (lazy1==lazy2) {
            System.out.println("[**** 懒汉模式 两个实例相等 ****]");
        }else {
            System.out.println("[**** 懒汉模式 两个实例不相等 ****]");
        }
    }

    /**
     * 代理模式
     */
    public static void TestProxy(){
//      一、 静态代理
        //1.继承方式
        Car1 car1 = new Car1();
        car1.move();
        //2.聚合方式
        Car car = new Car();
        Moveable moveable= new Car2(car);
        moveable.move();
// 聚合模式比继承模式更适合代理模式.更容易拓展：
// 假设在汽车上有需要先实现记录时间 再实现日志业务的逻辑，以及先实现日志业务，再记录时间的逻辑。继承模式就会显得不够灵活。需要不断的创造对应的类进行实现业务。聚合模式只需要调换代理的顺序。
        //1.先记录时间 再实现日志服务
        Car newCar1 = new Car();
        CarTimeProxy carTimeProxy1 = new CarTimeProxy(newCar1);
        CarLogProxy carLogProxy1 = new CarLogProxy(carTimeProxy1);
        carLogProxy1.move();
        //2.先实现日志业务，再记录时间
        Car newCar2 = new Car();
        CarLogProxy carLogProxy2 = new CarLogProxy(newCar2);
        CarTimeProxy carTimeProxy2 = new CarTimeProxy(carLogProxy2);
        carTimeProxy2.move();
// 业务拓展情景：这是汽车的时间与日志代理，假设该站点又代理了火车的时间与日志代理，
// 在静态代理中 则需要再进行创建火车的代理，这样推算下去，业务不断的拓展，代理将会无限的新增，故再此引出了动态代理
//      二、动态代理
        //1.jdk动态代理
        //步骤：1.创建一个实现接口InvocationHandler的类，他必须实现invoke方法。2.创建被代理的类与接口。3.调用Proxy的静态方法创建一个代理类（Proxy.newProxyInstance）。4.通过代理调用方法
        Car newCar3 = new Car();
        Class<? extends Car> newCar3Class = newCar3.getClass();
        InvocationHandler timeHandle = new TimeHandler(newCar3);
        Moveable timeProxy = (Moveable) java.lang.reflect.Proxy.newProxyInstance(newCar3Class.getClassLoader(), newCar3Class.getInterfaces(), timeHandle);
        timeProxy.move();
        LogHandler logHandle = new LogHandler(newCar3);
        Moveable logProxy = (Moveable) Proxy.newProxyInstance(newCar3Class.getClassLoader(), newCar3Class.getInterfaces(), logHandle);
        logProxy.move();
//      在上述的jdk动态代理的例子中可以看出jdk动态代理 只能代理实现了接口的类。
//      故引出CGLIB动态代理，该代理针对类来实现代理，对指定的目标类生成一个子类，通过方法拦截技术拦截所有父类方法的调用.使用第三方jar：cglib-nodep
        cglibProxy cglibProxy = new cglibProxy();
        Train trainProxy = (Train) cglibProxy.getProxy(Train.class);
        trainProxy.move();
    }

    /**
     * 责任链模式  客户与销售解耦，客户并不知道谁能决定折扣价钱，只需要知道能不能打折。由于是链条比较耗性能。
     */
    public static  void TestCor(){
        Customer customer = new Customer();
        //交给 工厂模式
        customer.setPriceHandler(PriceHandlerFactory.createHandler());
        for(int i=1;i<10;i++){
            customer.requestDiscount(new Random().nextFloat());
        }

    }

    /**
     * 应用场景：许多相关的类仅仅是行为差异 运行时选取不容的算法变体 通过条件语句在多个分支中选取一个
     * 好处：使用了组合，使架构更加灵活
     * 富有弹性 可以较好的应对变化（开一闭原则）
     * 消除大量的条件语句
     * 缺点：客户代码需要了解每个策略实现的细节
     * 增加对象的数目
     */
    public static  void TestStrategy(){
        DzTax dzTax = new DzTax();
        dzTax.drive();
        dzTax.display();
        dzTax.showWaterAbility();
        BcTax bcTax = new BcTax();
        bcTax.display();
        bcTax.showWaterAbility();
    }

    /**
     * 模板方式模式
     * 优点：封装性好 复用性好 屏蔽细节 便于维护
     * 缺点：单继承问题
     */
    public static void TestTemplate(){
        //喝咖啡的人
        System.out.println("  `coffee` begin  ");
        Coffee coffee = new Coffee();
        coffee.prepareTemplate();
        System.out.println("  `coffee` end  ");

        //喝茶 加生姜的人
        System.out.println("  `tea` begin  ");
        Tea tea = new Tea();
        tea.prepareTemplate();
        System.out.println("  `tea` end  ");

        //喝茶 不加生姜的人
        System.out.println("  `fresh tea` begin  ");
        FreshTea freshTea = new FreshTea();
        freshTea.prepareTemplate();
        System.out.println("  `fresh tea` end  ");
    }

    /**
     * 适配器模式 作用：通过适配器，客户端可以调用同一个接口，因而对客户端来说是透明的。
     * 复用了现存的类，解决了现存类和复用环境要求不一致的问题 。
     * 将目标类和适配者类解耦，通过引入一个适配器类重用现有的适配者类，而无需修改原有代码（遵循开闭原则）
     */
    public static void TestAdapter(){
        //当仅有二口插口时
        //1.通过组合的方式实现适配器 采用组合方式的适配器称为对象适配器 特点：把被是陪着作为对象组合到适配器类中，以修改目标接口包装被适配器
        TwoPlugIf twoPlugIf = new TwoPlugIf();
        ThreePlugIf threePlugIf =new TwoPlugIfAdapter(twoPlugIf);
        Computer computer = new Computer(threePlugIf);
        computer.charge();
        //2.采用继承的方式实现适配器 采用继承方式的适配器称为类适配器 特点：通过多重继承不兼容接口，实现对目标接口的匹配，单一的为某个类而实现适配
        ThreePlugIf twoPlugIfAdapterExtands = new TwoPlugIfAdapterExtands();
        Computer computer1 = new Computer(twoPlugIfAdapterExtands);
        computer1.charge();
    }

    /**
     * 建造者模式 作用：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
     * 建造者模式将对象的构建过程封装，用户只需要指定建造者即可获得对象，建造者模式把一个复杂对象看成由若干部分组成，使复杂对象的创建变得更加有条理，增加新的建造者无需修改现有代码，很好的满足了开闭原则
     */
    public static void TestBuilder(){
        BuilderDirector builderDirector = new BuilderDirector();
        builderDirector.setBuilder(new SeafoodInstantNoodlesBuilder());
        InstantNoodles instantNoodles = builderDirector.getInstantNoodles();
        System.out.println(instantNoodles.getSeasoningPacket());

        builderDirector.setBuilder(new SpicyInstantNoodlesBuilder());
        instantNoodles = builderDirector.getInstantNoodles();
        System.out.println(instantNoodles.getSeasoningPacket());
    }

    /**
     * 原型模式：用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
     * 使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
     * 实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。
     * 重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，一般的类无法调用，因此，Prototype类需要将clone方法的作用域修改为public类型。
     */
    public static void TestPrototype()   {
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

    }

    /**
     * 工厂模式：1. 工厂方法模式（一类产品） 定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到其子类。
     *          2.抽象工厂模式（相关产品族）  为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类。
     */
    public static void TestFactory(){
        //卖饮料的 只推出奶茶等
        DrinkFactory concreteDrinkFactory = new ConcreteDrinkFactory();
        Drink drink = concreteDrinkFactory.produceDrink();
        drink.withMaterial();

        //西餐厅店 推出甜点 跟 饮料。
        WesternFactory concreteWesternFactory = new ConcreteWesternFactory();
        Drink drink1 = concreteWesternFactory.produceDrink();
        Dessert dessert = concreteWesternFactory.produceDessert();
        drink1.withMaterial();
        dessert.withFlour();
    }

    /**
     *  观察者模式：定义对象间一种一对多的依赖关系，使得当每一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。
     *
     *  观察者与被观察者之间是属于轻度的关联关系，并且是抽象耦合的，这样，对于两者来说都比较容易进行扩展。
     *
     * 观察者模式是一种常用的触发机制，它形成一条触发链，依次对各个观察者的方法进行处理。
     * 但同时，这也算是观察者模式一个缺点，由于是链式触发，当观察者比较多的时候，性能问题是比较令人担忧的。
     * 并且，在链式结构中，比较容易出现循环引用的错误，造成系统假死。
     */
    public static  void TestObserver(){
        //1号房间安装了一个阈值为40度的温度传感器。当温度到达40度则发出警报
        TemperatureSensor temperatureSensor = new TemperatureSensor("1号房间", 40);
        AlarmDevice alarmDevice = new AlarmDevice("监控室警报器");
        temperatureSensor.addObserver(alarmDevice);
        for(int i= 30; i<= 40; i++){
            temperatureSensor.rise(i);
        }

    }

    /**
     * 中介者模式:用一个中介对象来封装一系列的对象的交互，使各对象之间不需要显式地相互作用，降低对象之间的耦合度.
     * 适当地使用中介者模式可以避免同事类之间的过度耦合，使得各同事类之间可以相对独立地使用。
     * 使用中介者模式可以将对象间一对多的关联转变为一对一的关联，使对象间的关系易于理解和维护。
     * 使用中介者模式可以将对象的行为和协作进行抽象，能够比较灵活的处理对象间的相互作用。
     */
    public static  void TestMediator(){
        //假设有一个资源100份，分别由这两个程序，A跟B抢占，当一个方主动抢占，另外一方则占有剩余资源。
        Program programA = new ProgramA();
        Program programB = new ProgramB();
        ConcreteMediator concreteMediator = new ConcreteMediator(programA, programB);
        programA.seizeRecourse(40,concreteMediator);
        System.out.println("当前资源分配：A占"+programA.getRecourse()+",B占"+programB.getRecourse());

        programB.seizeRecourse(50,concreteMediator);
        System.out.println("当前资源分配：A占"+programA.getRecourse()+",B占"+programB.getRecourse());

    }



}
