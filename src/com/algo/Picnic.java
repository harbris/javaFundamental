package com.algo;
/*
����

�ȵ�θ޴� ��ġ�� �ͽ��������ݿ����� ���� �ֿ� ������������ ��ǳ�� ���ϴ�. 
���� �������� ��ǳ �� �л����� �� ���� ¦�� ���� �ൿ�ϰ� �Ϸ��� �մϴ�. 
�׷��� ���� ģ���� �ƴ� �л��鳢�� ¦�� ���� �ָ� ���� �ο�ų� ���� ���ƴٴ��� �ʱ� ������, 
�׻� ���� ģ���� �л��鳢���� ¦�� ���� ��� �մϴ�.

�� �л����� �ֿ� ���� �̵��� ���� ģ������ ���ΰ� �־��� ��, 
�л����� ¦������ �� �ִ� ����� ���� ����ϴ� ���α׷��� �ۼ��ϼ���. 
¦�� �Ǵ� �л����� �Ϻθ� �ٸ����� �ٸ� ����̶�� ���ϴ�. 
���� ��� ���� �� ���� ����� ���� �ٸ� ����Դϴ�.

(�¿�,����ī) (���,Ƽ�Ĵ�) (ȿ��,����)
(�¿�,����ī) (���,����) (ȿ��,Ƽ�Ĵ�)

�Է�

�Է��� ù �ٿ��� �׽�Ʈ ���̽��� �� C (C <= 50) �� �־����ϴ�. 
�� �׽�Ʈ ���̽��� ù �ٿ��� �л��� �� n (2 <= n <= 10) �� ģ�� ���� �� m (0 <= m <= n*(n-1)/2) �� �־����ϴ�. 
�� ���� �ٿ� m ���� ���� ������ ���� ģ���� �� �л��� ��ȣ�� �־����ϴ�. 
��ȣ�� ��� 0 ���� n-1 ������ �����̰�, ���� ���� �Է¿� �� �� �־����� �ʽ��ϴ�. �л����� ���� ¦���Դϴ�.

���

�� �׽�Ʈ ���̽����� �� �ٿ� ��� �л��� ģ�������� ¦������ �� �ִ� ����� ���� ����մϴ�. 

���� �Է�

3 
2 1 
0 1 
4 6 
0 1 1 2 2 3 3 0 0 2 1 3 
6 10 
0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5

���� ���

1
3
4
 
*/

public class Picnic {

	
	static Boolean[][] areFriends = new Boolean[10][10];
	static int n = 0;
	

	public static void main(String[] args) {
		areFriends[0][1] = true;
		areFriends[0][2] = true;
		areFriends[1][2] = true;
		areFriends[1][3] = true;
		areFriends[1][4] = true;
		areFriends[2][3] = true;
		areFriends[2][4] = true;
		areFriends[3][4] = true;
		areFriends[3][5] = true;
		areFriends[4][5] = true;
		Boolean[] test = new Boolean[10];
		System.out.print(countPairings(test));
	}

	static int countPairings(Boolean[] test){
		int firstFree = -1;
		
		for(int i=0; i <n; ++i){
			if(!test[i]){
				firstFree = i;
				break;
			}
		}

		if(firstFree == -1) return 1;
		int ret = 0;
		for(int pairWith = firstFree+1 ; pairWith < n; ++pairWith){
			if(!test[pairWith] && areFriends[firstFree][pairWith]){
				test[firstFree] = test[pairWith] = true;
				ret += countPairings(test);
				test[firstFree] = test[pairWith] = false;
			}
		}
		
		return ret;
	}
	
}