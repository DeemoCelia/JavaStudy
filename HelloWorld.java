import javax.swing.text.html.Option;
import java.io.*;
import java.util.*;
import java.net.*;
import java.util.function.Consumer;

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

        /*------------------------------------*/

        HelloWorld hw = new HelloWorld();
        //hw.clientSocketFunc();

        /*------------------------------------*/
        //JDK 8.0

        MathOperation addition = (int a,int b) -> {return a + b;};

        MathOperation subtraction = (a,b)->a-b;

        MathOperation mutiplicaiton = (int a, int b)->{return a*b;};

        MathOperation division = (int a,int b)->a/b;

        GreetingService greetingService1= msg -> System.out.println("hello "+msg);
        GreetingService greetingService2 = (msg) -> {
            System.out.println("hello "+msg);};

        System.out.println("10+5="+hw.operator(10,5,addition));

        greetingService1.sayMessage(",world");

        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("world");
        list.add("lamda");
        list.forEach(
		        System.out::println
        );

        /*------------------------------------*/

        Integer value1 = null;
        Integer value2 = 10;

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println("the first args present: "+a.isPresent());
        System.out.println("the second args present: "+b.isPresent());

        int res1 = a.orElse(1);
        int res2 = b.get();
        System.out.println(res1+res2);

    }

    public void clientSocketFunc()
    {
        String serverName = "localhost";
        int port = 12345;
        try {
            System.out.println("Connect to host: "+serverName+" , Port: "+port);
            Socket client = new Socket(serverName,port);
            System.out.println("Far host addr: " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("hello from"+client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("Server response: "+in.readUTF());
        } catch (IOException e) {
	        throw new RuntimeException(e);
        }
    }

    interface MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService{
        void sayMessage(String msg);
    }

    private int operator(int a,int b,MathOperation mathOperation)
    {
        return mathOperation.operation(a,b);
    }
}
