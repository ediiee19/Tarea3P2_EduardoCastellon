
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea3_p2;

import java.util.Random;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author caste
 */
public class Tarea3_P2 {

    public static void main(String[] args) {
        ArrayList<Integer> lista1 = new ArrayList();
        ArrayList<Integer> lista2 = new ArrayList();
        ArrayList<Integer> lista3 = new ArrayList();

        boolean menuJPane = true;

        while (menuJPane) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog("---Menu--- \n"
                    + "1- Llenar Listas\n"
                    + "2- Ordernar y Mostrar\n"
                    + "3- Interseccion de numeros primos\n"
                    + "4- Realizar Operacion\n"
                    + "5- Encontrar diferencia\n"
                    + "presione [6] para salir"));
            switch (opc) {
                case 6: {
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    menuJPane = false;
                    break;
                }
                case 1: {
                    llenarLista(lista1);
                    llenarLista(lista2);
                    JOptionPane.showMessageDialog(null, "Se han llenado las listas correctamente");
                    break;
                }
                case 2: {
                    JOptionPane.showMessageDialog(null, "Ordenando listas");
                    ordenarLista(lista1);
                    ordenarLista(lista2);
                    JOptionPane.showMessageDialog(null, "imprimiendo a lista...");
                    System.out.println("---Lista-1---");
                    mostrarLista(lista1);
                    System.out.println("---Lista-2---");
                    mostrarLista(lista2);
                    break;
                }

            }
        }
    }

    public static ArrayList llenarLista(ArrayList<Integer> lista) {
        Random r = new Random();

        if (lista.size() > 1) {
            for (int i = 0; i < 100; i++) {
                int numR = r.nextInt();
                lista.set(i, numR);
            }
        } else {
            for (int i = 0; i < 100; i++) {
                int numR = r.nextInt();
                lista.add(numR);
            }
        }
        return lista;
    }

    public static ArrayList ordenarLista(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int posTemp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, posTemp);
                }
            }
        }
        return lista;
    }

    public static ArrayList mostrarLista(ArrayList<Integer> lista) {
        int cont = 0;
        for (Integer num : lista) {
            cont++;
            System.out.println(cont + "- [" + num + "]");
        }
        return lista;
    }
}
