/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sco.kvdb.data;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class KV implements Serializable{
    public String key;
    public String value;

    public KV(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
