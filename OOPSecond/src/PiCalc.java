
public class PiCalc {
	public static void main(String[] args) {
		double pi=2;
		double left = 1;
		double right = 1;
		System.out.println(pi);
		for (int i = 1; i < 1000; i++) {
			left = (2*i)/(2*i-1);
			right = (2*i)/(2*i+1);
			pi=pi*left*right;
		}
		
System.out.println(pi);
		double pii=0;
		double nevezo = 1;
		double tort = 1;
		for (int i = 0; i < 10000; i++) {
			tort = 1/nevezo;
			nevezo = nevezo + 2;
			if (i%2==0) {
				pii+=tort;
			} else {
			    pii-=tort;
			}
		}
		pii = pii*4;
		System.out.println(pii);
	}
}
