package demo.conart;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger(MainApp.class.getName());

        logger.info("CLI: 1 or GUI: 2");
        String input = sc.nextLine();

        switch (input) {

            case "1":
                logger.info("Hello World!");
                break;

            case "2":
                logger.info("Goodbye World!");
                break;

            default:
                logger.info("Invalid input");

        }
        /*

        impostare inizialmente il layer di persistenza db o csv
        impostare il tipo di visualizzazione gui o cli

        farlo in modo da separare le responsabilità e non mischiare tutto
        servono i ruoli

        implementiamo pattern observer

        definiamo le classi da usare
        studente ->   registrazione ai corsi -> systema corso

        boundary: form registrazione, catalogo corsi. operazioni da fare e le informazioni non GUI
        controller: registrazioneAiCorsi,
        entity: studente, corso

















        user cosa fa: login, registrazione, partecipa spettacolo, scrive recensione, cerca spettacolo

        artista cosa fa: login, registrazione, riceve richieste, crea spettacolo, vede recensioni

        sponsor cosa fa: login, registrazione, crea richieste, notifica artisti, vede recensioni

        quali sono entity, quali boundary, quali controller

        caso d'uso login:
        attori coinvolti tutti e tre ognuno ha la sua boundary ma condividono lo stesso controller
        esistono entity di tipo artist, user, sponsor e anche attori artist, user, sponsor

        come si traducono in model view controller e in java?
        le entity NON DEVONO MAI conoscere il control oppure le boundary













         dal momento che la boundary deve delegare la logica applicativa al controller c'è bisogno di
         un attributo privato di tipo controller all'interno della boundary che usa oppure associa
         tale controller. la relazione è pertanto di utilizzo oppure di associazione


         ricapitolando: i bce sono un tipo di pattern che serve per identificare le classi e le loro responsa
         bilità.
         boundary: mediano l'interazione tra sistema e ambiente, rappresentano elementi al confine del sistema
         e regolano le interazioni con gli attori

         control: durante un caso d'uso coordinano il comportamento del sistema, sono indipendenti
         dall'attivazione dell'interazione, scaturiscono dall'analisi dominio del problema

         entity: le astrazioni chiave del sistema, indipendenti dall'ambiente di esecuzione
         analisi dominio problema come control



         */


    }
}