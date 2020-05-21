package TestEditableTable.Model.Core;

public enum ERROR {
    STRING_NOT_OPTIMAL("NOT_OPTIMAL"),
    STRING_IS_OPTIMAL("IS_OPTIMAL"),
    STRING_UNBOUNDED("UNBOUNDED");

    private String errorString;

    ERROR(String errorString) {
        this.errorString = errorString;
    }

}
