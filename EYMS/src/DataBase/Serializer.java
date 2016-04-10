package DataBase;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
/**
 * This class is a utility class for performing the serialization and
 * deserialization operations provided the required information.
 * @author kewenjing
 *
 */
public class Serializer {
 
    /**
     * deserialize to Object from given file. We use the general Object so as
     * that it can work for any Java Class.
     */
    public static Object deserialize(String fileName) throws IOException,
            ClassNotFoundException {
    	Object obj = new Object();
    	try{
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        obj = ois.readObject();
        ois.close();
    	}
    	catch(IOException | ClassNotFoundException e){
    		System.out.println("you are not yet registered.");
    	}
        return obj;
        
        
    }
 
    /**
     * serialize the given object and save it to given file
     */
    public static void serialize(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj);
        oos.close();
    }
    
    
    
}