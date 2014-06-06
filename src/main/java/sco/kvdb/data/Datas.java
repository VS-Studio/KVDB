/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sco.kvdb.data;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Datas implements Serializable{
    
    public Map<Object,Object> datas;

    public Datas(Map<Object, Object> datas) {
        this.datas = datas;
    }
    
}
