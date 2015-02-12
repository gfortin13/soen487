package util.XMLUtils;

public class XMLReader {

	public static void read(String url){
		XMLParser.parse(XMLRetriever.requestXML(url, "lol"));
	}
	
	public static void readRSS(String url, String rootTags){
		XMLParser.parse(XMLRetriever.requestXML(url, "lol"), rootTags);
	}

}
