import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args)
    {
        System.out.println("hello,world!");

        System.out.println("hello,github!");

        System.out.println("hello,cursor");

        /*------------------------------------*/

        MyClass mc = new MyClass();
		mc.func();

		/*------------------------------------*/

		Enumeration<String> days;
        Vector<String> dayNames = new Vector<>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        days = dayNames.elements();

        while(days.hasMoreElements())
        {
            System.out.println(days.nextElement());
        }

        /*------------------------------------*/

        BitSet bits = new BitSet(10);
        BitSet bits_ = new BitSet(20);
        bits.set(5);
        bits.set(7);
        bits_.set(13);
        bits_.set(16);
        bits.or(bits_);
        System.out.println(bits);

        /*------------------------------------*/

        Vector<String> vec = new Vector<>();
        vec.add("first");
        vec.add(0,"before first");
        System.out.println(vec.capacity());
        System.out.println(vec.size());
        String str = vec.elementAt(1);
        System.out.println(str);

        /*------------------------------------*/

        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.push("3");
        System.out.println("stack: " + stack);
        System.out.println("stack peek: " + stack.peek());
        System.out.println("stack search: " + stack.search("2"));

        /*------------------------------------*/

        //Dictionary已过时

        /*------------------------------------*/

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1,"1");
        hashtable.put(2,"2");
        hashtable.put(3,"3");
        System.out.println("hashtable[2]: " + hashtable.get(2));

        /*------------------------------------*/

        Properties props = new Properties();
        props.put("username","tom");
        props.put("password","123456");
        try
        {
            props.store(new FileOutputStream("config.properties"),null);
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

        props.clear();

        try {
            props.load(new FileInputStream("config.properties"));
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }

	    for (Object o : props.values()) {
		    str = (String) o;
		    System.out.println("configs: " + str);
	    }

    }
}
