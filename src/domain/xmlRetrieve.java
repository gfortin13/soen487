package domain;

import util.XMLUtils.XMLRetriever;

public class xmlRetrieve {
	public static void main (String[] args){
		//XMLRetriever.requestXML("http://www.ledevoir.com/rss/ledevoir.xml", "XMLResources/rssNews.xml");
		//XMLRetriever.requestXML("http://marf.cvs.sf.net/viewvc/marf/apps/TestNN/samples/test1.xml?revision=1.1", "XMLResources/marfSample1.xml");
		//XMLRetriever.requestXML("http://users.encs.concordia.ca/~s487_4/project/marfcat-in.xml", "XMLResources/marfcat-in.xml");
		//XMLRetriever.requestXML("http://users.encs.concordia.ca/~s487_4/project/marfcat-out.xml", "XMLResources/marfcat-out.xml");
		XMLRetriever.requestXML("http://users.encs.concordia.ca/~s487_4/examples/soap/faultmessage/faultSample.wsdl", "XMLResources/faultSample.wsdl");
	}
}
