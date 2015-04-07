package TxmgPg;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class myhttp extends Thread implements Runnable{
	public String HttpUrl;
	public String Param;
	//public String 
	public myhttp(String HttpUrl,String Param)
	{
		this.HttpUrl = HttpUrl;
		this.Param = Param;
	}
	public void run()
	{
		
		//HttpGet(HttpUrl, Param);
		MyFile mf1 = new MyFile();
		mf1.createFile("test22.txt");
		try {
			mf1.writeFileByFileOutputStream("http_result.txt", HttpGet(HttpUrl, Param));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("dddddddd233");
	}
	public String HttpGet(String HttpUrl,String Param)
	{
		String result="";
		BufferedReader in =null;
		
		try{
			//String urlNameString = HttpUrl+"?id="+Param;
			String urlNameString = HttpUrl;//+"?id="+Param;
			//System.out.println(urlNameString);
			URL readUrl = new URL(urlNameString);
			URLConnection connection = readUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000); //超时时间
            connection.connect();
            System.out.println(HttpUrl+connection.getHeaderFields());
            result = HttpUrl+connection.getHeaderFields()+"\n";
            Map<String, List<String>> map = connection.getHeaderFields();
            String stateString = map.get(null).toString();
           // System.out.println(map.get(null));
            for(String key :map.keySet()){
            	//System.out.println(key + "--->"+map.get(key));
            }
            
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = in.readLine())!=null){
            	//result += line;
            }
            if(stateString.equals("[HTTP/1.1 200 OK]"))
            {
            	//System.out.println("dddddddok");           	
            }
		}
		catch (Exception e)
		{
			System.out.println(HttpUrl+"发送GET请求除出现异常"+e);
			//e.printStackTrace();
		}
		//result = result
		//System.out.print(HttpUrl);
		return result;
	}
	public boolean checkstate(String HttpUrl,String Param)
	{
		String result="";
		boolean flag=false;
		BufferedReader in =null;
		try{
			//String urlNameString = HttpUrl+"?id="+Param;
			String urlNameString = HttpUrl;//+"?id="+Param;
			//System.out.println(urlNameString);
			URL readUrl = new URL(urlNameString);
			URLConnection connection = readUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            System.out.println(connection.getHeaderFields());
            Map<String, List<String>> map = connection.getHeaderFields();
            String stateString = map.get(null).toString();
            //System.out.println(map.get(null));
            for(String key :map.keySet()){
            	System.out.println(key + "--->"+map.get(key));
            }
            
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = in.readLine())!=null){
            	result += line;
            }
            if(stateString.equals("[HTTP/1.1 200 OK]"))
            {
            	//System.out.println("dddddddok"); 
            	flag = true;
            }
		}
		catch (Exception e)
		{
			//System.out.println("发送GET请求除出现异常"+e);
			//e.printStackTrace();
		}
		return flag;
	}

}
