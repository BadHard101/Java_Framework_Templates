package PR6;

public class FactoryMethodTest {
    interface Product {
        void doSomething();
    }

    static class ConcreteProductA implements Product {
        @Override
        public void doSomething() {
            System.out.println("ConcreteProductA is doing something.");
        }
    }

    static class ConcreteProductB implements Product {
        @Override
        public void doSomething() {
            System.out.println("ConcreteProductB is doing something.");
        }
    }

    interface Creator {
        Product factoryMethod();
    }

    static class ConcreteCreatorA implements Creator {
        @Override
        public Product factoryMethod() {
            return new ConcreteProductA();
        }
    }

    static class ConcreteCreatorB implements Creator {
        @Override
        public Product factoryMethod() {
            return new ConcreteProductB();
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Creator creatorA = new ConcreteCreatorA();
            Product productA = creatorA.factoryMethod();
            productA.doSomething();

            Creator creatorB = new ConcreteCreatorB();
            Product productB = creatorB.factoryMethod();
            productB.doSomething();
        }
    }
}
