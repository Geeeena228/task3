import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(solutions(1,0,-1));
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(6));
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(isValidHexCode("CD5C5C"));
        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int []{2,5,7}));
        System.out.println(isKaprekar(3));
        System.out.println(longestZero("01100001011000"));
        System.out.println(nextPrime(24));
        System.out.println(rightTriangle(3,4,5));

    }
    // найти решение квадратного уравнения
    public static String solutions(int a, int b,int c){
        String s = "2 решения";
        double  D = b*b -4*a*c;
        if (D == 0){
            s = "1 решение";
        }
        else if (D < 0){
            s = "корней нет";
        }
        return s;
    }

    // найти позицию второго вхождения  zip
    public static int findZip(String s){
        if (s.length() == 0){
            return -1;
        }
        char[] symbols = s.toCharArray();
        int count = 0;
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == 'z' && symbols[i+1] == 'i' && symbols[i+2] == 'p'){
                count += 1;
                if (count == 2) {
                    return i;
                }
                //i += 2;
            }
        }
        return -1;
    }
    // является ли целое число совершенным числом или нет. Совершенное число - это число,
    // которое можно записать как сумму его множителей, исключая само число.
    public static boolean checkPerfect(int n){
        int summa = 0;
        for (int i = 1; i<n; i++){
            if(n%i == 0){ // ищем множетели 1 2 3
                summa+=i;
            }
        }
        return summa == n;
    }

    // замена превого и последнего символа
    public static String flipEndChars(String s){
        String beginning = s.substring(0,1); // поиск 1 символа
        String end = s.substring(s.length()-1); // поиск последнего символа

        if(s.length() == 1){ // длина меньше 2
            return "Incompatible";
        } else if (beginning.equals(end)) { // исключение на соответсвие 1 и последнего
            return "Two's a pair";
        }
        s = s.substring(1,s.length()-1); // вырезаем все кроме первого и последнего символа
        s = end+s+beginning;
        return s;
    }

    public static boolean isValidHexCode(String s){
        if(s.length() != 7){
            return false;
        } else if (!(s.startsWith("#"))) {
            return false;
        }
        else if((s.matches("#[A-Fa-f0-9]*[^A-Fa-f0-9]+.*"))){ // любой кроме перечисленных [^A-F[a-f]] регулярные выражения
            return false;
        }
        else return true;
    }





    public static boolean same (int[] arr1, int[] arr2){
        HashSet<Integer> uniqueArr1 = new HashSet<>();//HashSet - т.к. в этой коллекции уникальные элементы
        HashSet<Integer> uniqueArr2 = new HashSet<>();

        for (int index = 0; index < arr1.length; index++)
            uniqueArr1.add(arr1[index]);//перекладываем из массива в коллекцию

        for (int index = 0; index < arr2.length; index++)
            uniqueArr2.add(arr2[index]);

        return uniqueArr1.size() == uniqueArr2.size();
    }


    public static boolean isKaprekar(int n){
        if (n ==0 || n == 1){
            return true;
        }
        if (n / 10 == 0){
            return false;
        }
        String s = Integer.toString(n * n);
        String leftS = s.substring(0,s.length()/2);
        String rightS = s.substring(s.length()/2);
        return (Integer.parseInt(leftS)+Integer.parseInt(rightS)) == n; // сравниваем л+п = n   // parseInt - преобразует строку в число
    }

    public static String longestZero(String line){
        int maxLenght = 0;
        int tempLenght = 0;
        String maxLine = "";
        String tempLine = "";

        // проходим по каждому элементу строки
        for (int index = 0; index < line.length(); index++) {
            if (line.charAt(index) == '0') {
                tempLenght += 1;
                tempLine += line.charAt(index);//сам 0 для вывода
            } else {
                if (tempLenght > maxLenght) {
                    maxLenght = tempLenght;
                    maxLine = tempLine;
                }
                tempLenght = 0;
                tempLine = "";
            }
        }

        return maxLine;
    }

    // простые числа
    public static int nextPrime(int n){
        if (isPrime(n)) {
            return n;
        } else {
            int next = n + 1;
            while (!isPrime(next)) {
                next += 1;
            }
            return next;
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) { // ищем множетели 1 2 3
                return false;
            }
        }
        return true;
    }

    // стороны прямоугольноого треугольника (пифагрова тройка)
    public static boolean rightTriangle(int x, int y, int z) {
        if (x > y && x > z) {
            return x * x == z*z+y*y;
        } else if (y > x && y > z){
            return y * y == x*x+z*z;
        } else {
            return z * z == x*x+y*y;
        }
    }

}

