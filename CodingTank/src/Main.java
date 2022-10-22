import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Informe quantas temperaturas deseja converter:");
        int n = input.nextInt();
        System.out.println("Escolha a unidade de origem das temperaturas. " +
                "Digite C para Celsius, K para Kelvin e F para Fahrenheit:");
        String unitInput = input.next();
        System.out.println("Escolha a unidade a ser transformada. " +
                "Digite C para Celsius, K para Kelvin e F para Fahrenheit:");
        String unitOutput = input.next();
        int i;
        double[] arrayTemperature = new double[n];
        for(i = 0; i < n; i++) {
            System.out.println("Digite uma temperatura para ser convetida (use apenas números)");
            arrayTemperature[i] = input.nextDouble();
        }
        double[]arrayNewTemperature = new double[n];
        for(i = 0; i < n; i++){
            arrayNewTemperature[i] = temperatureConverter(arrayTemperature[i], unitInput, unitOutput);
        }

        for (i = 0; i < n; i++) {
            System.out.printf("Temperatura Original: %.2f%s\t\t ", arrayTemperature[i], unitInput);
            System.out.printf("Temperatura Transformada:  %.2f%s\n", arrayNewTemperature[i], unitOutput);
        }

        System.out.printf("\nA média das temperaturas originais foi: %.2f%s\n", average(arrayTemperature), unitInput);
        System.out.printf("A média das temperaturas transformadas foi: %.2f%s\n", average(arrayNewTemperature), unitOutput);
    }
    public static double temperatureConverter(double temperature, String unitInput, String unitOutput)
    {
        if(unitInput.equals(unitOutput))
            return(temperature);
        if(unitInput.equals("C") && unitOutput.equals("F"))
            return (CelsiusToFahrenheit(temperature));
        else if(unitInput.equals("F") && unitOutput.equals("C"))
            return (FahrenheitToCelsius(temperature));
        else if(unitInput.equals("C") && unitOutput.equals("K"))
            return (CelsiusToKelvin(temperature));
        else if(unitInput.equals("K") && unitOutput.equals("C"))
            return (KelvinToCelsius(temperature));
        else if(unitInput.equals("K") && unitOutput.equals("F"))
            return (CelsiusToFahrenheit(KelvinToCelsius(temperature)));
        else if(unitInput.equals("F") && unitOutput.equals("K"))
            return (CelsiusToKelvin(FahrenheitToCelsius(temperature)));
        else
            return(-1);
    }

    public static double CelsiusToKelvin(double temperature){
        return (temperature + 273.15);
    }
    public static double KelvinToCelsius(double temperature){
        return (temperature - 273.15);
    }
    public static double CelsiusToFahrenheit(double temperature){
        return (temperature * 9 / 5 + 32);
    }
    public static double FahrenheitToCelsius(double temperature){
        return ((temperature - 32) * 5 / 9);
    }

    public static double average(double[]array)
    {
        int i;
        double average;
        average = 0;
        for (i = 0; i < array.length; i++)
        {
            average += array[i];
        }
        return average/array.length;
    }
}