package org.example.exception;

public class TapdException extends Exception {

    public static final long serialVersionUID = 1L;

    public TapdException(){
        super();
    }

    public TapdException(String msg){
        super(msg);
    }

    public TapdException(Throwable cause) {
        super(cause);
    }

    public TapdException(String msg, Throwable e){
        super(msg,e);
    }

}
