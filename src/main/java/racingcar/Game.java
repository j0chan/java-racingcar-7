package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // Car 클래스가 생성한 객체를 담는 리스트 'cars'
    private List<Car> cars;

    // 리스트를 인자로 받은 후, 인자들 모두를 Car 객체 리스트로 변환
    public Game(List<String> carList) {
        cars = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            cars.add(new Car(carList.get(i)));
        }
    }

    // 게임을 n번 반복 후, 우승자를 출력하는 메서드
    public void play(int n) {
        for (int i = 0; i < n; i++) {
            round();
        }
        printWinner();
    }

    // 게임 한 라운드 진행
    private void round() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move();
            System.out.print(cars.get(i).getName() + " : ");
            cars.get(i).printScore();
        }
        System.out.println();
    }

    // 최고 점수 산정
    private int getMaxScore() {
        int maxScore = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getScore() > maxScore) {
                maxScore = cars.get(i).getScore(); // 최고 점수 갱신
            }
        }
        return maxScore;
    }

    // 우승자 출력
    private void printWinner() {
        int maxScore = getMaxScore();
        List<String> winners = new ArrayList<>();

        // 우승자를 winner에 입력
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getScore() == maxScore) {
                winners.add(cars.get(i).getName());
            }
        }

        System.out.print("최종 우승자 : ");

        // 우승자가 1명일 때
        if (winners.size() == 1) {
            System.out.println(winners.getFirst());
        }

        // 우승자가 2명 이상일 때
        else {
            for (int i = 0; i < winners.size() - 1; i++) {
                System.out.print(winners.get(i) + ", ");
            }
            // 마지막 우승자 출력 (콤마 없이 출력하기 위해 분리)
            System.out.println(winners.getLast());
        }
    }
}
