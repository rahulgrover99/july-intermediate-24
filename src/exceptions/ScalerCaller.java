package exceptions;

import java.io.IOException;

public class ScalerCaller {

    public static void main(String[] args)  {

        ScalerApi scalerApi = new ScalerApi();

        try {
            scalerApi.callApi(10);
        } catch (OutOfQuotaException | RuntimeException e) {
            System.out.println("we are out of quota now.");
        } catch (Throwable e) { // not a recommended practice in prod.
            System.out.println("something random happened");
            throw new RuntimeException();
        } finally {
            System.out.println("Finally we are here.");
        }


        System.out.println("okay bye");

    }

}
