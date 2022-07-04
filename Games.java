package game4;

import java.util.Arrays;
import java.util.Scanner;

public class Games {

	public Scanner scan = new Scanner(System.in);

	// 로그인 후 게임선택 화면
	
	public void runGame() {
		System.out.println("1. 구구단 | 2. 가위바위보 | 3. 로또 | 4. 돌아가기 ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();
		scan.nextLine();
		if (choiceNum == 1) { // 1번 선택
			GooGooDan(); // 구구단 메소드 GooGooDan() 호출
		} else if (choiceNum == 2) { // 2번 선택
			RockSissorPaper(); // 가위바위보 RockSissorPaper() 호출
		} else if (choiceNum == 3) { // 3번 선택
			LL(); // 로또 메소드 LL() 호출
		} else if (choiceNum == 4) { // 4번 선택
			back(); // 돌아가기 메소드 back() 호출
		} else {
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}
	}

	// 구구단 게임 메소드
	public void GooGooDan() {
		int score = 0;

		while (true) {
			int r1 = (int) (Math.random() * 9) + 1;
			int r2 = (int) (Math.random() * 9) + 1;

			System.out.print("QUIZ : " + r1 + " * " + r2 + " = ");
			int anw = scan.nextInt();

			if (anw == (r1 * r2)) {
				System.out.println("정답입니다.");
				score += 10;
				System.out.println("현재 점수: " + score);
				System.out.println();
			} else {
				System.out.println("오답입니다.");
				score -= 10;
				System.out.println("현재 점수: " + score);
				System.out.println();
			}

			if (score == 30) {
				System.out.println("현재 스코어는 " + score + "점 입니다.");
				System.out.println("게임을 종료합니다.");
				System.out.println();
				break;
			}
		}
		runGameRe();
	}

	// 가위바위보 게임 메소드
	public void RockSissorPaper() {

		String arr[] = { "가위", "바위", "보" };

		int match = 0;
		int score = 0;

		while (true) {
			int computer = (int) (Math.random() * 3);
			System.out.println("어떤것을 내시겠습니까?");
			System.out.println("1. 가위 | 2. 바위 | 3. 보 ");
			int user = scan.nextInt();
			System.out.println("유저 : " + arr[user - 1]);
			System.out.println("컴퓨터 : " + arr[computer]);

			if (user == 1) {
				match++;
				if (arr[computer].equals("가위")) {
					System.out.println("결과  : 무승부");
				} else if (arr[computer].equals("바위")) {
					System.out.println("결과 : 졋음");
					score--;
				} else {
					System.out.println("결과 :이김");
					score++;
				}
				System.out.println();
			}

			if (user == 2) {
				match++;
				if (arr[computer].equals("바위")) {
					System.out.println("결과 : 무승부");
				} else if (arr[computer].equals("보")) {
					System.out.println("결과 : 졋음");
					score--;
				} else {
					System.out.println("결과 : 이김");
					score++;
				}
				System.out.println();
			}

			if (user == 3) {
				match++;
				if (arr[computer].equals("보")) {
					System.out.println("결과 : 무승부");
				} else if (arr[computer].equals("결과 : 가위")) {
					System.out.println("결과 : 졋음");
					score--;
				} else {
					System.out.println("결과 : 이김");
					score++;
				}
				System.out.println();
			}

			if (match == 3 && score > 0) {
				System.out.println("게임에서 승리하셨습니다");
				System.out.println();
				break;
			} else if (match == 3 && score < 0) {
				System.out.println("게임에서 패배하셨습니다");
				System.out.println();
				break;
			}
		}
		runGameRe2();
	}

	public void LL() {
		// 랜덤값 1~45번, 중복제거, 오름차순, 비교
		// 6개 숫자 내가 직접 입력

		int[] lo = new int[6];

		Scanner sc = new Scanner(System.in);

		// int a = (int)((Math.random()*45)+1);

		System.out.println("로또 번호 입력");

		for (int i = 0; i < lo.length; i++) {
			lo[i] = sc.nextInt();
			for (int j = 0; j < i; j++) {
				if (lo[i] == lo[j]) {
					System.out.println("중복 숫자입니다. 다시 입력해주세요.");
					i--;

				}
			}

		}
		Arrays.sort(lo);
		System.out.println(Arrays.toString(lo));

		int[] ro = new int[6];

		System.out.println("로또 번호");

		for (int i = 0; i < ro.length; i++) {
			ro[i] = (int) ((Math.random() * 45) + 1);
			for (int j = 0; j < i; j++) {
				if (ro[i] == ro[j]) {
					i--;
				}
			}
		}
		Arrays.sort(ro);
		System.out.println(Arrays.toString(ro));

		int count = 0;
		// 나와 컴퓨터
		for (int i = 0; i < lo.length; i++) {

			for (int j = 0; j < ro.length; j++) {
				if (lo[i] == ro[j]) {
					count++;
				}
			}

		}

		System.out.println("당첨개수 : " + count + "개");
		runGameRe3();
	}

	// 구구단 게임 - 다시시작 선택 메서드
	public void runGameRe() {
		System.out.println("이 게임을 다시 하시겠습니까?");
		System.out.println("1. 예 || 2. 아니오 ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			GooGooDan(); // 1.예 선택시 구구단 메서드 호출
		} else if (choiceNum == 2) {
			System.out.println();
			runGameBack(); // 2.아니오 선택시 메서드 호출
		} else {
			System.out.println();
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}

	}

	// 가위바위보게임 - 다시시작 선택
	public void runGameRe2() {
		System.out.println("이 게임을 다시 하시겠습니까?");
		System.out.println("1. 예 || 2. 아니오 ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			RockSissorPaper(); // 1.예 선택시 가위바위보 메서드 호출
		} else if (choiceNum == 2) {
			System.out.println();
			runGameBack(); // 2.아니오 선택시 메서드 호출
		} else {
			System.out.println();
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}

	}

	// 로또게임 - 다시시작
	public void runGameRe3() {
		System.out.println("이 게임을 다시 하시겠습니까?");
		System.out.println("1. 예 || 2. 아니오 ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			LL(); // 1. 예 선택시 로또 메서드 호출
		} else if (choiceNum == 2) {
			System.out.println();
			runGameBack(); // 2.아니오 선택시 메서드 호출
		} else {
			System.out.println();
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}

	}

	// 다시시작 선택 - 아니오 선택시
	public void runGameBack() {
		System.out.println("1. 다른게임 선택 | 2. 게임 종료 ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			runGame(); // 1. 다른게임선택시 게임선택 화면으로 재호출
		} else if (choiceNum == 2) {
			System.out.println();
			back(); // 2. 게임종료시
		} else {
			System.out.println();
			System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
		}
	}

	//
	public static void back() { // 게임선택화면 , 다시시작화면-아니오-게임종료
		System.out.println("초기 화면으로 돌아갑니다");
	}
}
