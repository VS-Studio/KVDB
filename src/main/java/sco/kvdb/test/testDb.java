/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sco.kvdb.test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sco.kvdb.Db;
import sco.kvdb.utils.Common;



/**
 *
 * @author Administrator
 */
public class testDb {
    
    public static void main(String[] args)
    {
        testWrite();
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
    
}
