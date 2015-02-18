package util.XMLUtils;

public class XMLReader {

	public static void read(String url, String type){
		switch (type) {
	        case "RSS":  
	        	XMLParser.parse(XMLRetriever.requestXML(url, ""), "title");
	            break;
	        case "NN":
	        	XMLParser.parse(XMLRetriever.requestXML(url, ""));
	        	break;
	        case "MARFCAT-IN":
	        	XMLParser.parse(XMLRetriever.getDoc(url));
	    		break;
	        case "MARFCAT-OUT":
	        	XMLParser.parse(XMLRetriever.getDoc(url));
	    		break;
	        case "WSDL":
	        	XMLParser.parse(XMLRetriever.getDoc(url));
	    		break;
	        default: 
	        	XMLParser.parse(XMLRetriever.requestXML(url, ""));
	            break;
	    }
		
	}
}
