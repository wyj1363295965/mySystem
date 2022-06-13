package com.tik.mysystem.algorithm;

/**
 * 简单工厂模式
 */
public class SimpleFactoryPattern {


    public void test() {
        Animal dog = new Dog();
    }

    class Animal {
        void eat() {
        }
    }

    class Dog extends Animal {
        @Override
        void eat() {
            //狗的吃方法
        }
    }

    class Cat extends Animal {
        @Override
        void eat() {
            //猫的吃方法
        }
    }
}
