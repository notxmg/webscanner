import java.io.IOException;

import TxmgPg.CheckIp;
import TxmgPg.MyFile;
import TxmgPg.myhttp;
public class test {
	// ��������
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
			System.out.println("�����Ե����"+args[0]);
			if(args[0].equals("--help"))
			{
				System.out.println("ʹ��˵����xx.jar --help"
						+ "\n ����ip xx.jar ip"
						+ "\n c��ɨ�� xx.jar  ��ʼip ���� ip");
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
			System.out.println("�����������"+args[0]+"   "+args[1]);
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
		
		// �����̨�����Ϣ

	}
}