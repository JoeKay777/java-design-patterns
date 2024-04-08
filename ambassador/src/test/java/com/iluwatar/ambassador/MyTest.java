package com.iluwatar.ambassador;

/**
 * @Description: TODO
 * @author: qkh
 * @date: 2024年04月08日 15:26
 */
public class MyTest {

    public interface Car {
        void accept(Visitor visitor);
    }

    public class BYD implements Car {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public class BWM implements Car {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public interface Visitor {
        void visit(BYD model);

        void visit(BWM model);
    }

    public class BydVisitor implements Visitor {

        @Override
        public void visit(BYD model) {
            System.out.println("欢迎来到比亚迪");

        }

        @Override
        public void visit(BWM model) {
            System.out.println("宝马不欢迎你");
        }
    }

    public class BwmVisitor implements Visitor {

        @Override
        public void visit(BYD model) {
            System.out.println("比亚迪不欢迎你");

        }

        @Override
        public void visit(BWM model) {
            System.out.println("欢迎来到宝马");
        }
    }
    public class VipVisitor implements Visitor {

        @Override
        public void visit(BYD model) {
            System.out.println("你是VIP,欢迎来到比亚迪");

        }

        @Override
        public void visit(BWM model) {
            System.out.println("你是VIP,欢迎来到宝马");
        }
    }

    public void test() {
        Car bydCar = new BYD();
        Car bwmCar = new BWM();
        Visitor bydVisitor = new BydVisitor();
        Visitor bwmVisitor = new BwmVisitor();
        Visitor vip = new VipVisitor();
        bydCar.accept(bydVisitor);
        bydCar.accept(bwmVisitor);
        bwmCar.accept(bydVisitor);
        bwmCar.accept(bwmVisitor);
        bydCar.accept(vip);
        bwmCar.accept(vip);

    }

    public static void main(String[] args) {
        new MyTest().test();
    }
}
