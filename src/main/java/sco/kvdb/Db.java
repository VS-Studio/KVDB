/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sco.kvdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Administrator
 */
public class Db {
    private static String defaultDbFile = "common.db";
    private static File dbFile = null;
            
    public Db() {}

    public Db(String path) {
        defaultDbFile = path;
    }
    
    public static void loadFile(String defPath)
    {
        dbFile = new File(defPath);
    }
    
    public static void loadFile()
    {
        dbFile = new File(defaultDbFile);
    }
    
    public static String readHeader()
    {
        
        return null;
    }
    
    public static String read(int index) throws IOException
    {
        
        
        RandomAccessFile raf = new RandomAccessFile(defaultDbFile, "r");
        
        return null;
    }
    
    public static void write(String key, String value) throws IOException
    {
        FileWriter fw = new FileWriter(dbFile);
        fw.write(key + "\t" + value);
        fw.flush();
    }
    
}
