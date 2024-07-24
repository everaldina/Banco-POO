package bank.utils;

public class CpfUtils {
    public static boolean isValid(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    public static String format(int cpf) throws IllegalArgumentException {
        if (String.valueOf(cpf).length() != 11){
            throw new IllegalArgumentException("CPF must have 11 digits");
        }
        String cpfString = String.valueOf(cpf);
        return cpfString.substring(0, 3) + "." + cpfString.substring(3, 6) + "." + cpfString.substring(6, 9) + "-" + cpfString.substring(9, 11);
    }

}
