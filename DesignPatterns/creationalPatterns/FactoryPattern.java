package DesignPatterns.creationalPatterns;

interface MyWrapper {
    void printType();
}

class MyInteger implements MyWrapper {
    @Override
    public void printType() {
        System.out.println("The value is MyInteger type");
    }
}

class MyDouble implements MyWrapper {
    @Override
    public void printType() {
        System.out.println("The value is MyDouble type");
    }
}

class MyCharacter implements MyWrapper {
    @Override
    public void printType() {
        System.out.println("The value is MyCharacter type");
    }
}

class MyBoolean implements MyWrapper {
    @Override
    public void printType() {
        System.out.println("The value is MyBoolean type");
    }
}

class MyWrapperFactory {
    public MyWrapper getMyWrapperInstance(String channel) {
        if (channel == null || channel.isEmpty())
            return null;
        if (channel.matches("\\d+"))
            return new MyInteger();
        else if (channel.matches("[0-9]{1,13}(\\.[0-9]*)?"))
            return new MyDouble();
        else if (channel.matches("[a-z][A-Z]"))
            return new MyCharacter();
        else if (channel.matches("true") || channel.matches("false"))
            return new MyBoolean();
        else
            throw new IllegalArgumentException("Unknown channel " + channel);
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        MyWrapperFactory factory = new MyWrapperFactory();
        MyWrapper wrapper = factory.getMyWrapperInstance("5.4");
        wrapper.printType();
    }
}