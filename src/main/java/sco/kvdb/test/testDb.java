/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sco.kvdb.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sco.kvdb.Db;
import sco.kvdb.data.Datas;
import sco.kvdb.utils.Common;



/**
 *
 * @author Administrator
 */
public class testDb {
    
    public static void main(String[] args)
    {
        new testDb().testSaveDatas();
    }
    
    public static void testWrite() 
    {
        try {
            Db db = new Db("mydb.db");
            db.loadFile();
            db.write("ssss","gwegwg");
            String ret = db.read(-1);
            
            Common.pl(ret);
        } catch (IOException ex) {
            Logger.getLogger(testDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
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
            ex.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
