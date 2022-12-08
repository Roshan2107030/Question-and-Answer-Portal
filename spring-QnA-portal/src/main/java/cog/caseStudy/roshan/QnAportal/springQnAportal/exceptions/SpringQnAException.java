package cog.caseStudy.roshan.QnAportal.springQnAportal.exceptions;

public class SpringQnAException extends RuntimeException {
    public SpringQnAException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringQnAException(String exMessage) {
        super(exMessage);
    }
}
