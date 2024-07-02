package tricky_questions;
 
public class A3 {
 int GetValue()
 {
        return (true ? null : 0);
 }
 
 public static void main(String[] args)  {
      A3 obj = new A3();
      obj.GetValue();
 }
}