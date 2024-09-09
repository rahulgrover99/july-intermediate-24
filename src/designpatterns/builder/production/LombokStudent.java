package designpatterns.builder.production;


import lombok.Builder;

@Builder
public class LombokStudent {

    private final String name;
    private final int age;
    private final String universityName;
    private final double psp;
    private final String phoneNo;


}
