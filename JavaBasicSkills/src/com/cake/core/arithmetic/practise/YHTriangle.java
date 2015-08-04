package com.cake.core.arithmetic.practise;
/**
 * 输出打印 杨辉三角,主要练习算法,思路非常简单.
 * @author horsttop
 *
 */
public class YHTriangle {
	
	public static void main(String[] args) {
		validate(50);
	}
	private static void validate(int maxLines) {
		//第一行和第二行是输出基础
		int[] a1 = {1};
		printSpace(maxLines, a1.length);
		System.out.println(a1[0]);
		int[] a2 = {1,1};
		printSpace(maxLines, a2.length);
		System.out.println(a2[0]+"   "+a2[1]);
		int line=3;
		int[] temp = null;
		int[] aline;
		//do-while循环比较好用
		do {
			aline= new int[line];
				if(line==3){
					//在第二行的基础上打印
					 temp=a2;
					for (int i = 0; i < aline.length; i++) {
						if(i==0){
							aline[i]=1;
							//continue终结循环该次遍历,比较好用
							continue;
						}
						if(i==(aline.length-1)){
							aline[i]=1;
							temp =aline;
							continue;
						}
						else{
							//这是杨辉三角的核心逻辑
							aline[i]=temp[i-1]+temp[i];
						}
					}
					//格式化输出该行和占位符
					printSpace(maxLines, aline.length);
					for(int i=0;i<aline.length;i++)
						if(i<aline.length-1)
						{
							System.out.printf(aline[i]+"");
							if(aline[i]<10)
								System.out.printf("   ");
							else if(aline[i]<100)
								System.out.printf("  ");
							else if(aline[i]<1000)
								System.out.printf(" ");
						}
						
						else
							System.out.println(aline[i]);
						
				} else{
					for (int i = 0; i < aline.length; i++) {
						if(i==0){
							aline[i]=1;
							continue;
						}
						if(i==(aline.length-1)){
							aline[i]=1;
							temp = aline;
							continue;
						}
						else{
							aline[i]=temp[i-1]+temp[i];
						}
					}
					printSpace(maxLines, aline.length);
					for(int i=0;i<aline.length;i++)
						if(i<aline.length-1)
						{
							System.out.printf(aline[i]+"");
							if(aline[i]<10)
								System.out.printf("   ");
							else if(aline[i]<100)
								System.out.printf("  ");
							else if(aline[i]<1000)
								System.out.printf(" ");
						}
							else
								System.out.println(aline[i]);
				}
			
		} while (line++<maxLines);
	}
	//格式化输出占位符
	private static void printSpace(int max,int length) {
		int count = (max-length);
		for(int i=0;i<count;i++){
			System.out.printf("  ");
		}
	}
}
