package demo.conart.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class ReviewCliView {

    public ReviewCliView(){
        //costruttore
    }

    private static final Logger logger = LoggerFactory.getLogger(ReviewCliView.class);
    Scanner sc = new Scanner(System.in);

    public String scelta(){
        logger.info("1 commenta");
        logger.info("2 aggiungi stelle");
        logger.info("3 invia recensione");
    }

    public String commenta(){

        logger.info("inserisci la tua opinione");


        return sc.nextLine();
    }

    public int commentaStelle(){
        logger.info("inserisci una votazione in stelle");


        return sc.nextInt();
    }

}
