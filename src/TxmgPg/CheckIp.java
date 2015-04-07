package TxmgPg;

public class CheckIp {
public int Value1;
public int Value2;
public String ip;
	public  boolean CheckIpValue(String ip)
	{
		//System.out.println(ip);
		String[] restr = ip.split("\\.");
		//System.out.println(Integer.valueOf(restr[0]));
		if((CheckValue(Integer.valueOf(restr[0])))&&(CheckValue(Integer.valueOf(restr[1])))&&(CheckValue(Integer.valueOf(restr[2])))&&(CheckValue(Integer.valueOf(restr[3]))))
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	public boolean CheckValue(int Value1)
	{
	return (Value1<=255)&&(Value1>=1) ?true:false;
	}
	public boolean CheckIpRange(String ip1, String ip2)
	{
		//return (Value1<Value2)
		//System.out.println("ip1 "+CheckIpValue(ip1));
	//	System.out.println("ip2 "+CheckIpValue(ip2));
		if((CheckIpValue(ip1))&&(CheckIpValue(ip2)))
		{	
			String[] restr1 = ip1.split("\\.");
			String[] restr2 = ip2.split("\\.");
			if((CheckRange(Integer.valueOf(restr1[0]),Integer.valueOf(restr2[0])))&&(CheckRange(Integer.valueOf(restr1[1]),Integer.valueOf(restr2[1])))&&(CheckRange(Integer.valueOf(restr1[2]),Integer.valueOf(restr2[2])))&&(CheckRange(Integer.valueOf(restr1[3]),Integer.valueOf(restr2[3]))))
			{
				// CheckRange(Integer.valueOf(restr[0]))
				return true;
			}
			else {
				return false;
				
			}
		}
		else
		{
			return false;
		}
		
	}
	public boolean CheckRange(int Value1, int Value2)
	{
		return (Value1<=Value2) ?true:false;
	}

}
