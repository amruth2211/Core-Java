package Week4;

class StringBufferExample {
    public static void main(String args[]) {
        StringBuffer sb = new StringBuffer("Hello ");
        StringBuffer sb2 = new StringBuffer("Hello ");
        System.out.println(sb.hashCode());
        System.out.println(sb2.hashCode());

        // sb.append("Java");//now original string is changed
        // System.out.println(sb);//prints Hello Java
    }
}
