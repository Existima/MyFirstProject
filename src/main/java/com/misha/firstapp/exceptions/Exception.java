package com.misha.firstapp.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Exception {
    public static void main(String[] args) {
        Exception exception = new Exception();
        try (InputStream is = new FileInputStream("chlen partii")) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//
//        try{
//            exception.srat();
//            exception.buchat();
//            exception.zhrat();
//        } catch(MyAwesomeEdaException e){
//            e.printStackTrace();
//        } catch (MyAwesomeChildException e1){
//            e1.printStackTrace();
//        } catch (MyAwesomeCheckedException e2){
//            e2.printStackTrace();
//        } finally {
//            System.out.println("wasa");
//        }
//        exception.ebat();
//
//    }
//
//    private void zhrat() throws MyAwesomeEdaException {
//        throw new MyAwesomeEdaException();
//    }
//
//    public void buchat() throws MyAwesomeCheckedException {
//        if (true) {
//            throw new MyAwesomeChildException();
//        } else {
//            throw new MyAwesomeCheckedException();
//        }
//    }
//
//    public void ebat() {
//        throw new MyAwesomeUncheckedException();
//    }
//
//    public void srat() throws MyAwesomeChildException{
//        throw new MyAwesomeChildException();
//    }
//}
//

//
//        try {
//            File file = new File("test");
//            Scanner scanner = new Scanner(file); // compile time exception (FileNotFoundException)
//        } catch (java.lang.Exception e){
//
//        }
//    }
//
//
//    // compile time exception (IOException)
//    public void ioExceptionTest() {
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(new File("test.txt")));
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        }
//
//        try {
//            br.readLine();
//        } catch (IOException e) {
//            System.out.println("error");
//        }
//
//    }
//
//    // runtime exceptions (DivisionByZeroException)
//    public int division() {
//        int x = 1;
//        int y = 0;
//        return x / y;
//    }
//
//    // runtime exceptions (NullPointerException)
//    public void nullPointer(){
//        String name = null;
//        name.length();
//    }
//
//    // runtime exceptions (ArrayIndexOutOfBoundsException)
//    public void arrException() {
//        int[] arr = new int[3];
//        System.out.println(arr[3]);
//    }
//}
