package com.example.pattern.prototype;

import java.io.*;
import java.util.ArrayList;

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
