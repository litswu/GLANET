/**
 * 
 */
package biostar;

import gov.nih.nlm.ncbi.snp.docsum.Assembly;
import gov.nih.nlm.ncbi.snp.docsum.Component;
import gov.nih.nlm.ncbi.snp.docsum.MapLoc;
import gov.nih.nlm.ncbi.snp.docsum.Rs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import auxiliary.FileOperations;

import common.Commons;

/**
 * @author burcakotlu
 *
 */
public class Biostar95284
{
	private Unmarshaller unmarshaller;
	private static gov.nih.nlm.ncbi.snp.docsum.ObjectFactory _fool_javac=null;
	private  XMLInputFactory xmlInputFactory=null;
	
	private Biostar95284() throws Exception
    {
		this.xmlInputFactory = XMLInputFactory.newInstance();
		xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);
		xmlInputFactory.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);
		xmlInputFactory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
    	
		xmlInputFactory.setXMLResolver(new javax.xml.stream.XMLResolver()
        {
            	@Override
            	public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace)
                {
            		return new java.io.ByteArrayInputStream(new byte[0]);
                }
        });

		JAXBContext jaxbCtxt=JAXBContext.newInstance("gov.nih.nlm.ncbi.snp.docsum");
		this.unmarshaller=jaxbCtxt.createUnmarshaller();

    }
	
	
	private void run(String rsId,BufferedWriter bufferedWriter) throws Exception
    {

		if(rsId.startsWith("rs")) 
			
			rsId=rsId.substring(2);
			
			String uri="http://www.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=snp&id="+rsId+"&retmode=xml";
        
			XMLEventReader reader= xmlInputFactory.createXMLEventReader(new StreamSource(uri)); 

			while(reader.hasNext())
            {
				XMLEvent evt=reader.peek();

				if(!evt.isStartElement())
                {
					reader.nextEvent();
					continue;
                }

				StartElement start=evt.asStartElement();
				String localName=start.getName().getLocalPart();

				if(!localName.equals("Rs"))
                {
					reader.nextEvent();
					continue;
                }

				Rs rs=unmarshaller.unmarshal(reader, Rs.class).getValue();
				
				

				for(Assembly as:rs.getAssembly())
                {  
					
					
                    for(Component comp:as.getComponent())
                    {
                    	
                    	
	                   for(MapLoc maploc: comp.getMapLoc())
	                   {
	                       bufferedWriter.write("rs"+rsId);
	                       bufferedWriter.write("\t");
	                       bufferedWriter.write(as.getGenomeBuild());
	                       bufferedWriter.write("\t");
	                       bufferedWriter.write(as.getGroupLabel());
	                       bufferedWriter.write("\t");
	                       
	                       //Observed Alleles
	                       bufferedWriter.write(rs.getSequence().getObserved());
	                       bufferedWriter.write("\t");
                     
	                       
//	                       //debug
//	   						List<Rs.AlleleOrigin> alleleOrigin = rs.getAlleleOrigin();
//	   						if(alleleOrigin.isEmpty()){
//	   							System.out.print("empty");
//	   						}else{
//	   							for(Rs.AlleleOrigin allele: alleleOrigin){
//	   								System.out.print(allele.toString());
//	   							}
//
//	   						}
//	   						System.out.print("\t");	   						
//	                       //debug
	                      
	                       bufferedWriter.write(comp.getChromosome());
	                       bufferedWriter.write("\t");
	                       
//	                       if(maploc.getPhysMapInt()!=null){
	                    	   bufferedWriter.write(maploc.getPhysMapInt());
	                    	   
//	                       }
	                       
	                       bufferedWriter.write("\n");

	                        
	                   }//End of for Maploc
                    }//End of for Component
                }//End of for Assembly
				
            }//End of while
			
        	reader.close();
    }


	public void readRsIDInputFileandWriteAugmentedOutputFile(String inputFileName, String outputFileName){
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		String rsId= null;
		
		try {
			
			fileReader = new FileReader(inputFileName);
			bufferedReader = new BufferedReader(fileReader);
			
			fileWriter = FileOperations.createFileWriter(outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			while((rsId = bufferedReader.readLine())!=null){
				this.run(rsId.substring(2),bufferedWriter);
			}
			
			bufferedReader.close();
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
     
	}
	     
	public static void main(String[] args)
    {
		    Biostar95284 app=null;
			try {
				app = new Biostar95284();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        String inputFileName = Commons.OCD_GWAS_SIGNIFICANT_SNPS_RSIDS_INPUT_FILE_NAME_TEST;
	        String outputFileName = Commons.OCD_GWAS_SIGNIFICANT_SNPS_RSIDS_OUTPUT_FILE_NAME;
	        
	        app.readRsIDInputFileandWriteAugmentedOutputFile(inputFileName,outputFileName);
	        
	       
	    
    }
}
