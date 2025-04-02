package exception;

public class StringToJsonConversionException extends RuntimeException{
    public StringToJsonConversionException(String msg){
        super(msg);
    }
}
