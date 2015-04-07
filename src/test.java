import java.io.IOException;

import TxmgPg.CheckIp;
import TxmgPg.MyFile;
import TxmgPg.myhttp;
public class test {
	// 程序的入口
	public static void main(String args[]) throws IOException {
		MyFile mf1 = new MyFile();
		System.out.println("test eeeeeeeeee");
		myhttp mh1 ;
		mh1 = new myhttp("http://www.txmg.me", "get_tyutu");
		switch (args.length) {
		case 0:
			System.out.println("no args");
			break;
		case 1:
			System.out.println("参数以的输出"+args[0]);
			if(args[0].equals("--help"))
			{
				System.out.println("使用说明：xx.jar --help"
						+ "\n 单个ip xx.jar ip"
						+ "\n c段扫面 xx.jar  起始ip 结束 ip");
			}
			if(args[0].equals("test"))
			{
				System.out.println("hhhh");
				for(int i=160;i<=161;i++)
				{
					for(int j=100;j<255;j++)
					{
						String httpurlstrString = "http://10.20."+i+"."+j;
						System.out.println(httpurlstrString);
						//mf1.writeFileByFileOutputStream("test.txt", httpurlstrString+"\n");
						mh1 = new myhttp(httpurlstrString, "get_tyutu");
						new Thread(mh1,"xianchneg1").start();
						
					}
				}
				break;
				
			}
			mh1 = new myhttp("http://"+args[0], "get");
			new Thread(mh1,"xianchneg1").start();
			break;
		case 2:
			System.out.println("参数二的输出"+args[0]+"   "+args[1]);
			String[] ip1 = args[0].split("\\.");
			String[] ip2 = args[1].split("\\.");
			int i,j;
			//Integer.valueOf();
			System.out.println("ggg");
			System.out.println(Integer.valueOf(ip2[0]));
			for(i=Integer.valueOf(ip1[3]);i<=Integer.valueOf(ip2[3]);i++ )
			{

					String result = ip1[0]+"."+ip1[1]+"."+ip1[2]+"."+i;
					mh1 = new myhttp("http://"+result, "get_tyutu");
					new Thread(mh1,"xianchneg1").start();
					//System.out.println(result);

			}
			break;

		default:
			System.out.println("--help");
			break;
		}
		
		// 向控制台输出信息

	}
}