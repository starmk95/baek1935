import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Double> operand = new Stack<>(); // 피연산자 스택
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 피연산자의 개수
        Double[] operandArray = new Double[n]; // 피연산자들을 저장하는 배열
        String cmd = sc.next(); // 수식 받아오기
        for (int i=0;i<n;i++) {
            operandArray[i] = sc.nextDouble(); // 입력받은 정수 피연산자에 할당
        }
        // 알파벳으로 입력받는 피연산자를 해당 알파벳에 할당되는 정수로 접근하기 위한 방법
        // -> ASCII 코드 사용
        // 각 알파벳은 A = 65, ..., Z = 90의 아스키 코드 값을 갖는다.
        // Character형을 int형으로 형변환 시키면 해당 아스키 코드 값을 반환한다.
        // ex) int('A') = 65
        // A는 첫번째로 입력받은 정수를 의미하므로 정수 저장 배열의 0번째 원소에 접근하면 된다.
        // 이를 수행하기 위한 방법 : operandArray[(int)입력된알파벳 - (int)'A']]
        // ex) C에 할당된 정수(배열의 인덱스 2번 원소) 접근하기
        // -> operandArray[(int)'C' - (int)'A']] 이는 곧 operandArray[2]와 같은 의미를 갖는다.

        for (int i=0;i<cmd.length();i++) {
            double operand_1, operand_2 = 0;
            switch (cmd.charAt(i)) { // 연산자가 들어올 경우 피연산자 스택의 상위 2개 항목을 연산하고 다시 push해줌
                case '+' :
                    operand_2 = operand.pop();
                    operand_1 = operand.pop();
                    operand.push(operand_1 + operand_2);
                    break;
                case '-' :
                    operand_2 = operand.pop();
                    operand_1 = operand.pop();
                    operand.push(operand_1 - operand_2);
                    break;
                case '*' :
                    operand_2 = operand.pop();
                    operand_1 = operand.pop();
                    operand.push(operand_1 * operand_2);
                    break;
                case '/' :
                    operand_2 = operand.pop();
                    operand_1 = operand.pop();
                    operand.push(operand_1 / operand_2);
                    break;
                default: // 피연산자라면
                    operand.push(operandArray[(int)cmd.charAt(i) - (int)'A']);// 피연산자의 정수값 stack에 넣어주기
                    break;
            }
        }
        System.out.printf("%.2f", operand.pop()); // 모든 연산을 처리한 후에 최종 결과는 피연산자 스택에 한개의 항목으로 남게 됨
    }
}
