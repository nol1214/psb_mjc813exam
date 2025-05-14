public class Chapter05 {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 8, 2};
        int max = 0;

        for(int i=0; i < array.length; i++) {
            if(array[i] >= max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }
}

/*public class Chapter05 {
    public static void main(String[] args) {
        int[][] array = {
            {95, 86},
            {83, 92, 96},
            {78, 83, 93, 87, 88}
        };
        int sum = 0;
        int cnt = 0;
        double avg = 0.0;
        for(int i=0; i < array.length; i++) {
            for(int j=0; j < array[i].length; j++) {
                sum += array[i][j];
                cnt++;
            }
        }
        avg = (double)sum / cnt;

        System.out.println(sum);
        System.out.println(avg);
    }
}
 */

/*public class Chapter05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] scores = new int[100];
        int a;
        int max = 0;
        int sum = 0;
        int cnt = 0;
        double avg = 0.0;
        String input;

        while(true) {
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.print("선택> ");
            input = scan.next();

            if(input.equals("1")) {
                System.out.print("학생수> ");
                a = scan.nextInt();
                scores = new int[a];
            } else if(input.equals("2")) {
                for(int i=0; i<scores.length; i++) {
                    System.out.print("scores[" + i + "]> ");
                    scores[i] = scan.nextInt();
                }
                } else if(input.equals("3")) {
                    for(int i=0; i<scores.length; i++) {
                        System.out.println("scores[" + i + "]> " + scores[i]);
                    }
                    } else if(input.equals("4")) {
                        for(int i=0; i<scores.length; i++) {
                            if(scores[i] >= max) {
                                max = scores[i];
                            }
                            cnt++;
                            sum += scores[i];
                        }
                        avg = (double)sum / cnt;
                        System.out.println("최고 점수 : " + max);
                        System.out.println("평균 점수 : " + avg);
                        } else {
                            if(input.equals("5")) {
                                System.out.println("프로그램 종료");
                                break;
                            }
                            }
                            }
                            }
}
 */

/*public class Chapter05 {
}
 */