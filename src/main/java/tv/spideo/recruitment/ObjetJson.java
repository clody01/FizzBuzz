/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tv.spideo.recruitment;

/**
 *
 * @author Clody
 */
public class ObjetJson {
   
      public String  from  ;
    public String to ;
    public ObjetJson(){
        this.from = "1";
        this.to = "NoN";
    }
    public ObjetJson(String from,String to){
        this.from = "1";
        this.to = "NoN";
        if (!"".equals(from)&&from!=null) {
                  this.from = from;
             }         
         if (!"".equals(to)&&to!=null) {
            this.to = to;
             
        }        
    }
}
