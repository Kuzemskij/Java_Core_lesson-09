/*
 * LOGOS IT Academy. First Java Core Console Application.
 */

package ua.lviv.lgs.task1;

import java.util.Scanner;

/**
 * @author Maxim Kuzemskij
 * @since Java 1.8
 * @version 1.1  11 Січ 2023
 */

public class Main {

    enum Seasons {
        WINTER, SPRING, SUMMER, AUTUMN;
    }

    enum Month {
        DECEMBER(Seasons.WINTER, 31), JANUARY(Seasons.WINTER, 31), FEBRUARY(Seasons.WINTER, 28),
        MARCH(Seasons.SPRING, 31), APRIL(Seasons.SPRING, 30), MAY(Seasons.SPRING, 31),
        JUNE(Seasons.SUMMER, 30), JULY(Seasons.SUMMER, 31), AUGUST(Seasons.SUMMER, 31),
        SEPTEMBER(Seasons.AUTUMN, 30), OCTOBER(Seasons.AUTUMN, 31), NOVEMBER(Seasons.AUTUMN, 30);

        Seasons s;
        int days;

        Month(Seasons s, int days) {
            this.days = days;
            this.s = s;
        }

        public int getDays() {
            return days;
        }

        public Seasons getS() {
            return s;
        }

        public String DaystoString() {
            return "" + getDays();
        }
    }

    /* displays the application menu on the console */
    public static void menu() {
        System.out.println("Натисніть 1, Щоб перевірити чи є такий місяць;");
        System.out.println("Натисніть 2, Щоб вивести всі місяці за порою року");
        System.out.println("Натисніть 3, Щоб вивести всі місяці які мають таку саму кількість днів");
        System.out.println("Натисніть 4, Щоб вивести на екран всі місяці які мають меншу кількість днів");
        System.out.println("Натисніть 5, Щоб вивести на екран всі місяці які мають більшу кількість днів ніж інші");
        System.out.println("Натисніть 6, Щоб вивести на екран наступну пору року");
        System.out.println("Натисніть 7, Щоб вивести на екран попередню пору року");
        System.out.println("Натисніть 8, Щоб вивести на екран всі місяці які мають парну кількість днів");
        System.out.println("Натисніть 9, Щоб вивести на екран всі місяці які мають непарну кількість днів");
        System.out.println("Натисніть 0, Щоб вивести на екран чи введений з консолі місяць має парну кількість днів");
    }


    public static void main(String[] args) throws WrongInputConsoleParametersException{




        Month [] monthsValues = Month.values();
        Seasons [] s = Seasons.values();
        menu();

        Scanner sc = new Scanner(System.in);
        String input = sc.next();



        /* takes the values from the scanner and runs the corresponding case */
        switch (input) {

            case "1": {
                Scanner month = new Scanner(System.in);
                String monthInput = month.next().toUpperCase();
                boolean flag = false;
                for (Month mon : monthsValues) {
                    if (mon.name().equals(monthInput)) {
                        System.out.println("Month exists!");
                        flag = true;
                    }
                }
                if (!flag) {
                    String message = "Month doesn`t exists";
                    throw new WrongInputConsoleParametersException(message);

                }
                break;
            }

            case "2": {
                System.out.println("Enter Season!");
                Scanner month = new Scanner(System.in);
                String monthInput = month.next().toUpperCase();

                boolean flag = false;

                for (Month t2Month : monthsValues) {
                    if (t2Month.getS().name().equals(monthInput)) {
                        flag = true;
                    }
                }

                if (flag) {
                    Seasons season = Seasons.valueOf(monthInput);
                    for (Month mon : monthsValues) {
                        if (mon.getS().toString().equalsIgnoreCase(monthInput)) {
                            System.out.println(mon);
                        }
                    }
                }
                if (!flag) {
                    String message = "Month doesn`t exists";
                    throw new WrongInputConsoleParametersException(message);
                }
                break;
            }

            case "3": {
                System.out.println("Enter days: ");
                Scanner sc3 = new Scanner(System.in);

                String sc3Input = sc3.next().toUpperCase();
                boolean flag = false;

                for (Month month : monthsValues) {
                    if (month.DaystoString().equals(sc3Input)) {
                        flag = true;
                    }
                }

                if (flag) {
                    for (Month mon : monthsValues) {
                        if (mon.DaystoString().equals(sc3Input)) {
                            System.out.println(mon);
                        }
                    }
                }

                if (!flag) {
                    String message = "Month doesn`t exists";
                    throw new WrongInputConsoleParametersException(message);
                }
                break;
            }

            case "4": {
                for (Month mon : monthsValues) {
                    if (mon.getDays() - 31 < 0) {
                        System.out.println(mon + " " + "Days: " + mon.getDays());

                    }
                }
                break;
            }

            case "5": {
                for (Month mon : monthsValues) {
                    if (mon.getDays() + 31 > 61) {
                        System.out.println(mon + " " + "Days: " + mon.getDays());

                    }
                }
                break;
            }

            case "6": {
                System.out.println("Enter month: ");
                Scanner sc4 = new Scanner(System.in);

                String sc4Input = sc4.next().toUpperCase();
                boolean flag = false;
                for (Month mon : monthsValues) {
                    if (mon.name().equalsIgnoreCase(sc4Input)) {
                        flag = true;
                    }
                }

                if (flag) {
                    Month monValOf = Month.valueOf(sc4Input);
                    int ordinal = monValOf.ordinal();

                    if (ordinal == (monthsValues.length - 1)) {
                        ordinal = 0;
                        System.out.println(monthsValues[ordinal]);
                    } else {
                        System.out.println(monthsValues[ordinal + 1]);
                        break;
                    }
                }

                if (!flag) {
                    String message = "Month doesn`t exists";
                    throw new WrongInputConsoleParametersException(message);
                }
            }

            case "7":  {
                System.out.println("Enter month: ");
                Scanner sc7 = new Scanner(System.in);

                String sc4Input = sc7.next().toUpperCase();
                boolean flag = false;
                for (Month mon : monthsValues) {
                    if (mon.name().equalsIgnoreCase(sc4Input)) {
                        flag = true;

                    }
                }

                if (flag) {
                    Month monValOf = Month.valueOf(sc4Input);
                    int ordinal = monValOf.ordinal();

                    if (ordinal == (monthsValues.length + 1)) {
                        ordinal = 0;
                        System.out.println(monthsValues[ordinal]);
                    } else {
                        System.out.println(monthsValues[ordinal - 1]);

                    }
                }
                if (!flag) {
                    String message = "Month doesn`t exists";
                    throw new WrongInputConsoleParametersException(message);
                }
            }

            case "8": {
                for (Month mon : monthsValues) {
                    if (mon.getDays() % 2 == 0) {
                        System.out.println("Pair: " + mon);
                    }
                }
            }

            case "9": {
                for (Month mon : monthsValues) {
                    if (mon.getDays() % 2 != 0) {
                        System.out.println("Unpair: " + mon);
                    }
                }
            }

            case "0": {
                System.out.println("Enter month: ");
                Scanner sc10 = new Scanner(System.in);

                String sc10Input= sc10.next().toUpperCase();
                boolean flag = false;

                for (Month mon : monthsValues) {
                    if (mon.name().equalsIgnoreCase(sc10Input))
                        flag = true;
                    else
                        System.out.println("Month doesn`t exit");
                }

                if (flag) {
                    Month m = Month.valueOf(sc10Input);

                    if (m.getDays() % 2 == 0) {
                        System.out.println("Pair " + m);
                    } else {
                        System.out.println("Unpair");
                        break;
                    }
                }
            }
        }
    }

}
