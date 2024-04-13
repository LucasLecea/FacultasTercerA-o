package com.cooweb;

import java.util.Scanner;

public class Ahorcado {
	private static final int MAX_INTENTOS = 7;

    private String palabraSecreta;
    private char[] progresoPalabra;
    private int intentosRestantes;
    private int partesAhorcado;
    private Scanner scanner;

    public Ahorcado() {
        scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        ingresarPalabra();
        progresoPalabra = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraSecreta.length(); i++) {
            progresoPalabra[i] = '_';
        }
        intentosRestantes = MAX_INTENTOS;
        partesAhorcado = 0;

        System.out.println("Bienvenido al juego del Ahorcado!");
        System.out.println("La palabra tiene " + palabraSecreta.length() + " letras.");

        while (intentosRestantes > 0 && !esGanador()) {
            mostrarProgreso();
            solicitarLetra();
        }

        if (esGanador()) {
            mostrarProgreso();
            System.out.println("¡Felicidades! Has adivinado la palabra correctamente: " + palabraSecreta);
        } else {
            dibujarAhorcado();
            System.out.println("Oh no! Te has quedado sin intentos. La palabra era: " + palabraSecreta);
        }
        scanner.close();
    }

    private void ingresarPalabra() {
        System.out.print("Ingresa la palabra con la que quieres jugar: ");
        palabraSecreta = scanner.nextLine().toUpperCase();
    }

    private void mostrarProgreso() {
        System.out.println("\nAhorcado:");
        dibujarAhorcado();
        System.out.print("\nProgreso: ");
        for (char c : progresoPalabra) {
            System.out.print(c + " ");
        }
        System.out.println("\nIntentos restantes: " + intentosRestantes);
    }

    private void solicitarLetra() {
        System.out.print("Ingresa una letra: ");
        String input = scanner.next().toUpperCase();
        char letra = input.charAt(0);

        if (!esLetraValida(letra)) {
            System.out.println("Por favor ingresa una letra válida.");
            return;
        }

        if (adivinarLetra(letra)) {
            System.out.println("¡Correcto!");
        } else {
            intentosRestantes--;
            partesAhorcado++;
            System.out.println("Incorrecto. Te quedan " + intentosRestantes + " intentos.");
        }
    }

    private boolean esLetraValida(char letra) {
        return Character.isLetter(letra);
    }

    private boolean adivinarLetra(char letra) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progresoPalabra[i] = letra;
                acierto = true;
            }
        }
        return acierto;
    }

    private boolean esGanador() {
        return palabraSecreta.equals(String.valueOf(progresoPalabra));
    }

    private void dibujarAhorcado() {
        switch (partesAhorcado) {
            case 1:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 2:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |    |");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 3:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   \\|");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 4:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   \\|/");
                System.out.println(" |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 5:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   \\|/");
                System.out.println(" |    |");
                System.out.println(" |");
                System.out.println("_|_");
                break;
            case 6:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   \\|/");
                System.out.println(" |    |");
                System.out.println(" |   / ");
                System.out.println("_|_");
                break;
            case 7:
                System.out.println("  ____");
                System.out.println(" |    |");
                System.out.println(" |    O");
                System.out.println(" |   \\|/");
                System.out.println(" |    |");
                System.out.println(" |   / \\");
                System.out.println("_|_");
                break;
            default:
                System.out.println("\n\n\n\n\n\n\n");
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ahorcado ahorcado = new Ahorcado();
        ahorcado.iniciarJuego();
	}

}
