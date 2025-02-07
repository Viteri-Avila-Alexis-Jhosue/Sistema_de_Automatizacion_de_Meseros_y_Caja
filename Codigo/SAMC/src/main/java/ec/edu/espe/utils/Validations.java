package ec.edu.espe.utils;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ec.edu.espe.exceptions.InvalidIDCardException;

public class Validations {
    public static boolean validateOnlyLetters(String input) {
    try {
        if (!input.matches("[a-zA-ZñÑ]+")) {
            throw new ValidationException("El dato ingresado  debe contener solo letras.");
        }
        return true;
    } catch (ValidationException e) {
        System.out.println(e.getMessage());
        return false;
    }
}

public static boolean validateIDCard(String idCard) {
    try {
        if (idCard.length() != 10 || !idCard.matches("\\d{10}")) {
            throw new ValidationException("El ID debe tener 10 digitos.");
        }
        return true;
    } catch (ValidationException e) {
        System.out.println(e.getMessage());
        return false;
    }
}

public static boolean validateEmail(String correo) {
    try {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        if (!matcher.matches()) {
            throw new ValidationException("Correo electronico no valido.");
        }
        return true;
    } catch (ValidationException e) {
        System.out.println(e.getMessage());
        return false;
    }
}

public static int validateOption(int min, int max, Scanner scanner) {
    while (true) {
        try {
            int option = Integer.parseInt(scanner.nextLine());
            if (option >= min && option <= max) {
                return option;
            } else {
                throw new ValidationException("Opcion fuera de rango. Ingrese una opcion valida entre " + min + " y " + max + ".");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}

public static boolean validatePhone(String telefono) {
    try {
        if (!telefono.matches("\\d{10}")) {
            throw new ValidationException("El telefono debe contener 10 digitos.");
        }
        return true;
    } catch (ValidationException e) {
        System.out.println(e.getMessage());
        return false;
    }
}

public void validateOption(int choice) {
    try {
        if (choice < 1 || choice > 5) {
            throw new ValidationException("Opcion no valida. Ingrese una opcion valida entre 1 y 5.");
        }
    } catch (ValidationException e) {
        System.out.println(e.getMessage());
    }
}

public void validateMenuOption(int choice) {
    try {
        if (choice < 1 || choice >= 19) {
            throw new ValidationException("Opcion no valida. Ingrese una opcion valida entre 1 y 19.");
        }
    } catch (ValidationException e) {
        System.out.println(e.getMessage());
    }
}

public int validateInt() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        try {
            int number = Integer.parseInt(scanner.nextLine());
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Dato invalido. Ingrese un numero entero.");
        }
    }
}

public String validateNonNullString() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        String input = scanner.nextLine();
        try {
            if (input.isEmpty()) {
                throw new ValidationException("El campo no puede estar vacío.");
            }
            return input;
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}

public String validateEmailInput() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        String email = scanner.nextLine();
        try {
            if (!email.contains("@") || !email.contains(".")) {
                throw new ValidationException("Correo invalido. Ingrese un correo electronico valido.");
            }
            return email;
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}

    
    
    public int validateQuantity() {
        Scanner scanner = new Scanner(System.in);
        int cantidad = -1;
        while (cantidad <= 0) {
            try {
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser un numero mayor que 0. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido. Ingrese un numero entero positivo.");
            }
        }
        return cantidad;
    }
    

 public String validatePhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        while (true) {
            phone = scanner.nextLine();
            if (phone.matches("\\d{10}")) {  
                return phone;
            } else {
                System.out.println("Numero de telefono invalido .Ingrese nuevamente");
            }
        }
    }



 public boolean isValidIDCard(String cedula) throws InvalidIDCardException {
        if (cedula == null || cedula.length() != 10) {
            throw new InvalidIDCardException("La cedula debe tener exactamente 10 digitos.");
        }
        if (!cedula.matches("\\d+")) {
            throw new InvalidIDCardException("La cedula solo puede contener dígitos numericos.");
        }

        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int total = 0;
        int digitoVerificador;
        int ultimoDigito = Integer.parseInt(cedula.substring(9, 10));

        for (int i = 0; i < 9; i++) {
            int valor = Integer.parseInt(String.valueOf(cedula.charAt(i))) * coeficientes[i];
            if (valor > 9) {
                valor -= 9; 
            }
            total += valor;
        }

        int modulo = total % 10;
        if (modulo == 0) {
            digitoVerificador = 0;
        } else {
            digitoVerificador = 10 - modulo;
        }

        if (digitoVerificador != ultimoDigito) {
            throw new InvalidIDCardException("El digito verificador de la cedula no coincide.");
        }

        return true;
    }


}

