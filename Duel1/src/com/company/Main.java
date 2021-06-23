package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static double BotTurn(int i){
        if (i>=8) return (5+Math.pow(-1, i)*(i-7));
        else return 5+Math.pow(-1, i-1)*(i-1);
    }

    public static void main(String[] args) {
        Player you = new Player();
        Player AI = new Player();
        System.out.println("Добро пожаловать в игру Дуэль!");
        System.out.println("v.Pre-Alpha 0.1.");
        System.out.println("Нажмите 1, чтобы начать игру.");
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        double bot;
        int card;
        boolean[] botunused = new boolean[12];
        boolean[] playerunused = new boolean[12];
        boolean PlayerTurn = true;
        System.out.println("Вы ходите первым!");
        for(int i=1; i<=12; i++)
        {
            System.out.println("Раунд "+ i +"!");
            botunused = AI.getUnused_cards();
            playerunused = you.getUnused_cards();
            System.out.println("Выберите карту:");
            card = sc.nextInt();
            bot = BotTurn(i);
            System.out.println("Ход бота "+ bot);
            if(PlayerTurn)
            {
                System.out.println("Вы атакуете!");
                if (card>bot) {
                    AI.setPenalty_points(AI.getPenalty_points()+card-bot);
                    System.out.println("Игрок номер 2 получает штрафные очки в размере " + AI.getPenalty_points());
                }
                else System.out.println("Никто не получает штрафных очков!");
                PlayerTurn = false;
            }
            else {
                System.out.println("Вы защищаетесь!");
                if (bot>card) {
                    you.setPenalty_points(you.getPenalty_points()+bot-card);
                    System.out.println("Вы получаете штрафные очки в размере " + you.getPenalty_points());
            }
                else System.out.println("Никто не получает штрафных очков!");
                PlayerTurn = true;
            }
            you.setUnused_cards(playerunused);
            AI.setUnused_cards(botunused);
            System.out.println("Смена хода!");

        }
        System.out.println("Ваши штрафные очки = " +you.getPenalty_points());
        System.out.println("Штрафные очки игрока номер 2 = " +AI.getPenalty_points());
        if (you.getPenalty_points()<AI.getPenalty_points()) System.out.println("Вы победили!");
        else if (you.getPenalty_points()==AI.getPenalty_points()) System.out.println("Ничья!");
        else System.out.println("Вы проиграли.");
        System.out.println("Благодарим за игру!");
    }
}
