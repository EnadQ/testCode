package enad.test.com.testapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating Dummy Object To Save.
        String name = "Enad";

        ObjectBean objectBean = new ObjectBean();
        objectBean.setObj(name);
        objectBean.setPrivateKey(saveObject(objectBean));

        ObjectBean objFind = new ObjectBean();
        objFind.setObj(findObject(this, objectBean.getPrivateKey()));


    }//end onCreate().

    /* Save Object To File */
    public String saveObject(Object obj) {
        FileOutputStream outputStream;

        try {
            byte[] bytes = (byte[]) obj;
            outputStream = openFileOutput(obj.hashCode() + "", Context.MODE_PRIVATE);
            outputStream.write(bytes);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj.hashCode() + "";
    }//end saveObject().

    /*Find Object Via Key*/
    public Object findObject(Context context, String fileName) {
        try {
            FileInputStream fis = context.openFileInput(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return (Object) sb;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }//end findObject().
}//end MainActivity.
