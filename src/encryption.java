import javax.xml.bind.ParseConversionEvent;

import config.Configurations;


public class encryption {
	public String decrypt(byte[] b)
	{
		Configurations CF = new Configurations();

		String crypKey = CF.getFfcryptkey();
		double gladKo = Double.parseDouble(crypKey);
		byte ff = (byte) gladKo;
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
		String encrypted = new String(b).trim();
		return encrypted;
	}
}
