package sinkadotcom;

import java.io.*;
import java.util.*;

public class GameHelper {
	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int [] grid = new int[gridSize];
	private int comCount = 0;
	
	public String getUserInput(String prompt) {
		String inputLine = null;
		//System.out.print(prompt + "  ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length() == 0) {
				return null;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}
	
	public ArrayList<String> placeDotCom(int comSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		//String [] alphacoords = new String [comSize];	//�����ַ���
		String temp = null;	//��ʱ�ַ���
		int [] coords = new int[comSize];	//�����ַ���
		int attempts = 0;	//Ŀǰ���Ե��ַ���
		boolean success = false;	//�ҵ��ʺϵ�λ������
		int location = 0;	//Ŀǰ���
		
		comCount++;	//���ڴ�����n��
		int incr = 1;	//ˮƽ����
		if((comCount % 2) == 1) {	//����ǵ����ŵ�
			incr = gridLength;	//��ֱ����
		}
		
		while(!success && attempts++ < 200) {	//��Ҫ����ѭ��
			location = (int) (Math.random() * gridSize);	//������
			//System.out.print(" try " + location);
			int x = 0;	//��n��λ��
			success = true;	//�ٶ��ɹ�
			while(success && x < comSize) {	//����δʹ�õĵ�
				if(grid[location] == 0) {	//���û��ʹ��
					coords[x++] = location;	//����λ��
					location += incr;	//������һ��λ��
					if(location >= gridSize) {	//�����±�Ե
						success = false;	//ʧ��
					}
					if(x > 0 && (location % gridLength == 0)) {	//�����ұ�Ե
						success = false;	//ʧ��
					}
				}
				else {	//�ҵ��Ѿ�ʹ�õ�λ��
					//System.out.println(" used " + location);
					success = false;	//ʧ��
				}
			}
		}
		
		int x = 0;	//��λ��ת�����ַ�����ʽ
		int row = 0;
		int column = 0;
		//System.out.println("\n");
		while(x < comSize) {
			grid[coords[x]] = 1;	//��ʶ��������
			row = (int) (coords[x] % gridLength);	//�õ��е�ֵ
			column = coords[x] % gridLength;	//�õ��е�ֵ
			temp = String.valueOf(alphabet.charAt(column));	//ת�����ַ���
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			//System.out.print("  coord " + x + " = " + alphaCells.get(x-1));
		}
		//System.out.println("\n");
		return alphaCells;
	}
}
