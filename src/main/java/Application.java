import java.util.Scanner;

public class Application {
      public static void showMenu(){
          System.out.println("Выберите действие");
          System.out.println("1-Подобрать оптимальный маршрут путешествия");
          Scanner scanner=new Scanner(System.in);
          int answer=scanner.nextInt();
          switch (answer){
              case 1: new ApplicationBestTravel().showQuestion();
          }

      }
    }


