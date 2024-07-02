package tricky_questions;
 
public class B1 {
 
  B1 b = new B1();
 
 public int show(){
      return (true ? null : 0);
 }
 
 public static void main(String[] args)  {
 
        B1 b = new B1();
        b.show();
    }
}