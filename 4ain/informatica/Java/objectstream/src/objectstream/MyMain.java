package objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

class Student implements Serializable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        super();
        this.name = name;
    }
   
    public Student() {
        super();
        this.name = "base-value";
    }
   
    public Student(Integer i) {
        super();
        this.name = Integer.toString(i);
    }
}


public class MyMain {
    public static void main(String []args) throws Exception {
        // Invocation of the static method Integer.parseInt()
        Method m = Integer.class.getDeclaredMethod("parseInt", String.class);
        Integer n = (Integer) m.invoke(null, "30");
        System.out.println(n);
        
        // Invocation of the non-static method Student.getName()        
        Method m2 = Student.class.getDeclaredMethod("getName");
        Student st = new Student("Guido");
        String s = (String) m2.invoke(st);
        System.out.println(s);
        
        Method me = Student.class.getDeclaredMethod("getName");
        Student stn = new Student(3);
        String s2 = (String) me.invoke(stn);
        System.out.println(s2);

        Method []m3 = Student.class.getDeclaredMethods();
        System.out.println(Arrays.toString(m3).replace(", ", "\n"));
        
        System.out.println("ciao");
       
        Constructor []c = Student.class.getDeclaredConstructors();
        System.out.println(Arrays.toString(c).replace(", ", "\n"));
       
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("object.os"))) {
            os.writeObject(st);
//            os.close();        
        }
       
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("object.os"))) {
            Serializable sz = (Serializable)is.readObject();
           
            Constructor []c2 = Student.class.getDeclaredConstructors();
            System.out.println(Arrays.toString(c2).replace(", ", "\n"));

        }
       
    }
}