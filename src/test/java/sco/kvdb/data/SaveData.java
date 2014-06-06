/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sco.kvdb.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import sco.kvdb.utils.Common;

/**
 *
 * @author Administrator
 */
public class SaveData extends TestCase{
    
    public void testSaveDatas()
    {
        
        ObjectOutputStream oos = null;
        try {

            int size = 10000000;
            HashMap h = new HashMap();
            for(int i=0;i<size;i++)
            {
                h.put("k" + i,"v" + i);
            }
            
            Datas datas = new Datas(h);
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
            oos.writeObject(datas);
            oos.flush();
            
            
        } catch (IOException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public void testReadDatas()
    {

        try {
           
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"));
            
            Datas da = (Datas)ois.readObject();
            
            if(da != null && da.datas != null)
            {
                HashMap al = (HashMap)da.datas;
                
                Common.pl("al-size: " + al.size());
                
//                for(Object o: al)
//                {
//                    KV kv = (KV)o;
//                    
//                    Common.pl("key: " + kv.key);
//                    Common.pl("value: " + kv.value);
//                }
            }
           
            
        } catch (Exception ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void testSaveKV()
    {
        FileOutputStream fos = null;
        try {
            KV kv = new KV("aaa","bbb");
            
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("kv.dat"));
            
            oos.writeObject(kv);
            
            oos.flush();
            
            Common.pl(kv.toString());
            assertTrue(true);

        } catch (Exception ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void testReadKV()
    {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("kv.dat"));
            
            KV kv = (KV)ois.readObject();
            
            Common.pl("key:" + kv.key);
            Common.pl("value:" + kv.value);
            
        } catch (Exception ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
