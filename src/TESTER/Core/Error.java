package TESTER.Core;

public enum Error
{
    STRING_NOT_OPTIMAL("NOT_OPTIMAL"),
    STRING_IS_OPTIMAL("IS_OPTIMAL");


    private String errorString;

    Error(String errorString) {
        this.errorString = errorString;
    }

}
