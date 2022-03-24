package DesignPatterns;

class MyNumber {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyNumber [value=" + value + "]";
    }
}

class Request {
    private MyNumber v;

    Request(MyNumber v) {
        this.v = v;
    }

    public MyNumber getV() {
        return v;
    }
}

abstract class Handler {
    protected Handler nextHandler;

    Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(Request request) {
        if (nextHandler != null) {
            nextHandler.handle(request);
        }
    }

    public int stringToInt(String s) throws NumberFormatException {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            if ((a >= 48) && (a <= 57)) {
                num = num * 10 + (a - 48);
            } else {
                throw new NumberFormatException();
            }

        }
        return num;
    }

}

class PositiveNumberHandler extends Handler {
    PositiveNumberHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) {
        try {
            int data = stringToInt(request.getV().getValue());
            if (data > 0) {
                System.out.println("Positive Number");
            } else
                super.handle(request);
        } catch (Exception e) {
            super.handle(request);
        }
    }
}

class NegativeNumberHandler extends Handler {
    NegativeNumberHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) {
        try {
            int data = Integer.parseInt(request.getV().getValue());
            if (data < 0) {
                System.out.println("Negative Number");
            } else
                super.handle(request);
        } catch (Exception e) {
            super.handle(request);
        }
    }
}

class ZeroNumberHandler extends Handler {
    ZeroNumberHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) {
        try {
            int data = stringToInt(request.getV().getValue());
            if (data == 0) {
                System.out.println("Zero Number");
            } else
                super.handle(request);
        } catch (Exception e) {
            super.handle(request);
        }
    }
}

class NotAnIntegerHandler extends Handler {
    NotAnIntegerHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) {
        try {
            int data = stringToInt(request.getV().getValue());

        } catch (Exception e) {
            System.out.println(request.getV() + " is not an integer");
        }
    }
}

class Chain {
    Handler firstHandler;

    Chain() {
        buildChain();
    }

    private void buildChain() {
        this.firstHandler = new PositiveNumberHandler(
                new NegativeNumberHandler(new ZeroNumberHandler(new NotAnIntegerHandler(null))));
    }

    public void initiateChain(Request request) {
        firstHandler.handle(request);
    }
}

public class ChainOfresponsibility {
    public static void main(String[] args) {
        MyNumber number = new MyNumber();
        number.setValue("-1");
        Request request = new Request(number);

        Chain myNumberChain = new Chain();
        myNumberChain.initiateChain(request);

        System.out.println(request.getV());
    }
}
