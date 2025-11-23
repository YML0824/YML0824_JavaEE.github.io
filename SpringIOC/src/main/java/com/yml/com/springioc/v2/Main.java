package com.yml.com.springioc.v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: YY_ang
 * Date: 2025-10-16
 * Time: 15:12
 */
public class Main {
    public static void main(String[] args) {
        Tire tire = new Tire(17,"red");
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.run();
    }
}
