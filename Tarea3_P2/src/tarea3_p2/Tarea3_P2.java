
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea3_p2;

import java.util.Random;
import java.util.ArrayList;
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
                    + "6- Mostrar Lista\n"
                    + "presione [7] para salir"));
            switch (opc) {
                case 7: {
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
                case 3: {
                    JOptionPane.showMessageDialog(null, "Hayando interseccion");
                    break;
                }
                case 4: {
                    ArrayList<Integer> listOp1 = new ArrayList();
                    int opcList1 = Integer.parseInt(JOptionPane.showInputDialog("Elegir primera lista a manipular [1,2,3]"));
                    switch (opcList1) {
                        case 1: {
                            listOp1.addAll(lista1);
                            break;
                        }
                        case 2: {
                            listOp1.addAll(lista2);
                            break;
                        }
                        case 3: {
                            listOp1.addAll(lista3);
                            break;
                        }
                    }
                    ArrayList<Integer> listOp2 = new ArrayList();
                    int opcList2 = Integer.parseInt(JOptionPane.showInputDialog("Elegir segunda lista a manipular [1,2,3]"));
                    switch (opcList2) {
                        case 1: {
                            listOp2.addAll(lista1);
                            break;
                        }
                        case 2: {
                            listOp2.addAll(lista2);
                            break;
                        }
                        case 3: {
                            listOp2.addAll(lista3);
                            break;
                        }
                    }
                    operacionList(listOp1, listOp2);
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                        int opcList = Integer.parseInt(JOptionPane.showInputDialog("Que lista desea ver?"));
                        switch (opcList) {
                            case 1: {
                                System.out.println("---Lista-1---");
                                mostrarLista(lista1);
                                break;
                            }
                            case 2: {
                                System.out.println("---Lista-2---");
                                mostrarLista(lista2);
                                break;
                            }
                            case 3: {
                                System.out.println("---Lista-3---");
                                mostrarLista(lista3);
                                break;
                            }
                            default: JOptionPane.showMessageDialog(null, "No es una lista valida");
                        }                
                    break;
                }
            }
        }
    }

    public static ArrayList llenarLista(ArrayList<Integer> lista) {
        Random r = new Random();
        if (lista.size() > 1) {
            for (int i = 0; i < 100; i++) {
                int numR = 1+ r.nextInt();
                lista.set(i, numR);
            }
        } else {
            for (int i = 0; i < 100; i++) {
                int numR = 1+ r.nextInt();
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

    public static void operacionList(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        boolean menu = true;

        while (menu) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog("--Operaciones--\n"
                    + "1- Sumar\n"
                    + "2- Restar\n"
                    + "3- multiplicar\n"
                    + "4- dividir\n"
                    + "presione [5] para salir"));
            switch (opc) {
                case 5: {
                    menu = false;
                    break;
                }
                case 1: {
                    ArrayList<Integer> listaManipulada = new ArrayList();
                    int t = 100;
                    if (lista1.size() > lista2.size()) {
                        t = lista2.size();
                    }
                    if (lista1.size() < lista2.size()) {
                        t = lista1.size();
                    }
                    for (int i = 0; i < t; i++) {
                        listaManipulada.add(lista1.get(i) + lista2.get(i));
                    }
                    if (t < 100) {
                        int ref = 100 - t;
                        if (lista1.size() > lista2.size()) {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista1.get(i));
                            }
                        } else {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista2.get(i));
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Se han sumado excitosamente");
                    System.out.println("\n---Lista-Sumada---");
                    mostrarLista(listaManipulada);
                    break;
                }
                case 2: {
                    ArrayList<Integer> listaManipulada = new ArrayList();
                    int t = 100;
                    if (lista1.size() > lista2.size()) {
                        t = lista2.size();
                    }
                    if (lista1.size() < lista2.size()) {
                        t = lista1.size();
                    }
                    for (int i = 0; i < t; i++) {
                        listaManipulada.add(lista1.get(i) - lista2.get(i));
                    }
                    if (t < 100) {
                        int ref = 100 - t;
                        if (lista1.size() > lista2.size()) {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista1.get(i));
                            }
                        } else {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista2.get(i));
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Se han restado excitosamente");
                    System.out.println("\n---Lista-de-Diferencia---");
                    mostrarLista(listaManipulada);
                    break;
                }
                case 3: {
                    ArrayList<Integer> listaManipulada = new ArrayList();
                    int t = 100;
                    if (lista1.size() > lista2.size()) {
                        t = lista2.size();
                    }
                    if (lista1.size() < lista2.size()) {
                        t = lista1.size();
                    }
                    for (int i = 0; i < t; i++) {
                        listaManipulada.add(lista1.get(i) * lista2.get(i));
                    }
                    if (t < 100) {
                        int ref = 100 - t;
                        if (lista1.size() > lista2.size()) {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista1.get(i));
                            }
                        } else {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista2.get(i));
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Se han multiplicado excitosamente");
                    System.out.println("\n---Lista-Multiplicaciones---");
                    mostrarLista(listaManipulada);
                    break;
                }
                case 4: {
                    ArrayList<Integer> listaManipulada = new ArrayList();
                    int t = 100;
                    if (lista1.size() > lista2.size()) {
                        t = lista2.size();
                    }
                    if (lista1.size() < lista2.size()) {
                        t = lista1.size();
                    }
                    for (int i = 0; i < t; i++) {
                        listaManipulada.add(lista1.get(i) / lista2.get(i));
                    }
                    if (t < 100) {
                        int ref = 100 - t;
                        if (lista1.size() > lista2.size()) {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista1.get(i));
                            }
                        } else {
                            for (int i = ref; i < 100; i++) {
                                listaManipulada.add(lista2.get(i));
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Se han divido excitosamente");
                    System.out.println("\n---Lista-de-Divisiones---");
                    mostrarLista(listaManipulada);
                    break;
                }
            }
        }
    }
}
