package SimplexFunktioniert.Core;

public enum Error
{
    STRING_NOT_OPTIMAL("NOT_OPTIMAL"),
    STRING_IS_OPTIMAL("IS_OPTIMAL"),
    STRING_UNBOUNDED("UNBOUNDED");


    private String errorString;

    Error(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
