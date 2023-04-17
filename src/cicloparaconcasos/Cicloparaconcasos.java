/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cicloparaconcasos;

import java.util.Scanner;

/**
 *
 * @author disenoydesarrollo
 */
public class Cicloparaconcasos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, edad, estadoCivil, carrera;
        String nombre, sexo;
        String nombreMujerSistemasMasJoven = "";
        int edadMujerSistemasMasJoven = Integer.MAX_VALUE;
        String nombreHombreMasViejoEnSistemas = "";
        int edadHombreMasViejoEnSistemas = 0;
        int sumEdadCasadosProgramacion = 0;
        int countCasadosProgramacion = 0;
        int countMenoresEdadMantenimiento = 0;
        int countMujeresDisenoMayoresEdad = 0;
        int countPersonasDiseno = 0;

        System.out.print("Ingrese la cantidad de registros: ");
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Registro #" + (i + 1));
            System.out.print("Nombre: ");
            nombre = input.next();
            System.out.print("Edad: ");
            edad = input.nextInt();
            System.out.print("Sexo (M/F): ");
            sexo = input.next();
            System.out.print("Estado civil (1=soltero, 2=casado, 3=unión libre, 4=viudo): ");
            estadoCivil = input.nextInt();
            System.out.print("Carrera (1=sistemas, 2=programación, 3=mantenimiento, 4=diseño): ");
            carrera = input.nextInt();

            switch (carrera) {
                case 1:
                    if (sexo.equalsIgnoreCase("F") && edad < edadMujerSistemasMasJoven) {
                        nombreMujerSistemasMasJoven = nombre;
                        edadMujerSistemasMasJoven = edad;
                    }
                    if (sexo.equalsIgnoreCase("M") && edad > edadHombreMasViejoEnSistemas) {
                        nombreHombreMasViejoEnSistemas = nombre;
                        edadHombreMasViejoEnSistemas = edad;
                    }
                    break;
                case 2:
                    if (estadoCivil == 2) {
                        sumEdadCasadosProgramacion += edad;
                        countCasadosProgramacion++;
                    }
                    break;
                case 3:
                    if (edad < 18) {
                        countMenoresEdadMantenimiento++;
                    }
                    break;
                case 4:
                    countPersonasDiseno++;
                    if (sexo.equalsIgnoreCase("F") && edad >= 18) {
                        countMujeresDisenoMayoresEdad++;
                    }
                    break;
                default:
                    break;
            }
        }

        double promedioEdadCasadosProgramacion = countCasadosProgramacion == 0 ? 0 : sumEdadCasadosProgramacion / (double) countCasadosProgramacion;
        double porcentajeMenoresEdadMantenimiento = countPersonasDiseno == 0 ? 0 : countMenoresEdadMantenimiento * 100 / (double) countPersonasDiseno;

        System.out.println("a) Nombre de la mujer de sistemas más joven: " + nombreMujerSistemasMasJoven);
        System.out.println("b) Nombre del hombre más viejo en sistemas: " + nombreHombreMasViejoEnSistemas);
        System.out.println("c) Promedio de edad de las personas de programación que son casadas: " + promedioEdadCasadosProgramacion);
        System.out.println("d) Porcentaje que representan los menores de edad que estudian mantenimiento respecto a todas las personas de mantenimiento: " + porcentajeMenoresEdadMantenimiento + "%");
        System.out.println("e) Cuantas personas de diseño son mujeres mayores de edad: " + countMujeresDisenoMayoresEdad);
    }
    
}
