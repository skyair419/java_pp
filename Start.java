package game4;

import java.util.Scanner;

public class Start extends Games implements Aaa {  //  Games.java 내의 메소드를 사용하기위해 extends
	
	
	public Scanner scan = new Scanner(System.in); 
	public Member[] m = new Member[10];// 10칸짜리 배열을 생성하는데 각 방에 들어가는 요소들은 Member 타입
	
	// 초기 화면  
	public void run() {
		while (true) {
			System.out.println();
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 종료");
			System.out.print(">>");
			int choiceNum = scan.nextInt();
			scan.nextLine(); // 개행문자 제거
			
			// 1번 선택했을때 실행
			if (choiceNum == 1) {
				if (login()) { // 1번 선택후 로그인 성공시 실행
					System.out.println("로그인 성공");
					System.out.println();
					runGame(); // 게임 실행  Games.java 안에있는 메소드 runGame()를 호출 
				}
				else { // 1번 선택후 로그인 실패시 if문 빠져나가서 다시 while문 첫줄 부터 다시 실행
					System.out.println("로그인 실패");
				}
			}
			// 2번 선택했을때 실행
			else if (choiceNum == 2) {
				join(); // 회원가입 메소드 join() 호출
			}
			// 3번 선택했을때 실행
			else if (choiceNum == 3) {
				exit(); // 종료 메소드 exit() 호출
				break;
			}
			// 1,2,3 이외의 키를 입력할때 실행
			else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
			continue;
		}
	}
	
	// 로그인 메서드 
	public boolean login() {
		System.out.println();
		System.out.println("[로그인]");
		System.out.print("아이디>>");
		String loginId = scan.nextLine();
		
		System.out.print("비밀번호>>");
		String loginPwd = scan.nextLine();
		
		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				if (loginId.equals(m[i].getId()) && loginPwd.equals(m[i].getPwd())) {
					return true;
				}
			}
		}
		return false;
	}
	
	// 회원가입 메서드 
	public void join() {
		System.out.println();
		System.out.println("[회원가입]");
		System.out.print("아이디:");
		String joinId = scan.nextLine();

		System.out.print("비밀번호:");
		String joinPwd = scan.nextLine();

		Member mb = new Member(joinId, joinPwd);// 주소값 저장

		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				m[i] = mb;
				System.out.println("회원가입 성공");
				break;
			}
		}
	}
	
	// 종료 메서드
	public static void exit() {
		System.out.println();
		System.out.println("프로그램 종료");
	}
}