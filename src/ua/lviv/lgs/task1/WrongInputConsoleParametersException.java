package ua.lviv.lgs.task1;

public class WrongInputConsoleParametersException extends Throwable{
    WrongInputConsoleParametersException(String message) {
        super(message);
        System.out.println(message);
    }


}
