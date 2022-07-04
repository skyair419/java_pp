package game4;

import java.util.Scanner;

public class Start extends Games implements Aaa {  //  Games.java ���� �޼ҵ带 ����ϱ����� extends
	
	
	public Scanner scan = new Scanner(System.in); 
	public Member[] m = new Member[10];// 10ĭ¥�� �迭�� �����ϴµ� �� �濡 ���� ��ҵ��� Member Ÿ��
	
	// �ʱ� ȭ��  
	public void run() {
		while (true) {
			System.out.println();
			System.out.println("1. �α��� | 2. ȸ������ | 3. ����");
			System.out.print(">>");
			int choiceNum = scan.nextInt();
			scan.nextLine(); // ���๮�� ����
			
			// 1�� ���������� ����
			if (choiceNum == 1) {
				if (login()) { // 1�� ������ �α��� ������ ����
					System.out.println("�α��� ����");
					System.out.println();
					runGame(); // ���� ����  Games.java �ȿ��ִ� �޼ҵ� runGame()�� ȣ�� 
				}
				else { // 1�� ������ �α��� ���н� if�� ���������� �ٽ� while�� ù�� ���� �ٽ� ����
					System.out.println("�α��� ����");
				}
			}
			// 2�� ���������� ����
			else if (choiceNum == 2) {
				join(); // ȸ������ �޼ҵ� join() ȣ��
			}
			// 3�� ���������� ����
			else if (choiceNum == 3) {
				exit(); // ���� �޼ҵ� exit() ȣ��
				break;
			}
			// 1,2,3 �̿��� Ű�� �Է��Ҷ� ����
			else {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
			continue;
		}
	}
	
	// �α��� �޼��� 
	public boolean login() {
		System.out.println();
		System.out.println("[�α���]");
		System.out.print("���̵�>>");
		String loginId = scan.nextLine();
		
		System.out.print("��й�ȣ>>");
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
	
	// ȸ������ �޼��� 
	public void join() {
		System.out.println();
		System.out.println("[ȸ������]");
		System.out.print("���̵�:");
		String joinId = scan.nextLine();

		System.out.print("��й�ȣ:");
		String joinPwd = scan.nextLine();

		Member mb = new Member(joinId, joinPwd);// �ּҰ� ����

		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				m[i] = mb;
				System.out.println("ȸ������ ����");
				break;
			}
		}
	}
	
	// ���� �޼���
	public static void exit() {
		System.out.println();
		System.out.println("���α׷� ����");
	}
}