package net.school.ttschool;

public class TrainingException extends Throwable {
    private TrainingErrorCode errorCode;

    public TrainingException(TrainingErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}
