package game4;

import java.util.Arrays;
import java.util.Scanner;

public class Games {

	public Scanner scan = new Scanner(System.in);

	// �α��� �� ���Ӽ��� ȭ��
	
	public void runGame() {
		System.out.println("1. ������ | 2. ���������� | 3. �ζ� | 4. ���ư��� ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();
		scan.nextLine();
		if (choiceNum == 1) { // 1�� ����
			GooGooDan(); // ������ �޼ҵ� GooGooDan() ȣ��
		} else if (choiceNum == 2) { // 2�� ����
			RockSissorPaper(); // ���������� RockSissorPaper() ȣ��
		} else if (choiceNum == 3) { // 3�� ����
			LL(); // �ζ� �޼ҵ� LL() ȣ��
		} else if (choiceNum == 4) { // 4�� ����
			back(); // ���ư��� �޼ҵ� back() ȣ��
		} else {
			System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
		}
	}

	// ������ ���� �޼ҵ�
	public void GooGooDan() {
		int score = 0;

		while (true) {
			int r1 = (int) (Math.random() * 9) + 1;
			int r2 = (int) (Math.random() * 9) + 1;

			System.out.print("QUIZ : " + r1 + " * " + r2 + " = ");
			int anw = scan.nextInt();

			if (anw == (r1 * r2)) {
				System.out.println("�����Դϴ�.");
				score += 10;
				System.out.println("���� ����: " + score);
				System.out.println();
			} else {
				System.out.println("�����Դϴ�.");
				score -= 10;
				System.out.println("���� ����: " + score);
				System.out.println();
			}

			if (score == 30) {
				System.out.println("���� ���ھ�� " + score + "�� �Դϴ�.");
				System.out.println("������ �����մϴ�.");
				System.out.println();
				break;
			}
		}
		runGameRe();
	}

	// ���������� ���� �޼ҵ�
	public void RockSissorPaper() {

		String arr[] = { "����", "����", "��" };

		int match = 0;
		int score = 0;

		while (true) {
			int computer = (int) (Math.random() * 3);
			System.out.println("����� ���ðڽ��ϱ�?");
			System.out.println("1. ���� | 2. ���� | 3. �� ");
			int user = scan.nextInt();
			System.out.println("���� : " + arr[user - 1]);
			System.out.println("��ǻ�� : " + arr[computer]);

			if (user == 1) {
				match++;
				if (arr[computer].equals("����")) {
					System.out.println("���  : ���º�");
				} else if (arr[computer].equals("����")) {
					System.out.println("��� : ����");
					score--;
				} else {
					System.out.println("��� :�̱�");
					score++;
				}
				System.out.println();
			}

			if (user == 2) {
				match++;
				if (arr[computer].equals("����")) {
					System.out.println("��� : ���º�");
				} else if (arr[computer].equals("��")) {
					System.out.println("��� : ����");
					score--;
				} else {
					System.out.println("��� : �̱�");
					score++;
				}
				System.out.println();
			}

			if (user == 3) {
				match++;
				if (arr[computer].equals("��")) {
					System.out.println("��� : ���º�");
				} else if (arr[computer].equals("��� : ����")) {
					System.out.println("��� : ����");
					score--;
				} else {
					System.out.println("��� : �̱�");
					score++;
				}
				System.out.println();
			}

			if (match == 3 && score > 0) {
				System.out.println("���ӿ��� �¸��ϼ̽��ϴ�");
				System.out.println();
				break;
			} else if (match == 3 && score < 0) {
				System.out.println("���ӿ��� �й��ϼ̽��ϴ�");
				System.out.println();
				break;
			}
		}
		runGameRe2();
	}

	public void LL() {
		// ������ 1~45��, �ߺ�����, ��������, ��
		// 6�� ���� ���� ���� �Է�

		int[] lo = new int[6];

		Scanner sc = new Scanner(System.in);

		// int a = (int)((Math.random()*45)+1);

		System.out.println("�ζ� ��ȣ �Է�");

		for (int i = 0; i < lo.length; i++) {
			lo[i] = sc.nextInt();
			for (int j = 0; j < i; j++) {
				if (lo[i] == lo[j]) {
					System.out.println("�ߺ� �����Դϴ�. �ٽ� �Է����ּ���.");
					i--;

				}
			}

		}
		Arrays.sort(lo);
		System.out.println(Arrays.toString(lo));

		int[] ro = new int[6];

		System.out.println("�ζ� ��ȣ");

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
		// ���� ��ǻ��
		for (int i = 0; i < lo.length; i++) {

			for (int j = 0; j < ro.length; j++) {
				if (lo[i] == ro[j]) {
					count++;
				}
			}

		}

		System.out.println("��÷���� : " + count + "��");
		runGameRe3();
	}

	// ������ ���� - �ٽý��� ���� �޼���
	public void runGameRe() {
		System.out.println("�� ������ �ٽ� �Ͻðڽ��ϱ�?");
		System.out.println("1. �� || 2. �ƴϿ� ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			GooGooDan(); // 1.�� ���ý� ������ �޼��� ȣ��
		} else if (choiceNum == 2) {
			System.out.println();
			runGameBack(); // 2.�ƴϿ� ���ý� �޼��� ȣ��
		} else {
			System.out.println();
			System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
		}

	}

	// �������������� - �ٽý��� ����
	public void runGameRe2() {
		System.out.println("�� ������ �ٽ� �Ͻðڽ��ϱ�?");
		System.out.println("1. �� || 2. �ƴϿ� ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			RockSissorPaper(); // 1.�� ���ý� ���������� �޼��� ȣ��
		} else if (choiceNum == 2) {
			System.out.println();
			runGameBack(); // 2.�ƴϿ� ���ý� �޼��� ȣ��
		} else {
			System.out.println();
			System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
		}

	}

	// �ζǰ��� - �ٽý���
	public void runGameRe3() {
		System.out.println("�� ������ �ٽ� �Ͻðڽ��ϱ�?");
		System.out.println("1. �� || 2. �ƴϿ� ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			LL(); // 1. �� ���ý� �ζ� �޼��� ȣ��
		} else if (choiceNum == 2) {
			System.out.println();
			runGameBack(); // 2.�ƴϿ� ���ý� �޼��� ȣ��
		} else {
			System.out.println();
			System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
		}

	}

	// �ٽý��� ���� - �ƴϿ� ���ý�
	public void runGameBack() {
		System.out.println("1. �ٸ����� ���� | 2. ���� ���� ");
		System.out.print(">>");
		int choiceNum = scan.nextInt();

		if (choiceNum == 1) {
			System.out.println();
			runGame(); // 1. �ٸ����Ӽ��ý� ���Ӽ��� ȭ������ ��ȣ��
		} else if (choiceNum == 2) {
			System.out.println();
			back(); // 2. ���������
		} else {
			System.out.println();
			System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
		}
	}

	//
	public static void back() { // ���Ӽ���ȭ�� , �ٽý���ȭ��-�ƴϿ�-��������
		System.out.println("�ʱ� ȭ������ ���ư��ϴ�");
	}
}
